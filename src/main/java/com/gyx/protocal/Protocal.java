package com.gyx.protocal;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by hp on 2019/3/18.
 */
public class Protocal {
    private static final String DOLLAR_BYTE = "$";
    private static final String STARISK_BYTE = "*";
    private static final String BLACK_BYTE = "\r\n";

    /**
     * 数据组装
     */
    public static void sendCommond(OutputStream outputStream,Commond commond,byte[] ... args){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(STARISK_BYTE).append(args.length+1).append(BLACK_BYTE)
                .append(DOLLAR_BYTE).append(commond.name().length()).append(BLACK_BYTE)
                .append(commond.name()).append(BLACK_BYTE);
        for (final byte[] arg:args) {
            stringBuilder.append(DOLLAR_BYTE).append(arg.length).append(BLACK_BYTE)
                    .append(new String(arg)).append(BLACK_BYTE);
        }
        try {
            outputStream.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static enum Commond{
        SET,GET,KEYS
    }
}
