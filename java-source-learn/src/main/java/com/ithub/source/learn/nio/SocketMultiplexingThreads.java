package com.ithub.source.learn.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SocketMultiplexingThreads {

    private ServerSocketChannel server = null;
    private Selector selector1 = null;
    private Selector selector2 = null;
    private Selector selector3 = null;
    int port = 9990;

    public void initServer(){
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            selector1 = Selector.open();
            selector2 = Selector.open();
            selector3 = Selector.open();

            server.register(selector1, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            log.error("IOException {}",e);
        }
    }

    public static void main(String[] args) {
        SocketMultiplexingThreads service = new SocketMultiplexingThreads();
        service.initServer();
        NioThread T1 = new NioThread(service.selector1,2);
        NioThread T2 = new NioThread(service.selector2);
        NioThread T3 = new NioThread(service.selector3);

        T1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("InterruptedException {}",e);
        }

        T2.start();
        T3.start();
        try {
            System.in.read();
        } catch (IOException e) {
            log.error("IOException {}",e);
        }

    }
}

@Slf4j
class NioThread extends Thread {
    Selector selector = null;
    static int selectors = 0;

    int id = 0;
    boolean boss = false;

    static BlockingDeque<SocketChannel>[] queue;

    static AtomicInteger idx = new AtomicInteger();

    NioThread(Selector selector,int n){
        this.selector = selector;
        this.selectors = n;
        boss = true;

        queue = new LinkedBlockingDeque[selectors];
        for (int i = 0; i < n; i++) {
            queue[i] = new LinkedBlockingDeque<>();
        }
        log.info("Boss start");
    }

    NioThread(Selector selector){
        this.selector = selector;
        id = idx.getAndIncrement() % selectors;
        log.info("Worker : {} start",id);
    }

    @Override
    public void run() {
        try {
            while (true){
                while (selector.select(10)>0){
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = selectionKeys.iterator();
                    while (iter.hasNext()){
                        SelectionKey key = iter.next();
                        iter.remove();
                        if(key.isAcceptable()){
                            acceptHandler(key);
                        }else if(key.isReadable()){
                            readHandler(key);
                        }
                    }
                }


                if(!boss && !queue[id].isEmpty()){
                    ByteBuffer buffer = ByteBuffer.allocate(8192);
                    SocketChannel client = queue[id].take();
                    client.register(selector,SelectionKey.OP_READ,buffer);
                    log.info("-------------------------------------------");
                    log.info("新客户端： {} 分配到worker： {}",client.socket().getPort(),id);
                    log.info("-------------------------------------------");
                }
            }
        } catch (IOException | InterruptedException e) {
            log.error("IOException | InterruptedException {}",e);
        }
    }

    private void readHandler(SelectionKey key) {
        SocketChannel client = (SocketChannel)key.channel();
        ByteBuffer buffer =(ByteBuffer) key.attachment();
        buffer.clear();
        int read = 0;
        try {
            while (true){
                read = client.read(buffer);
                if(read>0){
                    buffer.flip();
                    while (buffer.hasRemaining()){
                        client.write(buffer);
                    }
                    buffer.clear();
                }else if(read ==0){
                    break;
                }else {
                    log.error("null point request ...");
                    client.close();
                    break;
                }
            }
        }catch (IOException e){
            log.error("IOException {}",e);
        }

    }

    private void acceptHandler(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
            SocketChannel client = ssc.accept();
            client.configureBlocking(false);

            int num = idx.getAndIncrement() % selectors;

            queue[num].add(client);

        }catch (IOException e){
            log.error("IOException {}",e);
        }
    }
}

