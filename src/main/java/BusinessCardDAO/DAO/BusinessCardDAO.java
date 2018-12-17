package BusinessCardDAO.DAO;

import BusinessCardDAO.VO.BusinnessCardVO;
import ExampleBusinessCard.BusinessCardData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.io.*;
import java.util.*;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BusinessCardDAO {
    private int num = 0;
    private List<BusinnessCardVO> cardList;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<BusinnessCardVO> getCardList() {
        return cardList;
    }

    public void setCardList(List<BusinnessCardVO> cardList) {
        this.cardList = cardList;
    }

    public BusinessCardDAO() {
        cardList = new ArrayList<>();

//        this.num = this.num + 1;
//        BusinnessCardVO businnessCardVO1 = new BusinnessCardVO(this.num,"yun","010-2277-9207","Fast");
//        this.num = this.num + 1;
//        BusinnessCardVO businnessCardVO2 = new BusinnessCardVO(this.num,"kim","010-1234-5678","Campus");
//        this.num = this.num + 1;
//        BusinnessCardVO businnessCardVO3 = new BusinnessCardVO(this.num,"hong","010-9876-0543","Java");
//
//        cardList.add(businnessCardVO1);
//        cardList.add(businnessCardVO2);
//        cardList.add(businnessCardVO3);
    }

    public BusinessCardDAO(List<BusinnessCardVO> businnessCardVOList) {
        cardList = businnessCardVOList;
    }

    // 삽입
    public void addCard(String name, String phonNum, String company){
        this.num = this.num + 1;
        BusinnessCardVO businnessCardVO = new BusinnessCardVO(this.num, name, phonNum, company);
        cardList.add(businnessCardVO);
    }
    // 삭제
    public void deleteCard(int id, String name){
        Iterator<BusinnessCardVO> iterator = this.cardList.iterator();
        while(iterator.hasNext()){
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
            }
        }
    }
    // 수정(이름만 일단)
    public void modifyCard(int id, String name){
        for(BusinnessCardVO bc : this.cardList){
            if(bc.getCardNum() == id){
                bc.setName(name);
            }
        }
    }

    // 조회
    public Iterator<BusinnessCardVO> selectCard(){
        Iterator<BusinnessCardVO> iterator = this.cardList.iterator();
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
        objectMapper.writeValue(file, cardList);
    }

    @Override
    public String toString() {
        return "BusinessCardDAO{" +
                "num=" + num +
                ", cardList=" + cardList +
                '}';
    }

    //파일 읽기
    public void readFile(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path);
        BusinessCardData businessCardData = objectMapper.readValue(file, BusinessCardData.class);
        System.out.println(businessCardData);
    }
}
