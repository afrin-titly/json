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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author afrin
 */
public class NewJson {
     public static void main(String[] args) {
    JSONArray arr=new JSONArray();
    Map m1 = new HashMap(); 
    Map m2 = new HashMap();    
    int a=0,b=0,c=0;
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
//            System.out.println(mArray.length());
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
		 m1.put(types[x], old + prices[x] );
                 
                 int old_count_in=(int) m2.get(types[x]);
                int old1=old_count_in+1;
                m2.put(types[x], old1+count[x]);
	      }
            else{
		   m1.put(types[x], prices[x]);
                   count[x]=1;
                   m2.put(types[x], count[x]);
               }
            
//            if(m2.containsKey(types[x])){
//                int old_count_in=(int) m2.get(types[x]);
//                int old=old_count_in+1;
//                System.out.println(old);
//                m2.put(types[x], old+count[x]);
//                
//            }
//            else{
//                count[x]=1;
//                m2.put(types[x], count[x]);
//            }
              }
           arr.put(m1);
          System.out.println(arr);
          System.out.println(m2);
          
           
    }
        catch (IOException e) {
            e.printStackTrace();
        }

           System.out.println("Done reading and writing!!");

}
}
