package BusinessCardDAO;

import BusinessCardDAO.UI.BusinessCardUI;
import java.io.IOException;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BusinessCardExam {
    public static void main(String[] args) throws IOException {
        String url = ".\\BusinessCardDAO.json";
        BusinessCardUI businessCardUI = new BusinessCardUI(url);
        //한페이지 당 출력하는 정보 설정
//        businessCardUI.setMaxNum(3);
//        System.out.println(url);
        businessCardUI.selectMenu();
    }
}