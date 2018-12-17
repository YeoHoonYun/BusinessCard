package test;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class testJson2 {
    public static void main(String[] args) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put( "name", "Mars" );
        data.put( "age", 32 );
        data.put( "city", "NY" );
        dataList.add(data);

        Map<String, Object> data2 = new HashMap<String, Object>();
        data2.put( "name", "Mars2" );
        data2.put( "age", 322 );
        data2.put( "city", "NY2" );

        dataList.add(data2);


        try {
            FileWriter file = new FileWriter(".\\BusinessCardDAO.json");
            for (Map<String, Object> md : dataList) {
                System.out.println(md);
                JSONObject json = new JSONObject();
                json.putAll(md);
                System.out.printf("JSON: %s", json.toString());
                file.write(json.toJSONString());
                file.flush();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
