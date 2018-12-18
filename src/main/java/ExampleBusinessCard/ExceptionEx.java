package ExampleBusinessCard;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-18
 * Github : https://github.com/YeoHoonYun
 */
public class ExceptionEx {
    public static void main(String args[])
    {
        PrintStream ps = null;
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("error.log", true);
            ps = new PrintStream(fos);
            System.setErr(ps);

            System.out.println(1);
            System.out.println(2);
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(5);
        } catch(Exception ee) {
            System.err.println("---------------------");
            System.err.println("예외발생시간 : " + new Date());
            ee.printStackTrace(System.err);
            System.err.println("예외메시지 : " + ee.getMessage());
            System.err.println("---------------------");
        }
        System.out.println(6);
    }
}
