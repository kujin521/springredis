package com.kujin.springredis;

import redis.clients.jedis.Jedis;

/**
 * 类：在java中使用Redis
 * 编写人：kujin
 * 创建时间：2020/7/23
 * 修改时间：2020/7/23
 */
public class Java_Redis_Text {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.2.168",6379);
        jedis.auth("kujin");

        int i=0;
        try {
            long start = System.currentTimeMillis();
            while (true){
                long end = System.currentTimeMillis();
                if (end-start>=1000){
                    break;
                }
                i++;
                jedis.set("test"+i,i+"");
            }
        }finally {
            jedis.close();
        }

        System.out.println("redis每秒操作 "+ i+ "次");

    }
}
