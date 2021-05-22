package com.rao.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StreamDemo {
    static public void buffered() throws IOException {
        BufferedReader reader = new BufferedReader(new  InputStreamReader(System.in));
        String line = null;
        while ( !"exit".equals ((line = reader.readLine()))){
            System.out.println(line);
        }


    }

    public static void main(String[] args) throws IOException {
        buffered();
        System.out.println("scanner");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            System.out.println("请输入");

            System.out.println(String.format("j: %d", sc.nextInt()));
        }

        System.out.println("---------------");
        while(!sc.hasNext("0"))
        {
            // 输出输入项
            System.out.println("键盘输入的内容是："
                    + sc.next());
        }
        System.out.println("执行吗");

    }
}
