package ExampleBusinessCard;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-18
 * Github : https://github.com/YeoHoonYun
 */
public class MyException extends RuntimeException{
    public MyException(String msg){
        super(msg); // 부모의 생성자를 호출
    }

    public MyException(Exception ex){
        super(ex); // 부모의 생성자를 호출
    }
}
