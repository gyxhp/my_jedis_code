package com.gyx.test;

import com.gyx.client.Client;


/**
 * Created by hp on 2019/3/18.
 */
public class Test {
    public static void main(String[] args) {
        Client jedis = new Client("127.0.0.1",6379);
        String gyx = jedis.set("gyx", "110");
        System.out.println(gyx);
        System.out.println(jedis.get("gyx"));
    }
}
