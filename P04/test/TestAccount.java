package test;


public class TestAccount
{
    public static void main(String[] args)
    {
        Account firstAccount = new Account();
        Account secondAcconut = new Account();

        if (firstAccount.getAccountNumber() != 1)
        {
            System.out.println("FAIL: expected 1 for account number but got " + firstAccount.getAccountNumber());
        }
        if (secondAcconut.getAccountNumber() != 2)
        {
            System.out.println("FAIL: expected 2 for account number but got " + secondAcconut.getAccountNumber());

        }
    }
}