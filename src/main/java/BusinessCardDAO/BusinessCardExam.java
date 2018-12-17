package BusinessCardDAO;

import BusinessCardDAO.DAO.BusinessCardDAO;
import BusinessCardDAO.VO.BusinnessCardVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BusinessCardExam {
    public static void main(String[] args) throws IOException {
        String url = ".\\BusinessCardDAO.json";
        BusinessCardDAO businessCardDAO = new BusinessCardDAO();

        BusinnessCardVO businessCard1;
        BusinnessCardVO businessCard2;
        BusinnessCardVO businessCard3;
        List<BusinnessCardVO> businessCardList;
        BusinessCardDAO businessCardData;

        businessCardList = new ArrayList<>();
        businessCard1 = new BusinnessCardVO(1,"kim sungpark", "010-1111-2222", "sunnyvale");
        businessCard2 = new BusinnessCardVO(2,"kang kyungmi", "010-1111-3333", "sunnyvale");
        businessCard3 = new BusinnessCardVO(3,"choi sangjin", "010-1111-4444", "samsung");
        businessCardList.add(businessCard1);
        businessCardList.add(businessCard2);
        businessCardList.add(businessCard3);

        businessCardData = new BusinessCardDAO();
        businessCardData.setCardList(businessCardList);
        businessCardData.setNum(100);

        Path path = Paths.get(url);
        System.out.println(path);

//        if (Files.exists(path)) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            File file = new File(url);
//            BusinessCardDAO businessCardData2 = objectMapper.readValue(file, BusinessCardDAO.class);
//
//            System.out.println(businessCardData2);
//        }

        //조회
        businessCardDAO.selectCard();
//        //추가
//        businessCardDAO.addCard("kang", "010-1111-2222", "Python");
        //조회
        businessCardDAO.selectCard();
        //삭제
        businessCardDAO.deleteCard(1, "yun");
        //조회
        businessCardDAO.selectCard();
        //수정
        businessCardDAO.modifyCard(2, "cho");
        //조회
        businessCardDAO.selectCard();

        //파일 저장
        businessCardDAO.writeFile(url);
    }
}
