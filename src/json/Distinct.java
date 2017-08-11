/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author afrin
 */
public class Distinct {
    public static void main(String[] args) {
      Map m1 = new HashMap(); 
 
      String[] types = {"Bird","fruit","fruit"};
      Double[] prices ={ 10.0,20.0,30.0};
 
      for (int i=0; i<types.length; i++)
	      if (m1.containsKey(types[i])){
	      	double old = Double.valueOf(m1.get(types[i]).toString());
		    m1.put(types[i],  old + prices[i]);
                    System.out.println(types[i]+" "+ prices[i]);
	      }
              else{
		  	
                 m1.put(types[i], prices[i]);
                 System.out.println(types[i]+" "+ prices[i]);
              }
//                        
      
      System.out.println();
      System.out.println(" Map Elements");
      System.out.print("\t" + m1);
   }
}
