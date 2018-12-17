package test;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class testJson {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try {

            FileWriter file = new FileWriter(".\\BusinessCardDAO.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

}
