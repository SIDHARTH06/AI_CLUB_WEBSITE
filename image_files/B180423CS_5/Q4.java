
import java.util.Scanner;

abstract class Addition{
    abstract String add();
}

class IntegerAddition extends Addition{
    int a,b;
    IntegerAddition(int a,int b){
        this.a =a;
        this.b=b;
    }
    String add(){
        return Integer.toString(a+b);
    }
}

class FractionAddition{
    int a,b,c,d;
    FractionAddition(int a,int b,int c,int d){
        this.a =a;
        this.b=b;
        this.c =c;
        this.d=d;
    }
    int hcf(int a,int b){
        int max,min;
        max = Math.max(a,b);
        min = Math.min(a,b);
        if(min==0)
            return max;

        return hcf(max-min,min);

    }
    String add(){
        int nem,den,f;
        nem = a*d+b*c;
        den = b*d;
        f = this.hcf(nem,den);
        return Integer.toString(nem/f)+'/'+Integer.toString(den/f);
    }
}
public class Q4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        IntegerAddition ia = new IntegerAddition(sc.nextInt(),sc.nextInt());
        sc.nextLine();
        FractionAddition fa = new FractionAddition(sc.nextInt(),sc.nextInt(),sc.nextInt(),
                sc.nextInt());
        sc.nextLine();
        System.out.println(ia.add());
        System.out.println(fa.add());
    }
}
