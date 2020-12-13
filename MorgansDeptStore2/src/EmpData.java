
import java.util.Scanner;
// the instantiable class for control class MorgansDeptStore

public class EmpData {

    private String firstName, lastName ;
    double empPay;
    String timeWorked;


    public EmpData(String un, String pw, double rb, String tw){
        firstName = un;
        lastName = pw;
        empPay = rb;
        timeWorked = tw;
    }

    // getters-accessors

    public String getfname() {
        return firstName;
    }
    public String getlname() {
        return lastName;
    }
    public double getempPay() {
        return empPay;
    }
    public String gettimeWorked() {
        return timeWorked;
    }

    //setters-mutators

    public void setfname(String i) {firstName = i; }
    public void setlname(String p) {lastName = p; }
    public void setTimeWorked(String t) {timeWorked = t; }
    public void setempPay(double r) { empPay = r; }


    //Default constructor

    public void NewStudent(){
        firstName = "Joe";
        lastName = "Smith";
        timeWorked = "PT";
        empPay = 100.00;

    }
}



