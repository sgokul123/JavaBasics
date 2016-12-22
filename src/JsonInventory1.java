/*
*Disc : JSON Inventory Data Management of Rice, Pulses and Wheats
*Auth : Sonawane Gokul
*Date : 20/12/2016
*/
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonInventory1 {
	public static void main(String args[]) {
		// creates the object of JSONParser class to Read the json file
		JSONParser parser = new JSONParser();
		try {
			// Parse the String in file as JSON String
			Object obj = parser.parse(new FileReader("/home/bridgelabz6/workspace/bridgeeit/src/simple.json"));

			// Creates a JSONObject
			JSONObject JObj = (JSONObject) obj;

			// Creates the Array of data present in the file
			JSONArray data = (JSONArray) JObj.get("Inventory");

			// Display the data taken from the JSON file
			System.out.println("The data in the Array" + data);

			String[] str = { "Rice", "Pulses", "Wheats" };
			for (int i = 0; i < data.size(); i++) {
				// Create a JSONObject of Data
				JSONObject item = (JSONObject) data.get(i);

				// Create a JSONArray of Data Items
				JSONArray Arritem = (JSONArray) item.get(str[i]);

				// Prints Array of the object
				System.out.println(str[i] + ":");
				long value[] = new long[data.size()];
				long sum = 0;
				int j = 0;
				for (j = 0; j < Arritem.size(); j++) {
					JSONObject Arrobject = (JSONObject) Arritem.get(j);
					// Gets the name from the json file

					System.out.println("Name : " + Arrobject.get("name"));
					// Gets the weight from the json file
					long weight = Long.parseLong(Arrobject.get("weight").toString());
					System.out.println("Weight :" + weight + " Kg");
					// Gets the Price object From the json file
					long price = Long.parseLong(Arrobject.get("price").toString());
					System.out.println("Price :" + price + " Rs");
					System.out.println();
					value[j] = weight * price;
				}
				for (j = 0; j < Arritem.size(); j++) { 
					// calculate total value of inventory
					sum = sum + value[j];
				}
				System.out.println("Total value of " + str[i] + " is " + sum + " Rs");//print value of each inventory
				System.out.println("---------------------------------------------");
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

}
