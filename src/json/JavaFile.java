/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;




/**
 *
 * @author afrin
 */
public class JavaFile {
    
    
     public static void main(String[] args) {
         int countB=0,countF=0,priceB=0,priceF=0;
         JSONArray arr=new JSONArray();
        JSONObject obj1 = new JSONObject();
        JSONObject obj2 = new JSONObject();
             try {

           FileInputStream fin = new FileInputStream("in.json");

           int j = 0;
           String s = "";

           while((j=fin.read())!=-1) {

               s = s + String.valueOf((char)j);
               
           }
          JSONArray mArray=new JSONArray(s);
          System.out.println(mArray);

            for(int i=0;i<mArray.length();i++){
                JSONObject obj=mArray.getJSONObject(i);
                String name=(String) obj.get("name");
                String type=(String) obj.get("type");
                int price=(int) obj.get("price");
                System.out.println(name+" "+type+" "+price);
                if(type.equals("bird")){
                    countB++;
                    priceB=priceB+price;
                    obj1.put("type", "bird");
                    obj1.put("total", countB);
                    obj1.put("price", priceB);
                    System.out.println("priceB "+priceB);
                }
                if(type.equals("fruit")){
                    countF++;
                    priceF=priceF+price;
                    obj2.put("type", "fruit");
                    obj2.put("total", countF);
                    obj2.put("price", priceF);
                    System.out.println("priceF "+priceF);
                }
                System.out.println(countB+" "+countF);
                    
            }
                arr.put(obj1);
                arr.put(obj2);
                try (FileWriter file = new FileWriter("out.json")) {

//            file.write(obj.toJSONString());
            file.write(arr.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } 
            
        
        
        
          
           
//                 System.out.println(s);
                 
           FileOutputStream fout = new FileOutputStream("output.txt");
           byte[] b = s.getBytes();

           fout.write(b);
           fout.close();

           System.out.println("Done reading and writing!!");

      } catch(Exception e){
         System.out.println(e);
      }
    
         }   
        
    }
     
     
     
    

