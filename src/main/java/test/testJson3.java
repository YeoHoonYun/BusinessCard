package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class testJson3 {
    public static void main(String[] args) throws JsonProcessingException {
        Map<String, Object> resultList = new HashMap<String, Object>();
        List<Map<String, Object>> dataList = new ArrayList<>();

        Map<String, Object> data = new HashMap<String, Object>();
        data.put( "name", "Mars" );
        data.put( "age", 32 );
        data.put( "city", "NY" );
        dataList.add(data);

        Map<String, Object> data2 = new HashMap<String, Object>();
        data2.put( "name", "Yun" );
        data2.put( "age", 27 );
        data2.put( "city", "KR" );
        dataList.add(data2);

        resultList.put("businessCardList", dataList);
        resultList.put("maxNum", 3);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(resultList);
        System.out.println(json);

        try {
            FileWriter file = new FileWriter(".\\BusinessCardDAO.json");
            file.write(json);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
