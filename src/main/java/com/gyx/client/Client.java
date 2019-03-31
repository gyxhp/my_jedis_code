package com.gyx.client;

import com.gyx.connection.Conncetion;
import com.gyx.protocal.Protocal;

/**
 * Created by hp on 2019/3/18.
 */
public class Client {
    Conncetion conncetion;

    public Client(String host,int port) {
        this.conncetion = new Conncetion(host,port);
    }

    public String set(String key, String value){
        //todo
        conncetion.sendConmmond(Protocal.Commond.SET,key.getBytes(),value.getBytes());
        return conncetion.getStatusCodeReply();
    }

    public String get(String key){
        conncetion.sendConmmond(Protocal.Commond.GET,key.getBytes());
        return conncetion.getStatusCodeReply();
    }
}
