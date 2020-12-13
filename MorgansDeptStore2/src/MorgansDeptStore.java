/* This is a control program that calculates 10 employees pay and bonus based on time and pay.
2-d arrays are utilizes and emp datat stored in tables
Author: Heather Whittlesey
9/1/20
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MorgansDeptStore {

    static Scanner employeeScanner = new Scanner(System.in);
    static Scanner fileScanner;


    static String iFirstName, iLastName, iPay, workStatus;
    static double iEmpPay;
    static DecimalFormat decimalFormatting;


    static int empCtr = 0;
    static double payStatus;
    static String namePattern = "[A-Za-z]{1,30}";
    static PrintWriter pw;


    static String[][] employeeData = new String[10][3];
    // last name, first name, status (10 people)

    static double[] paycheckAmt = new double[10];
    static double[][] bonusAmt = new double[4][3];

    static Boolean eof = false;

    public static void main(String[] args) throws FileNotFoundException {
    int empIndex = 0;
    String iOption;
    //passing bonus amount table to init

    init(bonusAmt); // sets table to empty
        while(!eof)
        do {
            iOption = displayMenu();
            switch (iOption) {
                case "1":

                    if (empCtr > 9) {
                        System.out.println("There can only be 10 employees");
                    } else {
                        empChoice1();
                     break;
                    }
                         printerOutput();
                     break;
                        case "2":
                            System.out.println("This option displays all employees.");
                            empChoice2();
                            break;
                        case "3":
                            empChoice3();
                            break;
                        case "4":
                            System.out.println("Goodbye");
                            System.exit(1);
                        default:
                            System.out.println("An Error occurred. Please try again.");
            }
        }
        while (!iOption.equals("4"));
    }

    private static double empCalc(double[][] bonusAmt,int empIndex) {

            double cBonus = 0;
            int timeOption = 0, y = 0;

            boolean inValid = false;

            //switch decides if part time or full time
            switch (employeeData[empIndex][2]){
                case "F":
                    timeOption = 3;//greater bonus :)
                    break;
                case "P":
                    timeOption = 2; //2 is the lesser bonus :(
                    break;
            }
            while (!inValid) {

                if (paycheckAmt[empIndex] >= bonusAmt[y][0] && paycheckAmt[empIndex] <= bonusAmt[y][1]) {
                    cBonus = paycheckAmt[empIndex] * bonusAmt[y][timeOption];
                    // this if statement really just says take your paycheck table and multiply it with the pay with the bonusAmt table to get the "actual bonus" amount
                    inValid = true;
                }
                else{
                    y++;
                }
            }
            return cBonus;
        }

    private static void empChoice3(){
       String fName, lName;
       int empIndex =0;
       int oBonus =0;
       double cBonus;
       System.out.println("Please enter the employee first name");
       fName = employeeScanner.nextLine();

       System.out.println("Please enter the employee last name");
       lName = employeeScanner.nextLine();

       cBonus = empCalc(bonusAmt,empIndex);


        for ( empIndex=0; empIndex<employeeData.length; empIndex++) {

            if (fName.equalsIgnoreCase(employeeData[empIndex][0]) && lName.equalsIgnoreCase(employeeData[empIndex][1])) {
                break;
            }
        }

            if (empIndex == employeeData.length) {
                System.out.println("Not a match.");
            }
            else {
                System.out.println(iFirstName);
                System.out.println(iLastName);
                System.out.println (decimalFormatting.format (paycheckAmt[empIndex]));
                System.out.println (decimalFormatting.format(cBonus));
            }
    }

    private static void printerOutput() {
        String record;
        record = String.format("%-12s", iFirstName) + String.format("%-12s", iLastName) +
                String.format("%1s", iEmpPay) + String.format("%1s", workStatus);

        pw.println(record);
        pw.close();

    }

    private static void empChoice2() {
        double cBonus;
        boolean match = false;
        int empIndex =0;
        //^^declaring calc variables here


        String oFirstName, oLastName, oStatus;
        double oEmpPay;
        int p=0;
        //^^declaring printing variables here

        System.out.printf("%-30s%-2s%-30s%-3s%6s%-5s%9s%-5s%-17s","Last Name","","First Name","","Status","","Pay Amount", "","Bonus\n");
        //^^print headings

            for (p = 0; p < empCtr; p++) {
                // instead of using ten you want to use the empctr bc you can have less then ten ppl

                oFirstName = employeeData[p][0];
                oLastName = employeeData[p][1];
                oStatus = employeeData[p][2];
                oEmpPay = paycheckAmt[p];
                cBonus = empCalc(bonusAmt,p);
                //^^ you are accessing 2 arrays here


                decimalFormatting = new DecimalFormat("$#,##0.00");


                System.out.printf("\n%-30s%-2s%-30s%-3s%6s%-5s%10s%-5s%-16s",oFirstName,"",oLastName,"",oStatus,"",
                        decimalFormatting.format(oEmpPay), "",decimalFormatting.format(cBonus));

                //^^printing employees
            }

    }

    private static void empChoice1() {

        String fName,lName,timeStatus;
        double payCheck;

        fName = fName();
        lName = lName();
        payCheck = payCheck();
        timeStatus = timeStatus();

        employeeData[empCtr] = new String[]{fName, lName, timeStatus};
        paycheckAmt[empCtr] = payCheck;
        empCtr++;
        //^^ this is storing the input into arrays

    }

    private static void init(double[][] table) throws FileNotFoundException {

        //pass table bonusAmt as a parameter to fileReader

        fileScanner= new Scanner(new File("bonusfile.dat"));
        fileScanner.useDelimiter(System.getProperty("line.separator"));
        //^^ removes delimiter

        try {
            fileScanner = new Scanner(new File("bonusfile.dat"));
            fileScanner.useDelimiter(System.getProperty("line.separator"));
            fileReader(table);

        } catch (FileNotFoundException e1) {
            System.out.println("File error" + e1.getMessage());
            System.exit(1);
        }

        for (int p = 0; p < 10; p++) {
            employeeData[p][0] = "";
            employeeData[p][1] = "";
            employeeData[p][2] = "";

            //initializing the 2-d string array to empty ^^^
        }

    }

    private static String displayMenu() {

        String iOption;
        System.out.println("\nPlease enter 1 to create employee profile, 2 to create a list of employee credentials, 3 to print the users (after creating a profile) or Enter 4 to exit.");
        iOption = employeeScanner.nextLine();
        return iOption;
    }

    public static String fName() {

        boolean inValid;

        do {
            System.out.println("Please enter a first name of an employee");
            iFirstName = employeeScanner.nextLine();

            if (iFirstName.matches(namePattern)) {
                System.out.println("That name is a match");
                inValid = true;
            } else {
                System.out.println("Not a match try again");
                inValid = false;
            }

        } while (!inValid);
        return iFirstName;
    }

    public static String lName() {
        boolean inValid;

        do {
            System.out.println("Please enter the employee last name");
            iLastName = employeeScanner.nextLine();

        if (iLastName.matches(namePattern)) {
            System.out.println("That last name is a match.");
            inValid = true;

        } else {
            System.out.println("Not a match, please try again");
            inValid = false;
        }

    }
        while (!inValid);
        return iLastName;
    }

    private static double payCheck() {
        boolean inValid;

        do {
            System.out.println("Please enter paycheck amount between .01 and 9999.99");
            iPay = employeeScanner.nextLine();

            if ((payStatus < 9999.99) || (payStatus > .01)) {


                //System.out.println("You have chosen $" + payStatus);
                inValid = false; //break out of loop

            } else {

                System.out.println("There was an error. Please Enter amount between .01 and 9999.99.");
                inValid = true;// dont need this statement bc default is true- it remains true to stay within the loop.
            }

            try {
                payStatus = Double.parseDouble(iPay);

            } catch (Exception e) {
                System.out.println("That was incorrect.");
                inValid = true;
            }

            decimalFormatting = new DecimalFormat("$#,##0.00");
            System.out.println("You have chosen " + decimalFormatting.format(payStatus));

        }

        while (inValid);
        return payStatus;
    }

    private static String timeStatus() {
        boolean inValid;


        do {
            System.out.println("Please enter P if you are part time of F if you are full time.");
            workStatus = employeeScanner.nextLine().toUpperCase();


            if (workStatus.equals("F") || workStatus.equals("P")){
                inValid = true;
        }

            else {
                inValid = false;
            }
        }
        while (!inValid);
        return workStatus;
    }

    private static void fileReader(double[][] fileTable) {
        String rateRecord = "";
        String rateRow[];
        int row = 0;
        //while there are still records
        while(fileScanner.hasNextLine()) {
            try {
                //read a record
                rateRecord = fileScanner.nextLine();
                //break the record into individual strings
                rateRow = rateRecord.split(",");
                //allocate a row in the pay scale table
                fileTable[row] = new double[rateRow.length];
                //populate each cell in the row with the rates
                for(int i = 0; i < rateRow.length; i++) {
                    fileTable[row][i] = Double.parseDouble(rateRow[i]);
                }
                row++;	//advance to the next row
            }
            catch(Exception e) {
                System.out.println("Error reading rate file, program terminating");
                System.exit(1);
            }
        }
    }
}


   