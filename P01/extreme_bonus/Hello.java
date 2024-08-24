

public class Hello 
{
    public static void main(String[] args)
    {
        String name = System.getProperty("user.name");
        // uses the system property of the user name to get the name rather than passed in input

        System.out.println("Hello " + name);
    }
}