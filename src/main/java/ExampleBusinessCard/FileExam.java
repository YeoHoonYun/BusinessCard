package ExampleBusinessCard;

import java.io.File;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-18
 * Github : https://github.com/YeoHoonYun
 */
public class FileExam {
    public static void main(String[] args) {
        // 어떤파일이 있느냐? 없느냐?
        // 자손에 대한 Exception이 발생하면 throws를 발생할 필요가 없다.
        File file = new File("");
        if(file.exists()){
            System.out.println("Ok!");
        }else{
            System.out.println("not found");
        }
    }
}
