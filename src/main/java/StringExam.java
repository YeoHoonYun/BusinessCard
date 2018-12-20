/**
 * Created by cjswo9207u@gmail.com on 2018-12-20
 * Github : https://github.com/YeoHoonYun
 */
public class StringExam {
    public static void main(String[] args) {
        // String을 쓰는데, new로 인스턴스를 할 필요가 없다. OCJP
        String str = new String("hello");
        String str2 = new String("hello2");
        String str3 = "hello";
        String str4 = "hello";
        String subString = str.substring(3);
        System.out.println(subString);
        System.out.println(str);

        if(str.equals(str2)){
            System.out.println("str equals str2");
        }
        if(str == str2) {
            System.out.println("str == str2");
        }
        if(str.equals(str3)){
            System.out.println("str equals str3");
        }
        if(str == str3){
            System.out.println("str == str3");
        }
        if(str3 == str4){
            System.out.println("str3 == str4");
        }
    }
}
