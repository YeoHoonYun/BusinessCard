package BusinessCardDAO.VO;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BusinnessCardVO {
    private int cardNum;
    private String name;
    private String phonNum;
    private String company;

    public BusinnessCardVO() {
    }
    public BusinnessCardVO(int cardNum, String name, String phonNum, String company) {
        //this.cardNum = cardNum;
        this.name = name;
        this.phonNum = phonNum;
        this.company = company;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
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
        return "BusinnessCardVO{" +
                "cardNum=" + cardNum +
                ", name='" + name + '\'' +
                ", phonNum='" + phonNum + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
