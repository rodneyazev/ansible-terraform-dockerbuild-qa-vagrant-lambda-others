package com.br.app;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Map<String,String> mylist = new HashMap<String,String>();
	      
        // enter name/url pair
		mylist.put("GFG", "geeksforgeeks.org");
		mylist.put("Practice", "practice.geeksforgeeks.org");
		mylist.put("Code", "code.geeksforgeeks.org");
		mylist.put("Quiz", "www.geeksforgeeks.org");
          
        // forEach(action) method to iterate map
		mylist.forEach((kmykey,myvalue) -> System.out.println("Key = "
                + kmykey + ", Value = " + myvalue));
        
        double d = 6.3546;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print(df.format(d));
	}

}
