package mdi;
import moes.Moes;
import java.util.Scanner;
import customer.Student;
import product.Media;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main
{
    private static final String extension = ".moes";
    private static final String magicCookie = "moes";
    private static final String fileVersion = "0.2";
    private String filename = "NewFile.moes";
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running;
    private static Scanner in = new Scanner(System.in);
    private String menuTitle = """
      ___           ___           ___           ___     
     /\\  \\         /\\  \\         /\\__\\         /\\__\\    
    |::\\  \\       /::\\  \\       /:/ _/_       /:/ _/_   
    |:|:\\  \\     /:/\\:\\  \\     /:/ /\\__\\     /:/ /\\  \\  
  __|:|\\:\\  \\   /:/  \\:\\  \\   /:/ /:/ _/_   /:/ /::\\  \\ 
 /::::|_\\:\\__\\ /:/__/ \\:\\__\\ /:/_/:/ /\\__\\ /:/_/:/\\:\\__\\
 \\:\\~~\\  \\/__/ \\:\\  \\ /:/  / \\:\\/:/ /:/  / \\:\\/:/ /:/  /
  \\:\\  \\        \\:\\  /:/  /   \\::/_/:/  /   \\::/ /:/  / 
   \\:\\  \\        \\:\\/:/  /     \\:\\/:/  /     \\/_/:/  /  
    \\:\\__\\        \\::/  /       \\::/  /        /:/  /   
     \\/__/         \\/__/         \\/__/         \\/__/  
    """;
    private void addStudent()
    {

        String name = getString("Student name? ");
        boolean unlimited;
        int id = getInt("Student ID? ");

        String email = getString("Student email? ");
        char account = getString("(a)lacarte or (u)nlimited? ").toCharArray()[0];

        if (account == 'a')
            unlimited = false;
        else if (account == 'u')
            unlimited = true;
        else
            throw new IllegalArgumentException("unknown Account type specified");

        Student student = new Student(name, id, email, unlimited);

        this.moes.addStudent(student);
        this.output = "~".repeat(25) + "\n" + "Added student " + student + "\n" +"~".repeat(25) + "\n";

    }

    private void listStudents()
    {
        this.output = "~".repeat(25) + "\n" + this.moes.getStudentList() + "\n" +"~".repeat(25) + "\n";
    }

    private void addMedia()
    {

        String title = getString("Title? ");
        String url = getString("URL? ");
        int points = getInt("Points? ");

        Media media = new Media(title, url, points);
        this.moes.addMedia(media);
        this.output = "~".repeat(25) + "\n" + "Added media " + media + "\n" +"~".repeat(25) + "\n";



    }

    private void playMedia()
    {

        int student = getInt("Student number? ");
        int media = getInt("Media number? ");

        this.output = "~".repeat(25) + "\n"  + this.moes.playMedia(student, media) + "\n" +"~".repeat(25) + "\n";


    }

    private void listMedia()
    {
        this.output = "~".repeat(25) + "\n" + this.moes.getMediaList() + "\n" +"~".repeat(25) + "\n";
    }

    private void AvailablePoints()
    {

        int student = getInt("Student number? ");
        this.output = "~".repeat(25) + "\n" + "Student has " + this.moes.getPoints(student) + " Points" + "\n" +"~".repeat(25) + "\n";



    }

    private void buyPoints()
    {

        int student = getInt("Student number? ");
        int points = getInt("Points? ");
        this.output = "~".repeat(25) + "\n" + this.moes.buyPoints(student, points) + "\n" +"~".repeat(25) + "\n";

        
    }
    private void newMoes() 
    {
        moes = new Moes();
    }

    private void save() throws IOException 
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) 
        {
            bw.write(magicCookie + "\n" + fileVersion + "\n");
            moes.save(bw);
        } 
        catch (IOException e) 
        {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private void saveAs() throws IOException
    {
        System.out.print("Current File Name: " + filename + "\n");
        this.filename = getString("Enter new filename: ", "");
        if (!this.filename.endsWith(extension)) 
        {
            this.filename += extension;
        }
        save();
    }

    private void open() throws IOException 
    {
        String newFilename = getString("Enter filename to open: ", "");
        if (!newFilename.endsWith(extension)) 
        {
            newFilename += extension;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(newFilename))) 
        {
            if (br.readLine().equals(magicCookie) && br.readLine().equals(fileVersion))
            {
                try
                {
                    this.moes = new Moes(br);
                    this.filename = newFilename;
                }
                catch (IOException e)
                {
                    System.err.println(e.getMessage());
                }

            }
            else
            {
                throw new IOException("file does not match version or cookie");
            }

        } 
        catch (IOException e) 
        {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }

    public Main() throws IOException
    {
        this.running = true;
        this.moes = new Moes();
        this.menu = new Menu();
        this.output = "";

            this.menu.addMenuItem(new MenuItem("Exit\n", () -> endApp()));
            this.menu.addMenuItem(new MenuItem("Play media", () -> playMedia()));
            this.menu.addMenuItem(new MenuItem("List media", () -> listMedia()));
            this.menu.addMenuItem(new MenuItem("List available points", () -> AvailablePoints()));
            this.menu.addMenuItem(new MenuItem("Buy points", () -> buyPoints()));
            this.menu.addMenuItem(new MenuItem("Add media", () -> addMedia()));
            this.menu.addMenuItem(new MenuItem("List all students", () -> listStudents()));
            this.menu.addMenuItem(new MenuItem("Add a student\n", () -> addStudent()));
            this.menu.addMenuItem(new MenuItem("New Instance", () -> newMoes()));
            this.menu.addMenuItem(new MenuItem("Save file", () -> {
                try {
                    save();
                } catch (IOException e) {
                    System.out.println("Error saving file: " + e.getMessage());
                }
            }));

            this.menu.addMenuItem(new MenuItem("Save file As", () -> {
                try {
                    saveAs();
                } catch (IOException e) {
                    System.out.println("Error saving file as: " + e.getMessage());
                }
            }));

            this.menu.addMenuItem(new MenuItem("Open File", () -> {
                try {
                    open();
                } catch (IOException e) {
                    System.out.println("Error opening file: " + e.getMessage());
                }
            }));



    }

    public static void main(String[] args) 
    {
        try
        {
            Main app = new Main();
            app.mdi();
        }
        catch (IOException e) 
        {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }

    private void mdi()
    {
        while(this.running)
        {
            try
            {
                System.out.println(menuTitle + "\n" + this.filename + "\n\n" + this.menu + "\n" + this.output);
                this.output = "";
                Integer i = getInt("Selection? ");
                if (i == null) continue;
                menu.run(i);
            }
            catch (Exception e)
            {
                System.out.println("#### Invalid command");
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
        if(cancelInput != null && s.equals(cancelInput)) s = null;
        return s;
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