package mdi;
import moes.Moes;
import java.util.Scanner;
import customer.Student;
import product.Media;

public class Main
{
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running;
    private Scanner in = new Scanner(System.in);

    private void addStudent()
    {

        System.out.print("Student name? ");
        String name = in.nextLine();

        System.out.print("Student ID? ");
        int id = in.nextInt();

        System.out.print("Student email? ");
        String email = in.nextLine();

        System.out.print("(a)lacarte or (u)nlimited? ");
        char account = in.next().toCharArray()[0];

        if (account == 'a')
            boolean unlimited = false;
        else if (account == 'u')
            boolean unlimited = true;
        else
            throw new IllegalArgumentException("unknown Account type specified");

        Student student = new Student(name, id, email, unlimited);

        this.moes.addStudent(student);

    }

    private void listStudents()
    {
        System.out.println(this.moes.getStudentList());
    }

    private void addMedia()
    {

        System.out.print("Title? ");
        String title = in.nextLine();

        System.out.print("URL? ");
        String url = in.nextLine();

        System.out.print("Points? ");
        int points = in.nextInt();

        Media media = new Media(title, url, points);
        this.moes.addMedia(media);


    }

    private void playMedia()
    {

        System.out.print("Student number? ");
        int student = in.nextInt();

        System.out.print("Media number? ");
        int media = in.nextInt();

        this.moes.playMedia(student, media);

    }

    private void listMedia()
    {
        System.out.println(this.moes.getMediaList());
    }

    private void AvailablePoints()
    {

        System.out.print("Student number? ");
        int student = in.nextInt();

        this.moes.getPoints(student);


    }

    private void buyPoints()
    {

        System.out.print("Student number? ");
        int student = in.nextInt();

        System.out.print("Points? ");
        int points = in.nextInt();

        this.moes.buyPoints(student, points);
        
    }

    public Main()
    {
        this.running = true;
        this.moes = new Moes();
        this.menu = new Menu();
        this.output = "";

        this.menu.addMenuItem(new MenuItem("Exit", () -> endApp()));
        this.menu.addMenuItem(new MenuItem("Play media", () -> playMedia()));
        this.menu.addMenuItem(new MenuItem("List media", () -> listMedia()));
        this.menu.addMenuItem(new MenuItem("List available points", () -> AvailablePoints()));
        this.menu.addMenuItem(new MenuItem("Buy points", () -> buyPoints()));
        this.menu.addMenuItem(new MenuItem("Add media", () -> addMedia()));
        this.menu.addMenuItem(new MenuItem("List all students", () -> listStudents()));
        this.menu.addMenuItem(new MenuItem("Add a student", () -> addStudent()));








    }

    public static void main(String[] args) 
    {
        
    }

    private void mid()
    {
        while(this.running)
        {
            try
            {
                int i;
                if (i == null) continue;
                menu.run(i);
            }
            catch (Exception e)
            {
                print("#### Invalid command");
            }
        }

    }

    private void endApp()
    {
        this.running = false;
        
    }

    // helper methods
    public static String getString(String prompt, String cancelInput, String defualtInput)
    {
        String s = null;
        while(true)
        {
            try
            {
                System.out.print(prompt);
                s = in.nextLine().trim();
                if(s.isEmpty() && defualtInput != null) s = defualtInput;
                break;
            }
            catch(Exception e)
            {
                System.err.println("Invalid input!");
            }
            if(cancelInput != null && s.equals(cancelInput)) s = null;
            return s;

        }
    }


    public static String getString(String prompt, String cancelInput) 
    {
        return getString(prompt, cancelInput, null);
    }
    
    public static String getString(String prompt) 
    {
        return getString(prompt, null, null);
    }






    
}