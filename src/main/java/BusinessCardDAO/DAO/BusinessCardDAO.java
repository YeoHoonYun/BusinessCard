package BusinessCardDAO.DAO;

import BusinessCardDAO.VO.BusinessCardDTO;
import BusinessCardDAO.VO.BusinessCardVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BusinessCardDAO {
    BusinessCardDTO businessCardDTO;

    public BusinessCardDAO(BusinessCardDTO businessCardDTO) {
        this.businessCardDTO = businessCardDTO;
    }

    public BusinessCardDTO getBusinessCardDTO() {
        return businessCardDTO;
    }

    public void setBusinessCardDTO(BusinessCardDTO businessCardDTO) {
        this.businessCardDTO = businessCardDTO;
    }

    // 삽입
    public void addCard(String name, String phonNum, String company){
        businessCardDTO.setNum(businessCardDTO.getNum() + 1);
        BusinessCardVO businessCardVO = new BusinessCardVO(businessCardDTO.getNum(), name, phonNum, company);
        businessCardDTO.getBusinessCardList().add(businessCardVO);
    }
    // 삭제
    public void deleteCard(int id){
        int delNum = 0;
        Iterator<BusinessCardVO> iterator = businessCardDTO.getBusinessCardList().iterator();
        while(iterator.hasNext()){
            if (iterator.next().getCardNum().equals(id)) {
                iterator.remove();
                delNum++;
            }
        }
        if(delNum == 0){
            System.out.println("****검색된 값이 없어 삭제 되지 않았습니다.****");
        }
        else{
            System.out.println("****"+delNum + "건의 값을 삭제 하였습니다."+"****");
        }

    }

    // 삭제
    public void deleteCard(String id){
        int delNum = 0;
        Iterator<BusinessCardVO> iterator = businessCardDTO.getBusinessCardList().iterator();
        while(iterator.hasNext()){
            if (iterator.next().getName().equals(id)) {
                iterator.remove();
                delNum++;
            }
        }
        System.out.println("****"+delNum + "건의 값을 삭제 하였습니다."+"****");
    }

    // 수정(이름)
    public void modifyName(int id, String name){
        for(BusinessCardVO bc : businessCardDTO.getBusinessCardList()){
            if(bc.getCardNum() == id){
                bc.setName(name);
            }
        }
    }
    // 수정(전화번호)
    public void modifyPhonNum(int id, String name){
        for(BusinessCardVO bc : businessCardDTO.getBusinessCardList()){
            if(bc.getCardNum() == id){
                bc.setPhonNum(name);
            }
        }
    }
    // 수정(회사)
    public void modifyCompany(int id, String name){
        for(BusinessCardVO bc : businessCardDTO.getBusinessCardList()){
            if(bc.getCardNum() == id){
                bc.setCompany(name);
            }
        }
    }

    // 전체 조회
    public List<BusinessCardVO> selectCard(){
//        Iterator<BusinessCardVO> iterator = businessCardDTO.getBusinessCardList().iterator();
        System.out.println("모든 건수 : "+ businessCardDTO.BusinessCardListNum() + "건");
        return businessCardDTO.getBusinessCardList();
    }

    // 이름 검색
    public List<BusinessCardVO> selectCard(String name){
        List<BusinessCardVO> businessCardVOList = new ArrayList<>();
        for (BusinessCardVO businessCardVO : businessCardDTO.getBusinessCardList()){
            if(businessCardVO.getName().contains(name)){
                businessCardVOList.add(businessCardVO);
            }
        }
        System.out.println("검색 된 모든 건수 : "+ businessCardVOList.size() + "건");
        return businessCardVOList;
    }

    //파일 저장
    public void writeFile(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path);
        objectMapper.writeValue(file, businessCardDTO);
    }

    @Override
    public String toString() {
        return "BusinessCardDAO{" +
                "businessCardDTO=" + businessCardDTO +
                '}';
    }

    //파일 읽기
    public void readFile(String path) throws IOException {
        Path paths = Paths.get(path);
        if (Files.exists(paths)) {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(path);
            BusinessCardDTO businessCardData = objectMapper.readValue(file, BusinessCardDTO.class);
            this.businessCardDTO = businessCardData;
            this.businessCardDTO.setNum(businessCardData.getNum());
        }
    }
}
