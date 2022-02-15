package com.ithub.source.learn.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO
 */
@Slf4j
public class SocketIO {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9990);
        log.info("step1: new ServerSocket(9990)");
        Socket client = server.accept();
        log.info("step2: client\t {}",client.getPort());
        InputStream in = client.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        System.out.println(reader.readLine());


    }
}
