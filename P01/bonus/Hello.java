
import java.util.Scanner;

public class Hello 
{
    public static void main(String[] args)
    {
        // useing the scanner class
        Scanner in = new Scanner(System.in);
        String name;

        System.out.print("Enter your name: ");
        // taking the next line from the console
        name = in.nextLine();
        // printing the name given
        System.out.println("Hello " + name);
    }
}