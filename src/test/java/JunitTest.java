
import BusinessCardDAO.DAO.BusinessCardDAO;
import BusinessCardDAO.VO.BusinessCardVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JunitTest {
//    // 테스트할 객체 선언
//    private BusinessCardVO businessCard1;
//    private BusinessCardVO businessCard2;
//    private BusinessCardVO businessCard3;
//    private List<BusinessCardVO> businessCardList;
//    private BusinessCardDAO businessCardData;
//
//    @Before
//    public void init(){
//        businessCardList = new ArrayList<>();
//        businessCard1 = new BusinessCardVO(1,"kim sungpark", "010-1111-2222", "sunnyvale");
//        businessCard2 = new BusinessCardVO(2,"kang kyungmi", "010-1111-3333", "sunnyvale");
//        businessCard3 = new BusinessCardVO(3,"choi sangjin", "010-1111-4444", "samsung");
//        businessCardList.add(businessCard1);
//        businessCardList.add(businessCard2);
//        businessCardList.add(businessCard3);
//
//        businessCardData = new BusinessCardDAO();
//        businessCardData.setBusinessCardList(businessCardList);
//        businessCardData.setNum(100);
//    }
//    @Test
//    public void convertJson() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonValue = objectMapper.writeValueAsString(businessCard1);
//        System.out.println(jsonValue);
//    }
//
//    @Test
//    public void convertJsonFromList() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonValue = objectMapper.writeValueAsString(businessCardList);
//        System.out.println(jsonValue);
//    }
//
//    @Test
//    public void convertJsonFromBusinessCardData() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonValue = objectMapper.writeValueAsString(businessCardData);
//        System.out.println(jsonValue);
//    }
//
//    @Test
//    public void saveBusinessCardData() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = new File(".\\businesscard2.json");
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        objectMapper.writeValue(file, businessCardData);
//    }
//
//    @Test
//    public void readBusinessCardData() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = new File(".\\businesscard2.json");
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        BusinessCardDAO businessCardData = objectMapper.readValue(file, BusinessCardDAO.class);
//
//        System.out.println(businessCardData.toString());
//    }
}
