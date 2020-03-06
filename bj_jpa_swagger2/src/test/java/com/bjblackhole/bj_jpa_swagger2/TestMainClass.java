package com.bjblackhole.bj_jpa_swagger2;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * ClassName:TestMainClass
 * Package:com.bjblackhole.bj_jpa_swagger2
 * Description:
 *
 * @Date:2020/03/04 0004 15:48
 * @Author:mavin001@163.com
 */
public class TestMainClass {

    @Test
    void testdemo(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str="2020-03-04 15:45:28";
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(simpleDateFormat.parse(str));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
