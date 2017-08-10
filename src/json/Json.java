/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author afrin
 */
public class Json {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JSONArray arr = new JSONArray();
        arr.add("titly");
        arr.add(23);
        arr.add(200.96);
        System.out.println(arr);
        
        JSONObject obj=new JSONObject();
        obj.put("name", "titly");
        obj.put("salary", 100.23);
        obj.put("age", 23);
        System.out.println(obj);
        
        Map map=new HashMap();
        map.put("name", "titly");
        map.put("age", 23);
        map.put("salary", 200.33);
        String jsonText=JSONValue.toJSONString(map);
        System.out.println(jsonText);
        
        List list=new ArrayList();
        list.add("titly");
        list.add(300.23);
        list.add(23);
        String jsonT=JSONValue.toJSONString(list);
        System.out.println(jsonT);
        
        String json="{\"name\":\"titly\",\"age\":23,\"salary\":500.66}";
        Object ob=JSONValue.parse(json);
        JSONObject jsonObject=(JSONObject) ob;
        String name=(String) jsonObject.get("name");
        double salary=(double) jsonObject.get("salary");
        long age=(long) jsonObject.get("age");
        System.out.println(name+" "+salary+" "+age);
        
        
        
    }
    
}
