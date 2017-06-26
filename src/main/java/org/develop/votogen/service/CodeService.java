package org.develop.votogen.service;

import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.ByteBuffer;


/**
 *
 * Created by donat on 31-Mar-17.
 */
public class CodeService {

    public String codeService () {

        //Calendar c = Calendar.getInstance();
        long milisecond = System.nanoTime(); //c.get(Calendar.MILLISECOND);

        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(milisecond);
        String precode = Base64.encodeBase64String(buffer.array());

        String code = precode.substring(6,11);
        //System.out.println(code);

        return code;
    }

}
