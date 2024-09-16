package customer;

import product.Media;

public class Student
{
    private String name;
    private int id;
    private String email;
    private Account account;

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

    public Account getAccount()
    {
        return this.account;
    }

    public String requestMedia(Media media)
    {
        return this.account.play(media);
    }

    @Override
    public String toString()
    {
        return this.name + " (" + this.id + ", " + this.email + ", Account #" + this.account.getAccountNumber() + ")";
    }
}