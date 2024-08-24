
import java.util.Scanner;

public class Hello 
{
    public static void main(String[] args)
    {
        // useing the scanner class
        Scanner in = new Scanner(System.in);
        String name;

        System.out.print("Enter your name: ");
        name = in.nextLine();
        System.out.println("Hello " + name);
    }
}