package customer;

import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;



/**
 * creates a student object that can hold an account for database purposes.
 * 
 * @version 1.0
 * @since 1.0
 * @author Nafiul Arefeen
 */
public class Student
{
    private String name;
    private int id;
    private String email;
    private Account account;


    /**
     * Constructs a {@code Student} object with the specified name, ID, email, 
     * and account type.
     * @since 1.0
     * @param name the student's name
     * @param id the student's ID
     * @param email the student's email, which must be a UTA email address
     * @param unlimited {@code true} if the student has an Unlimited account, 
     *                  {@code false} for an Alacarte account
     * @throws IllegalArgumentException if the email is not a valid UTA email address
     */
    public Student(String name, int id, String email, boolean unlimited)
    {
        this.name = name;
        this.id = id;
        if(!(email.endsWith("@uta.edu") || email.endsWith("@mavs.uta.edu")))
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        this.email = email;
        if(unlimited)
        {
            this.account = new Unlimited();
        }
        else
        {
            this.account = new Alacarte();
        }

    }


    public Student(BufferedReader br) throws IOException 
    {
        this.name = br.readLine();
        this.email = br.readLine();
        this.id = Integer.parseInt(br.readLine());

        String accountType = br.readLine();
        if (accountType.equals("Unlimited")) {
            this.account = new Unlimited(br);
        } else if (accountType.equals("Alacarte")) {
            this.account = new Alacarte(br);
        }
    }

    public void save(BufferedWriter bw) throws IOException 
    {
        bw.write(name + "\n");
        bw.write(email + "\n");
        bw.write(Integer.toString(id) + "\n");
        bw.write(account.getClass().getSimpleName() + "\n");
        account.save(bw);
    }

    /**
     * Returns the student's account.
     * @since 1.0
     * @return the student's account
     */
    public Account getAccount()
    {
        return this.account;
    }

    public String requestMedia(Media media)
    {
        return this.account.play(media);
    }

    /**
     * Returns the student's account.
     * @since 1.0
     * @return the student's account
     */
    @Override
    public String toString()
    {
        return this.name + " (" + this.id + ", " + this.email + ", Account #" + this.account.getAccountNumber() + ")";
    }
}