
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Student{
    String name,roll,stream;
    Student(String name,String roll){

        this.name=name;
        this.roll = roll;
    }
    abstract int getFeeDetails();
    abstract void setFeeDetails(int fees);
}

class Postgraduate extends Student{
    static int fees;
    Postgraduate(String name,String roll){
        super(name,roll);
        this.stream = "PG";
    }
    void setFeeDetails(int fees){
        this.fees = fees;
    }
    int getFeeDetails(){
        return this.fees;
    }
}
class Undergraduate extends Student{
    static int fees;
    String name,roll,stream;
    Undergraduate(String name,String roll){
        super(name,roll);
        this.stream = "PG";

    }
    void setFeeDetails(int fees){
        this.fees = fees;
    }
    int getFeeDetails(){
        return this.fees;
    }
}
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] details;
        int pgfees, ugfees, n;
        String rollid;
        ugfees = sc.nextInt();
        pgfees = sc.nextInt();
        List<Student> students = new ArrayList<>();
        sc.nextLine();
        n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            details = sc.nextLine().split(" ");
            if(details[2].equals("UG")){
                Undergraduate ug = new Undergraduate(details[0],details[1]);
                ug.setFeeDetails(ugfees);
                students.add(ug);
            }
            else{
                Postgraduate pg = new Postgraduate(details[0],details[1]);
                pg.setFeeDetails(pgfees);
                students.add(pg);
            }
        }
        rollid = sc.nextLine();
        for(Student i : students){
            if(i.roll.equals(rollid)){
                System.out.println(i.getFeeDetails());
                break;
            }
        }
    }
}
