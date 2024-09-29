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

    private void addStudent()
    {
        Scanner in = new Scanner(System.in);

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
        Scanner in = new Scanner(System.in);

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

    }

    private void listMedia()
    {
        System.out.println(this.moes.getMediaList());
    }

    private void AvailablePoints()
    {

    }

    private void buyPoints()
    {
        
    }

    
}