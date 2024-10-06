package moes;

import java.util.ArrayList;
import customer.Student;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import product.Media;

/**
 * 
 * The interface class to the customer and product packages - it provides methods that should enable you to write your user interface 
 * 
 * @version 1.0
 * @since 1.0
 * @author Nafiul Arefeen
 */
public class Moes
{
    private ArrayList<Media> library;
    private ArrayList<Student> customers;

    /**
     * Adds a media item to the library.
     * @since 1.0
     * @param media the media item to add to the library
     */
    public void addMedia(Media media)
    {
        this.library.add(media);
    }

    public Moes()
    {
        this.library = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public Moes(BufferedReader br) throws IOException 
    {
        int mediaSize = Integer.parseInt(br.readLine());
        this.library = new ArrayList<>();
        for (int i = 0; i < mediaSize; i++) {
            this.library.add(new Media(br));
        }

        int studentSize = Integer.parseInt(br.readLine());
        this.customers = new ArrayList<>();
        for (int i = 0; i < studentSize; i++) {
            this.customers.add(new Student(br));
        }
    }

    public void save(BufferedWriter bw) throws IOException 
    {
        bw.write(this.library.size() + "\n");
        for (Media media : mediaList) {
            media.save(bw);
        }

        bw.write(this.customers.size() + "\n");
        for (Student student : studentList) {
            student.save(bw);
        }
    }

    /**
     * Returns a formatted list of all media in the library.
     * @since 1.0
     * @return a string representing the media list
     */
    public String getMediaList()
    {
        StringBuilder mediaList = new StringBuilder();

        for(int i = 0; i < this.library.size(); i++)
        {
            mediaList.append(i).append(") ").append(this.library.get(i).toString()).append("\n");
        }

        return mediaList.toString();

    }

    /**
     * Adds a student to the customers list.
     * @since 1.0
     * @param student the student to add to the service
     */
    public void addStudent(Student student)
    {
        this.customers.add(student);
    }


    /**
     * Returns a formatted list of all registered students.
     * @since 1.0
     * @return a string representing the student list
     */
    public String getStudentList()
    {
        StringBuilder studentList = new StringBuilder();

        for(int i = 0; i < this.customers.size(); i++)
        {
            studentList.append(i).append(") ").append(this.customers.get(i).toString()).append("\n");
        }

        return studentList.toString();

    }

    /**
     * Retrieves the available points for a given student based on their account type.
     * @since 1.0
     * 
     * @param studentIndex the index of the student in the customer list
     * @return the number of points the student has, or {@code Integer.MAX_VALUE} for unlimited accounts
     * @throws UnsupportedOperationException if the account type is unrecognized
     */
    public int getPoints(int studentIndex)
    {
        int points;
        Account account = this.customers.get(studentIndex).getAccount();
        if (account instanceof Alacarte)
        {
            Alacarte alacarte = (Alacarte)account;
            points = alacarte.getPointsRemaining();
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

    /**
     * Allows a student to purchase additional points, applicable only for Alacarte accounts.
     * @since 1.0
     * 
     * @param studentIndex the index of the student in the customer list
     * @param points the number of points to purchase
     * @return a confirmation message with the student's new point total, or a message for unlimited accounts
     * @throws UnsupportedOperationException if the account type is unrecognized
     */
    public String buyPoints(int studentIndex, int points)
    {
        String point;
        Account account = this.customers.get(studentIndex).getAccount();
        if (account instanceof Alacarte)
        {
            Alacarte alacarte = (Alacarte)account;
            alacarte.buyPoints(points);
            point = this.customers.get(studentIndex).toString() + " now has " + points + " points";
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

    /**
     * Allows a student to play a media item, deducting points if applicable.
     * @since 1.0
     * @param studentIndex the index of the student in the customer list
     * @param mediaIndex the index of the media in the library
     * @return a message indicating the media playback result
     */
    public String playMedia(int studentIndex, int mediaIndex)
    {
        return this.customers.get(studentIndex).requestMedia(this.library.get(mediaIndex));
    }



}