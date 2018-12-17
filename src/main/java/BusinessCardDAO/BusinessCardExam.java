package BusinessCardDAO;

import BusinessCardDAO.DAO.BusinessCardDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BusinessCardExam {
    public static void main(String[] args) throws IOException {
        String url = ".\\BusinessCardDAO.json";
        BusinessCardDAO businessCardDAO = new BusinessCardDAO();

        Path path = Paths.get(url);
        System.out.println(path);

        if (Files.exists(path)) {
            businessCardDAO.selectCard();
            System.out.println("파일 실행");
            businessCardDAO.readFile(url);
        }

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
        businessCardDAO.deleteCard(1, "Yun");
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
