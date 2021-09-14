
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer{
    String name,Mobile;

    Customer(String name,String mobile){
        this.name = name;
        this.Mobile = mobile;
        //this.membership = new Membership(membership);
    }
}

class Service{
    String name;
    int rate;
    Service(String name,int rate){
        this.name = name;
        this.rate = rate;
    }
}

class Membership{
    String name;
    int discount;
    Membership(String name){
        this.name=name;
        if(name.equals("Premium")){
            this.discount = 20;
        }
        else if(name.equals("Gold")){
            this.discount = 15;
        }
        else if(name.equals("Silver")){
            this.discount=10;
        }
        else{
            this.discount = 0;
        }
    }

}
public class Q6 {
    public static void main(String[] args){
        String name,mobile,membership,service;
        int rate,total,tot;
        total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Details:");
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Mobile: ");
        mobile = sc.nextLine();
        System.out.print("Membership: ");
        membership = sc.nextLine();
        Customer customer = new Customer(name,mobile);
        Membership mem = new Membership(membership);
        List<Service> services= new ArrayList<Service>();
        while(true){
            System.out.print("Add Service(Y/N) :");
            if (sc.nextLine().equals("N")) break;
            System.out.print("ServiceName :");

            service = sc.nextLine();
            System.out.print("Rate :");

            rate = sc.nextInt();
            sc.nextLine();
            services.add(new Service(service,rate));

        }
        System.out.println("****** Bill ****");
        System.out.printf("%s %s %s\n",customer.name,customer.Mobile,mem.name);
        for(int i=0;i<services.size();i++){
            Service ser = services.get(i);
            System.out.printf("%d.%s  %d\n",i+1,ser.name,ser.rate);
            total+=ser.rate;
        }
        tot = total;
        total -=Math.floor(mem.discount*total/100);
        System.out.printf("Total: %d-%d\n",tot,tot-total);


        System.out.printf("Please Pay: %d",total);
    }
}
