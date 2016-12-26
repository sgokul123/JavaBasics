package com.bridgelabz.programs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.utility.Utility;


public class JSONSimpleWritingToFileExample {

    public static void main(String[] args) {
    	String Name , Price ,Weight;
    	JSONObject Obj = new JSONObject();
       Utility u=new Utility();
    	System.out.println("Enter Rice Details :");
        JSONObject countryObj1 = new JSONObject();
        System.out.println("Enter the Name :");
        Name =u.inputString();
        countryObj1.put("Name", Name);
        System.out.println("Ente Weight :");
        Weight=u.inputString();
        countryObj1.put("Weight", new Integer(Weight));
        System.out.println("Enter Price :");
        Price =u.inputString();
        countryObj1.put("Price", new Integer(Price));
         System.out.println("Enter Pulses Details :");
         JSONObject countryObj2 = new JSONObject();
         System.out.println("Enter The Name :");
         Name=u.inputString();
        countryObj2.put("Name", Name);
        System.out.println("Enter the Weight :");
        Weight=u.inputString();
        countryObj2.put("Weight", new Integer(Weight));
        System.out.println("Enter the Price :");
        Price = u.inputString();
        countryObj2.put("Price", new Integer(Price));
          System.out.println("Enter the wheets details :");
        
        JSONObject countryObj3 = new JSONObject();
        System.out.println("Enter The Name :");
        Name =u.inputString();
        countryObj3.put("Name", Name);
        System.out.println("Enter the Weight :");
        Weight=u.inputString();
        countryObj3.put("Weight", new Integer(Weight));
        System.out.println("Enter the Price :");
        Price=u.inputString();
        countryObj3.put("Price", new Integer(Price));
        
        JSONObject countryObj = new JSONObject();
        countryObj.put("Rice",countryObj1);  
        countryObj.put("Pulses",countryObj2);
        countryObj.put("Wheats", countryObj3);
        
        Obj.put("Inventory", countryObj);
        
        try {
        
            // Writing to a file
            File file=new File("/home/bridgeit/CountryJSONFile.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("Writing JSON object to file");
            System.out.println("-----------------------");
            System.out.print(Obj);

            fileWriter.write(Obj.toJSONString());
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

}
}

