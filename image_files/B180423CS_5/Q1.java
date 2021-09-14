
import java.util.Scanner;

class Display
{
    public void display (int a,int b)
    {
        System.out.println(a*a+b*b);
    }

    public void display (int a)
    {
        System.out.println((a*(a+1))/2);
    }

    public void display (char car,int b)
    {
        for(int i=1;i<b+1;i++)
        {
            for(int j=1;j<i+1;j++)
            {
                System.out.print(car+" ");
            }
            System.out.println();
        }
    }

}




public class Q1
{
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args)
    {
        String str=sc.nextLine();
        String[] values=str.split(" ");
        int l= values.length;
        int k,a,b;
        char c;
        Display dis =new  Display();
        if(l==1)
        {a= Integer.parseInt(values[0]);
            dis.display(a);
        }
        else if(l==2)
        {c=values[0].charAt(0);
            k=c-'0';
            if(k>=0 && k<=9)
            {
                a= Integer.parseInt(values[0]);
                b= Integer.parseInt(values[1]);
                dis.display(a,b);
            }
            else
            {
                b= Integer.parseInt(values[1]);
                dis.display(c,b);
            }


        }


    }

}

