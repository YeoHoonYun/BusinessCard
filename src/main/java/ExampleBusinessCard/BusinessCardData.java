package ExampleBusinessCard;

import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BusinessCardData {
    private int maxNum;
    private List<BusinessCard> businessCardList;

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public List<BusinessCard> getBusinessCardList() {
        return businessCardList;
    }

    public void setBusinessCardList(List<BusinessCard> businessCardList) {
        this.businessCardList = businessCardList;
    }

    @Override
    public String toString() {
        return "BusinessCardData{" +
                "maxNum=" + maxNum +
                ", businessCardList=" + businessCardList +
                '}';
    }
}
