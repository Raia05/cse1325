public class Account
{
    private int accountNumber;
    private static int nextAccountNumber = 0;

    public Account()
    {
        this.accountNumber = ++Account.nextAccountNumber;
    }

    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    public String play(Media media)
    {
        return "Playing " + media;
    }
}