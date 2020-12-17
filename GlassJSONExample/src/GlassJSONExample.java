import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;
/**
 * Example of program using JSON.simple library 
 * http://code.google.com/p/json-simple/ to get jar
 * @author heather whittlesey
 * 12/16/2020
 *
 */
public class GlassJSONExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("Glass.json"));
            JSONObject jsonObject = (JSONObject) obj;

            System.out.println("Parsing Glass Inventory");
            String inv = (String) jsonObject.get("inv");

            System.out.println("inv: " + inv);

            JSONArray glasslist =  (JSONArray) jsonObject.get("glassProfile");

            System.out.println("Parsing Colors");

            for(Object s: glasslist){

                // Split up to print individual values
                System.out.println();
                JSONObject glassObject = (JSONObject) s;
                String inventoryID = (String) glassObject.get("inventoryID");
                System.out.println("inventoryID: " + inventoryID);

                Long supplyKg = (Long) glassObject.get("supplyKg");
                System.out.println( "supplyKg: "+ supplyKg);

                String colorName = (String) glassObject.get("colorName");
                System.out.println("colorName: " + colorName);


                Long physicalForm = (Long) glassObject.get("physicalForm");
                System.out.println( "physicalForm: "+ physicalForm);

                // String to char conversion
                char reducingProp =  ((String) glassObject.get("reducingProp")).charAt(0);
                System.out.println("reducingProp: " + reducingProp);

                char strikingProp =  ((String) glassObject.get("strikingProp")).charAt(0);
                System.out.println("strikingProp: " + strikingProp);

                char colorTransparency =  ((String) glassObject.get("colorTransparency")).charAt(0);
                System.out.println("colorTransparency: " + colorTransparency);

                char adventurineType =  ((String) glassObject.get("adventurineType")).charAt(0);
                System.out.println("adventurineType: " + adventurineType);


                double costPerKg= (double) glassObject.get("costPerKg");
                System.out.println( "costPerKg: "+ costPerKg);



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "GlassJSONExample{}";
    }
}