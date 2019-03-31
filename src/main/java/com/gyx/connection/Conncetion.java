package com.gyx.connection;


import com.gyx.protocal.Protocal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Conncetion{
    private Socket socket;
    private String host;
    private int  port;
    private InputStream inputStream;
    private OutputStream outputStream;

    public Conncetion() {
    }

    public Conncetion(String host, int port){
        this.host = host;
        this.port = port;
    }

    public Conncetion connection(){
        try {
            if(!isConnection()){
                socket = new Socket(host,port);
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return this;
    }

    public Conncetion sendConmmond( Protocal.Commond commond, byte[] ... args){
        connection();
        Protocal.sendCommond(outputStream,commond,args);
        return this;
    }

    public String getStatusCodeReply(){
        byte[] bytes = new byte[1024];
        try {
            socket.getInputStream().read(bytes);
        }catch (IOException e){
            e.printStackTrace();
        }
        return new String(bytes);
    }

    public boolean isConnection(){
        return socket != null ? true : false;
    }
}