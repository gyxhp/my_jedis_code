package com.gyx.heck;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hp on 2019/3/18.
 */
public class heck {

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(6378);
        Socket accept = serverSocket.accept();
        byte[] bytes = new byte[1024];
        accept.getInputStream().read(bytes);
        System.out.println(new String(bytes));
    }
}
