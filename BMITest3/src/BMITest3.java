import java.io.*;
import java.io.Serializable;
import java.util.*;
import java.text.DecimalFormat;

//This is a control program -
// taking objects as we instantiate them and transporting them out to the file and
// importing data as objects back into memory

public class BMITest3 {

    static BMI3 aPatient;
    //^^instantiating new object

    static DecimalFormat decimalFormatting;
    static Boolean inValid = false;

    static Scanner bodyMassIndex = new Scanner(System.in);

    static String namePattern = "[A-Za-z]{1,28}";

    static List<BMI3> clientList = new ArrayList<>();

    static String fname;
    static String lname;
    static double weight;
    static double height;
    static int option; //option 1 is metric 2 is standard

    private static java.lang.Object Object;
    //static BMI3 a = new BMI3();
    //dont use a use apatient

    public static void main(String[] args) {
        String iOption;
        //ask before you go into loop
        init();
        iOption = displayMenu();


        while (!inValid) {
            switch (iOption) {
                case "1":
                    metricOption(); //calcs contained within here
                    addPatients();
                    break;
                case "2":
                    standardOption();//calcs contained within here
                    addPatients();
                    break;
                case "3":
                    printPatients();
                    break;
                case "4":
                    serialization();
                    System.out.println("Goodbye");
                    System.exit(1);
                default:
                    System.out.println("An Error occurred. Please try again.");
            }

            iOption = displayMenu();
        }

    }

    private static void deserialization() {
       // d for decrypting - in


        String fileName = "patient_data.ser";
        FileInputStream inFile;
        ObjectInputStream inStream;

        try
        {
            inFile = new FileInputStream(fileName);
            inStream = new ObjectInputStream(inFile);
            clientList = (List<BMI3>) inStream.readObject(); // this says im going to read my objects into the list
            inStream.close();
            inFile.close();
        }
        catch (Exception ex)
        {
            System.out.println("Error reading patient file");
            System.out.println(ex.getMessage());
        }


    }

    private static void serialization() {
        // s for starting - out

        String fileName = "patient_data.ser";
        FileOutputStream outFile;
        ObjectOutputStream outStream;

        try
        {
            outFile = new FileOutputStream(fileName);
            outStream = new ObjectOutputStream(outFile);

            outStream.writeObject(clientList);
            outStream.close(); // close your string and then your file
            outFile.close();
        }

        catch (Exception ex)
        {
            System.out.println("Error writing patient to file" + ex.getMessage());
        }

    }

    private static void printPatients() {
        System.out.printf("\n%-30s%5s%-8s%5s%-8s%5s%-10s%5s%-8s%5s%-10s", "Name", " ", "Height", " ", "Weight", " ", "Unit", " ", "BMI", " ", "Body Type\n");

        //sort list
        Collections.sort(clientList);
        for(BMI3 o : clientList) {
            System.out.printf(o.toString());
        }

    }

    public static String addPatients() {
        String patientPrint = "";
        boolean inValid = false;

        while (!inValid) {

            System.out.println("\nWould you like to record this patient to the file? Y for yes or N for no");
            patientPrint = bodyMassIndex.nextLine().toUpperCase();

            if (patientPrint.equals("Y")) {
                inValid = true;
                clientList.add(aPatient);
                System.out.println("Patient will be saved.\n");
                //call the method that adds it to the list
            } else {
                if
                (patientPrint.equals("N")) {
                    inValid = true;
                    System.out.println("Patient will not be printed.\n");
                } else {
                    System.out.println("Not a match try again");
                    inValid = false;
                }
            }
        }
        return patientPrint;
    }

    private static void metricOption() {
        String iData;
        fname = fname();
        lname = lname();

        decimalFormatting = new DecimalFormat("#0.00");

        do {

            try {
                System.out.print("What is your weight in kilograms? ");
                iData = bodyMassIndex.nextLine();
                weight = Double.parseDouble(iData);
                inValid = false;

            } catch (Exception e) {

                System.out.println("That was incorrect. Please enter a number.");
                inValid = true;

            }
        } while (inValid);

        do {

            try {

                System.out.print("\nWhat is your height in meters: ");
                iData = bodyMassIndex.nextLine();
                height = Double.parseDouble(iData);
                inValid = false;

            } catch (Exception e) {
                System.out.println("Please enter a number.");
                inValid = true;

            }
        } while (inValid);


        //double BMI= ((((weight * 1.0)/height)/height)* 10000);
       double BMI = weight / (height * height);

        System.out.printf("\n%-30s%5s%-8s%5s%-8s%5s%-10s%5s%-8s%5s%-10s", "Name", " ", "Height", " ", "Weight", " ", "Unit", " ", "BMI", " ", "Body Type\n");
        aPatient = new BMI3(fname, lname, weight, height, option);
        //This creates your custom profile
        System.out.println(aPatient.toString());
    }

    private static void standardOption() {
        String iData;
        fname = fname();
        lname = lname();

        decimalFormatting = new DecimalFormat("#0.00");

        do {

            try {
                System.out.print("What is your weight in pounds? ");
                iData = bodyMassIndex.nextLine();
                weight = Double.parseDouble(iData);
                inValid = false;

            } catch (Exception e) {

                System.out.println("That was incorrect. Please enter a number.");
                inValid = true;

            }
        } while (inValid);

        do {

            try {

                System.out.print("\nWhat is your height in inches: ");
                iData = bodyMassIndex.nextLine();
                height = Double.parseDouble(iData);
                inValid = false;

            } catch (Exception e) {
                System.out.println("Please enter a number.");
                inValid = true;

            }

        } while (inValid);


        double BMI = weight / (height * height);

        System.out.printf("\n%-30s%5s%-8s%5s%-8s%5s%-10s%5s%-8s%5s%-10s", "Name", " ", "Height", " ", "Weight", " ", "Unit", " ", "BMI", " ", "Body Type\n");
        aPatient = new BMI3(fname, lname, weight, height, option);
        System.out.println(aPatient.toString());
    }

    public static String fname() {

        String fname;
        boolean inValid;

        do {
            System.out.println("Please enter a first name of a patient");
            fname = bodyMassIndex.nextLine();

            if (fname.matches(namePattern)) {
                inValid = true;
            } else {
                System.out.println("Not a match try again");
                inValid = false;
            }

        } while (!inValid);
        return fname;
    }

    public static String lname() {

        String lname;
        boolean inValid;

        do {
            System.out.println("Please enter last name of patient");
            lname = bodyMassIndex.nextLine();

            if (lname.matches(namePattern)) {
                inValid = true;
            } else {
                System.out.println("Not a match try again");
                inValid = false;
            }

        } while (!inValid);
        return lname;
    }

    private static String displayMenu() {

        String iOption;
        System.out.println("\nPlease enter 1 to enter metric weight, enter 2 for standard weight, 3 to print a list of patients or 4 to exit.");
        iOption = bodyMassIndex.nextLine();
        return iOption;
    }

    private static void init() {
        deserialization();

    }
}