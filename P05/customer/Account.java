package customer;

import product.Media;
public abstract class Account
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

    public abstract String play(Media media);

}