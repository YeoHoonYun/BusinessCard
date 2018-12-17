package BusinessCardDAO.VO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class BusinessCardVO {
    private Integer cardNum;
    private String name;
    private String phonNum;
    private String company;

    public BusinessCardVO() {
    }

    public BusinessCardVO(Integer cardNum, String name, String phonNum, String company) {
        this.cardNum = cardNum;
        this.name = name;
        this.phonNum = phonNum;
        this.company = company;
    }

    public Integer getCardNum() {
        return cardNum;
    }

    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonNum() {
        return phonNum;
    }

    public void setPhonNum(String phonNum) {
        this.phonNum = phonNum;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "BusinessCardVO{" +
                "cardNum=" + cardNum +
                ", name='" + name + '\'' +
                ", phonNum='" + phonNum + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
