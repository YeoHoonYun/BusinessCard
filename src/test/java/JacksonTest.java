import BusinessCardDAO.DAO.BusinessCardDAO;
import BusinessCardDAO.VO.BusinnessCardVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JacksonTest {
    // 테스트할 객체 선언
    private BusinnessCardVO businessCard1;
    private BusinnessCardVO businessCard2;
    private BusinnessCardVO businessCard3;
    private List<BusinnessCardVO> businessCardList;
    private BusinessCardDAO businessCardData;

    @Before
    public void init(){
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
    }
    @Test
    public void convertJson() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(businessCard1);
        System.out.println(jsonValue);
    }

    @Test
    public void convertJsonFromList() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(businessCardList);
        System.out.println(jsonValue);
    }

    @Test
    public void convertJsonFromBusinessCardData() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(businessCardData);
        System.out.println(jsonValue);
    }

    @Test
    public void saveBusinessCardData() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(".\\businesscard2.json");
        objectMapper.writeValue(file, businessCardData);
    }

    @Test
    public void readBusinessCardData() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(".\\businesscard2.json");
        BusinessCardDAO businessCardData = objectMapper.readValue(file, BusinessCardDAO.class);

        System.out.println(businessCardData);
    }
}