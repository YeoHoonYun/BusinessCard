package BusinessCardDAO;

import BusinessCardDAO.DAO.BusinessCardDAO;
import BusinessCardDAO.VO.BusinessCardDTO;

import java.io.IOException;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BusinessCardExam {
    public static void main(String[] args) throws IOException {
        BusinessCardDTO businessCardDTO = new BusinessCardDTO();
        BusinessCardDAO businessCardDAO = new BusinessCardDAO(businessCardDTO);
        String url = ".\\BusinessCardDAO.json";

        //파일이 존재하면 리스트를 DAO에 저장
        businessCardDAO.readFile(url);

        //조회
        businessCardDAO.selectCard();
        //삽입
        businessCardDAO.addCard("Yun", "010-1111-1111", "Python");
        businessCardDAO.addCard("Kim", "010-2222-2222", "Java");
        businessCardDAO.addCard("Hong", "010-3333-3333", "Scala");
        businessCardDAO.addCard("Kang", "010-4444-4444", "Go");
        //조회
        businessCardDAO.selectCard();
        //삭제
        businessCardDAO.deleteCard(1);
        //조회
        businessCardDAO.selectCard();
        //수정
        businessCardDAO.modifyCard(2, "Cho");
        //조회
        businessCardDAO.selectCard();
        //파일 저장
        businessCardDAO.writeFile(url);
    }
}