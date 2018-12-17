package test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BCExam {
    public static void main(String[] args) throws IOException {
        List<Map<String, Object>> dataList = new ArrayList<>();
        String url = ".\\BusinessCardDAO.json";

        Path path = Paths.get(url);
        System.out.println(path);

        if(Files.exists(path)){
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(url);
//            List<Map<String, Object>> businessCardData = objectMapper.readValue(file);
        }
        else{
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(url);

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

            objectMapper.writeValue(file, dataList);
        }
        System.out.println(dataList);
    }
}
