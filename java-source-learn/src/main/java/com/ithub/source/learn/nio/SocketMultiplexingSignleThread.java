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

/**
 * select 多路复用器
 */
@Slf4j
public class SocketMultiplexingSignleThread {

    private ServerSocketChannel server = null;
    private Selector selector = null; // 多路复用器
    int port = 9990;

    public void initServer(){
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));
            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
        }catch (IOException e){
            log.error("IOException {}",e);
        }
    }

    public void start(){
        initServer();
        log.info("server is start ...");
        try {
            while (true){
                while (selector.select(0)>0){
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if(key.isAcceptable()){
                            acceptHandler(key);
                        }else if(key.isReadable()){
                            readHandler(key);
                        }
                    }
                }
            }
        }catch (IOException e){
            log.error("IOException {}",e);
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
            ByteBuffer buffer = ByteBuffer.allocate(8192);
            client.register(selector,SelectionKey.OP_READ,buffer);
            log.info("----------------------------------------");
            log.info("new client: {}",client.getRemoteAddress());
            log.info("----------------------------------------");
        }catch (IOException e){
            log.error("IOException {}",e);
        }
    }

    public static void main(String[] args) {
        SocketMultiplexingSignleThread socket = new SocketMultiplexingSignleThread();
        socket.start();
    }
}
