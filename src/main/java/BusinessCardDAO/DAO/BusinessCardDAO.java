package BusinessCardDAO.DAO;

import BusinessCardDAO.VO.BusinessCardVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

import java.io.*;
import java.util.*;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class BusinessCardDAO {
    private int num;
    private int maxNum;
    private List<BusinessCardVO> businessCardList;

    public BusinessCardDAO() {
        businessCardList = new ArrayList<>();
        this.setBusinessCardList(businessCardList);
        this.setMaxNum(100);
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<BusinessCardVO> getBusinessCardList() {
        return businessCardList;
    }

    public void setBusinessCardList(List<BusinessCardVO> businessCardList) {
        this.businessCardList = businessCardList;
    }

    public BusinessCardDAO(List<BusinessCardVO> businessCardVOList) {
        businessCardList = businessCardVOList;
    }

    // 삽입
    public void addCard(String name, String phonNum, String company){
        this.num = this.num + 1;
        BusinessCardVO businessCardVO = new BusinessCardVO(this.num, name, phonNum, company);
        businessCardList.add(businessCardVO);
    }
    // 삭제
    public void deleteCard(int id, String name){
        Iterator<BusinessCardVO> iterator = this.businessCardList.iterator();
        while(iterator.hasNext()){
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
            }
        }
    }
    // 수정(이름만 일단)
    public void modifyCard(int id, String name){
        for(BusinessCardVO bc : this.businessCardList){
            if(bc.getCardNum() == id){
                bc.setName(name);
            }
        }
    }

    // 조회
    public Iterator<BusinessCardVO> selectCard(){
        Iterator<BusinessCardVO> iterator = this.businessCardList.iterator();
        System.out.println("--------------CardList----------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("-------------------------------------");
        return iterator;
    }

    //파일 저장
    public void writeFile(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path);

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.writeValue(file, this);
    }

    @Override
    public String toString() {
        return "BusinessCardDAO{" +
                "num=" + num +
                ", businessCardList=" + businessCardList +
                '}';
    }

    //파일 읽기
    public void readFile(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        BusinessCardDAO businessCardData = objectMapper.readValue(file, BusinessCardDAO.class);
        this.businessCardList = businessCardData.getBusinessCardList();
        this.setNum(businessCardData.getNum()-1);
    }
}
