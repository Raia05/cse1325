package moes;

import java.util.ArrayList;
import customer.Student;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;
import product.Media;

public class Moes
{
    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();

    public void addMedia(Media media)
    {
        this.library.add(media);
    }

    public String getMediaList()
    {
        StringBuilder mediaList = new StringBuilder();

        for(int i = 0; i < this.library.size(); i++)
        {
            mediaList.append(i).append(") ").append(this.library.get(i).toString()).append("\n");
        }

        return mediaList.toString();

    }

    public void addStudent(Student student)
    {
        this.customers.add(student);
    }

    public String getStudentList()
    {
        StringBuilder studentList = new StringBuilder();

        for(int i = 0; i < this.customers.size(); i++)
        {
            studentList.append(i).append(") ").append(this.customers.get(i).toString()).append("\n");
        }

        return studentList.toString();

    }

    public int getPoints(int studentIndex)
    {
        int points;
        Account account = this.customer.get(studentIndex).getAccount()
        if (account instanceof Alacarte)
        {
            points = (Alacarte)account.getPointsRemaining();
        }
        else if(account instanceof Unlimited)
        {
            points = Integer.MAX_VALUE;
        }
        else
        {
            throw new UnsupportedOperationException("unknown subclass of Account");
        }
        return points;
    }

    public String buyPoints(int studentIndex, int points)
    {
        String point;
        Account account = this.customer.get(studentIndex).getAccount()
        if (account instanceof Alacarte)
        {
            (Alacarte)account.buyPoints(points);
            point = this.customer.get(studentIndex).toString() + " now has " + points + " points";
        }
        else if(account instanceof Unlimited)
        {
            point = "this Student has an Unlimited Account and needs no additional points";
        }
        else
        {
            throw new UnsupportedOperationException("unknown subclass of Account");
        }
        return point;

    }

    public String playMedia(int studentIndex, int mediaIndex)
    {

    }



}