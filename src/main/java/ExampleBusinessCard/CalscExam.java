package ExampleBusinessCard;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-18
 * Github : https://github.com/YeoHoonYun
 */
public class CalscExam {
    public static void main(String[] args){
        Calc calc = new Calc();
        try {
            int value = calc.divide(4, 0);

            System.out.println(value);
        }catch(MyException me){
            System.out.println("내가 생성한 Exception ");
        }
    }
}
