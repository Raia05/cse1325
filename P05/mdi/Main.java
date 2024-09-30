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

        String name = getString("Student name? ");

        int id = getInt("Student ID? ");

        String email = getString("Student email? ");
        char account = getString("(a)lacarte or (u)nlimited? ").toCharArray[0];

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

        String title = getString("Title? ");
        String title = getString("URL? ");
        int points = getInt("Points? ");

        Media media = new Media(title, url, points);
        this.moes.addMedia(media);


    }

    private void playMedia()
    {

        int student = getInt("Student number? ")
        int media = getInt("Media number? ");

        this.moes.playMedia(student, media);

    }

    private void listMedia()
    {
        System.out.println(this.moes.getMediaList());
    }

    private void AvailablePoints()
    {

        int student = getInt("Student number?");
        this.moes.getPoints(student);


    }

    private void buyPoints()
    {

        int student = getInt("Student number? ");
        int points = getInt("Points? ");

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


    public static Integer getInt(String prompt, String cancelInput, String defaultInput) 
    {
        Integer i = null;
        while(true) {
            try 
            {
                String s = getString(prompt, cancelInput, defaultInput);
                if(s != null && !s.isEmpty()) i = Integer.parseInt(s);
                break;
            } 
            catch(Exception e) 
            {
                System.err.println("Invalid input!");
            }
        }
        return i;
    }


    public static Integer getInt(String prompt, String cancelInput) 
    {
        return getInt(prompt, cancelInput, null);
    }

    public static Integer getInt(String prompt) 
    {
        return getInt(prompt, null, null);
    }



    
}