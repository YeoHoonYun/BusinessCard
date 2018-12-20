/**
 * Created by cjswo9207u@gmail.com on 2018-12-20
 * Github : https://github.com/YeoHoonYun
 */
public class Data {
    private int value;

    public Data(int value){
        this.value = value;
    }

    public Data(Data d){
        this.value = d.getValue();
    }

    public int getValue(){
        return value;
    }

    public Data cloneData(){
        Data data = new Data(this.value);
        return data;
    }
}
