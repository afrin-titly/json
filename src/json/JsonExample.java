/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author afrin
 */
public class JsonExample {
    public static void main(String[] args) {
        JSONArray arr=new JSONArray();
        JSONObject obj = new JSONObject();
        JSONObject obj1 = new JSONObject();
        
        obj1.put("name", "mango");
        obj1.put("type", "fruit");
        obj1.put("price", 50);
        
        obj.put("name", "crow");
        obj.put("type", "bird");
        obj.put("price", 0);


//        JSONArray list = new JSONArray();
//        list.add("msg 1");
//        list.add("msg 2");
//        list.add("msg 3");

//        obj.put("messages", list);
            arr.add(obj);
            arr.add(obj1);

        try (FileWriter file = new FileWriter("in.json")) {

//            file.write(obj.toJSONString());
            file.write(arr.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(arr);

    }

}
