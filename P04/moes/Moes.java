package moes;

import java.util.ArrayList;
import customer.Student;
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

    }

    public String buyPoints(int studentIndex, int points)
    {

    }

    public String playMedia(int studentIndex, int mediaIndex)
    {

    }



}