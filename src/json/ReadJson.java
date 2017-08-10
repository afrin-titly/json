/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author afrin
 */
public class ReadJson {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

//            Object obj = parser.parse(new FileReader("in.json"));
//
//            JSONObject jsonObject = (JSONObject) obj;
//            System.out.println(jsonObject);
//            JSONArray arr=(JSONArray) parser.parse(new FileReader("in.json"));
//            JSONArray jsonArray=arr;
            
            JSONArray jsonArray=(JSONArray) parser.parse(new FileReader("in.json"));
            System.out.println(jsonArray.length());
            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj=(JSONObject) jsonArray.get(i);
                
            }
            

//            String name = (String) jsonObject.get("name");
//            System.out.println(name);
//
//            long age = (Long) jsonObject.get("age");
//            System.out.println(age);
//
//            // loop array
//            JSONArray msg = (JSONArray) jsonObject.get("messages");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
