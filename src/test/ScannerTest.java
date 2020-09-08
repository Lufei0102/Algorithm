package test;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        //直接调用Scanner类的next（）读取字符串的方法
        String str = "";
        System.out.println("你的名字");
        Scanner scanner = new Scanner(System.in);

        while (true){
            str = scanner.next();
            System.out.println("你们名字是"+str);
        }
    }
}
