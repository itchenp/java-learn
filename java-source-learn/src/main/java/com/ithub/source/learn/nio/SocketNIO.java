package com.ithub.source.learn.nio;

import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * none blocking IO
 */
@Slf4j
public class SocketNIO {

    public static void main(String[] args) throws Exception {
        LinkedList<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9990));
        ss.configureBlocking(false);
        while (true){
            Thread.sleep(1000);
            SocketChannel client = ss.accept();
            if(client == null){
                log.warn("null ......");
            }else{
                client.configureBlocking(false);
                int port = client.socket().getPort();
                log.info("client ... port : {}",port);
                clients.add(client);
            }
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            for (SocketChannel c : clients) {
                int num = c.read(buffer);
                if(num>0){
                    buffer.flip();
                    byte[] aa = new byte[buffer.limit()];
                    buffer.get(aa);
                    String b = new String(aa);
                    log.info("{} : {}",c.socket().getPort(),b);
                    buffer.clear();
                }
            }
        }


    }
}
