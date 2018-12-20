package BusinessCardDAO.VO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-18
 * Github : https://github.com/YeoHoonYun
 */
public class BusinessCardDTO {
    private int num = 0;
    private int maxNum;
    private List<BusinessCardVO> businessCardList;

    public BusinessCardDTO() {
        businessCardList = new ArrayList<>();
        this.setBusinessCardList(businessCardList);
    }

    public BusinessCardDTO(List<BusinessCardVO> businessCardList) {
        this.businessCardList = businessCardList;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public List<BusinessCardVO> getBusinessCardList() {
        return businessCardList;
    }

    public void setBusinessCardList(List<BusinessCardVO> businessCardList) {
        this.businessCardList = businessCardList;
    }

    public int BusinessCardListNum(){
        return this.getBusinessCardList().size();
    }

}
