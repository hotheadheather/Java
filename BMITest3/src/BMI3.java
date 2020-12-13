import java.io.Serializable;
import java.text.DecimalFormat;

public class BMI3 implements Serializable, Comparable  {

    //Comparable is a contract to promise to utilize it later
    private String fname;
    private String lname;
    private double weight;
    private double height;
    private int option; //option 1 is metric 2 is standard


    //getters-accessors

    public String getfName(){
        return fname;
    }

    public String getlName(){
        return lname;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getOption() {
        return option;
    }

    // setters-mutators

    public void setfname(String f) {
        String namePattern = "[A-Za-z]{1,14}";
        if (f.matches(namePattern))
            this.fname = f;
        else {
            this.fname ="Jane";
        }
    }

    public void setlName(String l) {
        String namePattern = "[A-Za-z]{1,14}";
        if (l.matches(namePattern))
            this.lname = l;
        else {
            this.lname ="Doe";
        }
    }

    public void setWeight(double w) {
        if (w > 0)
            this.weight = w;
        else {
            this.weight =70;
        }
    }

    public void setHeight(double h) {
        if (h > 0)
            this.height = h;

        else {
            this.height = 170;
        }
    }

    public void setOption(int o) {
   /*    if (option == 1 || option == 2)
            this.option = option;
        else {
            this.option = 2;
        }

    */

        if (o == 1 || o == 2)
            this.option = o;
        else {
            this.option = 2;
        }

    }

    public double bmiCalc() {
        double bmiTotal = 0;

        if (option == 2) {

            bmiTotal =  (weight * 1.0) / height/height*703;
            //this is standard option

        } else {
            {
                bmiTotal =  (weight * 1.0) / height/height;

                //multiplying by 1.0 makes the value implicitly a double.
                //this is metric option
            }
        }
        return bmiTotal;
    }

    //default constructor
    public BMI3() {

        fname = "Jane";
        lname = "Doe";
        weight = 70;
        height = 170;
        option = 1;
    }


    /**
     * Overloaded Constructor
     * @param f Fist Name
     * @param l Last Name
     * @param w Weight
     * @param h Height
     * @param o Option
     */
    // this is a javadoc comment- it makes your pop ups custom when debugging


    //code an overloaded/parameterized constructor that accepts w,h,o
    public BMI3(String f, String l, double w, double h, int o) {
        setfname(f);
        setlName(l);
        setWeight(w);
        setHeight(h);
        setOption(o);

    }

    public String bodyType() {

        String category = "";
        Double BmiCalc = bmiCalc();


        if (BmiCalc < 18.5) {

            category = "Underweight";
        } else if (BmiCalc< 25) {

            category = "Normal";
        } else if (BmiCalc < 30) {

            category = "Overweight";
        } else {

            category = "Obese";
        }
        return category;
    }


    @Override
    public String toString() {
        double bmi = bmiCalc();
        String bodyType = bodyType();
        String measureUnit="";
        //int o= setOption(option);
        //^^ store variables here so you don't have to call the methods in the toString()

        String properName = lname.substring(0, 1).toUpperCase() + lname.substring(1)+"," + " " + fname.substring(0, 1).toUpperCase() + fname.substring(1);

        DecimalFormat bmiFormat =new DecimalFormat("##.00");

        if (option == 1) {
            measureUnit= "Metric";
        } else  {
            measureUnit = "Standard";
        }

       //^^ this is where my error is with measure unit- option is saving



        return String.format("\n%-30s%5s%-8s%5s%-8s%5s%-10s%5s%-8s%5s%-10s",properName,"",height,"",weight,"",measureUnit,"",bmiFormat.format(bmi),"",bodyType);
        //when you reference the method you are referencing the value stored in the method.
    }

    @Override
    public int compareTo(Object o) {
        BMI3 bmi = (BMI3)o;

        return this.lname.compareTo(bmi.lname)+this.fname.compareTo(bmi.fname);
        //^^when appending it alphabetizes as groups
        //compare the last names
        //compare object to current object to alphabetize
        //try to use an if statement if the last name match-try a compare to on the first name and then the last
    }
}


