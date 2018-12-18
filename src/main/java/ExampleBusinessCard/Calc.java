package ExampleBusinessCard;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-18
 * Github : https://github.com/YeoHoonYun
 */

/**
 * Calc
 *
 * 계산을 위한 클래스
 */
public class Calc {
    /**
     * i를 k로 나눈 결과를 리턴한다.
     * 0 으로 나눌경우 ArithmeticException이 발생합니다.
     * @param i
     * @param k
     * @return
     * @throws MyException
     */
    public int divide(int i, int k) throws MyException{
        int value = 0;
        try {
            value = i / k;
        }catch(ArithmeticException ae){
            // 에러처리. ex> log를 남긴다.
            throw new MyException(ae);
        }
        return value;
    }
}

