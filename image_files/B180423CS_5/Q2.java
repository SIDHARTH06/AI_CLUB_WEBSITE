
import java.util.Scanner;

abstract class Bank{
    double amount;
    int interest;
    public void calculateInterest(int amount){
        this.interest=0;
    }
    public void display_interest(){
        System.out.println(this.interest);
    }
}

class SBI extends Bank{
    @Override
    public void calculateInterest(int amount){
        this.interest = 5*amount/100;
    }
}
class Ic extends Bank{
    @Override
    public void calculateInterest(int amount){
        this.interest = 6*amount/100;
    }
}
class AXIS extends Bank{
    @Override
    public void calculateInterest(int amount){
        this.interest = 7*amount/100;
    }
}
public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int amount;
        amount = sc.nextInt();
        sc.nextLine();
        Bank sbi = new SBI();
        Bank icici = new Ic();
        Bank axis = new AXIS();
        System.out.print("SBI interest is : ");
        sbi.calculateInterest(amount);
        sbi.display_interest();
        System.out.print("ICICI interest is : ");
        icici.calculateInterest(amount);
        icici.display_interest();
        System.out.print("AXIS interest is : ");
        axis.calculateInterest(amount);
        axis.display_interest();

    }
}
