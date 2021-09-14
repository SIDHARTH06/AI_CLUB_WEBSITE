
import java.util.Scanner;

class Rectangle
{
    int length;
    int breadth;

    Rectangle(int length,int breadth)
    {
        this.length=length;
        this.breadth=breadth;
    }
    public int perimeter()
    {
        return 2*(this.length+this.breadth);
    }

    public int area()
    {
        return this.length*this.breadth;
    }
}

class Square extends Rectangle
{
    Square(int a)
    {
        super(a,a);
    }

}




public class Q3
{
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args)
    {
        String temp=sc.nextLine();
        String[] values=temp.split(" ");
        int a,b;
        if(values.length==2)
        {a= Integer.parseInt(values[0]);
            b= Integer.parseInt(values[1]);
            Rectangle rectangle =new  Rectangle(a,b);
            System.out.println("Rectangle Perimeter "+rectangle.perimeter());
            System.out.println("Rectangle Area "+rectangle.area());
        }
        else if(values.length==1)
        {a= Integer.parseInt(values[0]);
            Square square =new  Square(a);
            System.out.println("Square Perimeter "+square.perimeter());
            System.out.println("Square Area "+square.area());
        }
        else{
            System.out.println("Incorect input please modify");
        }


    }

}
