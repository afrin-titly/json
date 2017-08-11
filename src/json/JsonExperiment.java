/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author afrin
 */
public class JsonExperiment {
    public static void main(String[] args) {
         JSONArray arr=new JSONArray();
    Map m1 = new HashMap(); 
    Map m2 = new HashMap();   
    Map m3 = new HashMap();
    int a=0,b=0,c=0,totalCount;
    String[] types=new String[20];
    double[] prices=new double[20];
    int[] count=new int[20];
    try {

           FileInputStream fin = new FileInputStream("in.json");

           int j = 0;
           String s = "";

           while((j=fin.read())!=-1) {

               s = s + String.valueOf((char)j);
               
           }
           JSONArray mArray=new JSONArray(s);

          for(int i=0;i<mArray.length();i++){
              JSONObject obj=mArray.getJSONObject(i);
              String name=(String) obj.get("name");
              String type=(String) obj.get("type");  
              double price=obj.getDouble("price");
              types[a]=type; 
              a++;
              prices[b]=price;
              b++;
            
            }
          double totalPrice;
          
          for (int x=0; x<a; x++){
            if (m1.containsKey(types[x])){
                String old_price_in_string = m1.get(types[x]).toString();
                double old = Double.valueOf(old_price_in_string);
                totalPrice=old + prices[x];
		 m1.put(types[x], totalPrice );                 
                 int old_count_in=(int) m2.get(types[x]);
                int old1=old_count_in+1;
                totalCount=old1+count[x];
                m2.put(types[x], totalCount );
	      }
            else{
		   m1.put(types[x], prices[x]);
                   count[x]=1;
                   m2.put(types[x], count[x]);
               }

              }
          for(int i=0;i<m1.size();i++){
              m3.put("type",m1.keySet().toArray()[i] );
              m3.put("price",m1.get(m1.keySet().toArray()[i]) );
              m3.put("total", m2.get(m2.keySet().toArray()[i]));
              arr.put(m3);
              
          }
         
          System.out.println(arr);
          
          try (FileWriter file = new FileWriter("out.json")) {
            file.write(arr.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
        catch (IOException e) {
            e.printStackTrace();
        }
           System.out.println("Done reading and writing!!");
    
         }
}
