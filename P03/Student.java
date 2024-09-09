public class Student
{
    private String name;
    private int id;
    private String email;
    private Account account;

    Student(String name, int id, String email)
    {
        this.name = name;
        this.id = id;
        if(!(email.endsWith("@uta.edu") || email.endsWith("@mavs.uta.edu")))
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        this.email = email;

        this.account = new Account();

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