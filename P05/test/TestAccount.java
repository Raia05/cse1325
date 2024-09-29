package test;

import customer.Account;
import customer.Alacarte;
import customer.Unlimited;
import product.Media;

public class TestAccount
{
    public static void main(String[] args)
    {
        int result = 0;

        // Test account number auto-increment
        Alacarte firstAccount = new Alacarte();
        Unlimited secondAccount = new Unlimited();

        if (firstAccount.getAccountNumber() != 1)
        {
            System.out.println("FAIL: expected 1 for account number but got " + firstAccount.getAccountNumber());
            result = 1;
        }


        if (secondAccount.getAccountNumber() != 2)
        {
            System.out.println("FAIL: expected 2 for account number but got " + secondAccount.getAccountNumber());
            result = 1;
        }


        // Test Alacarte point system
        Media premiumMedia = new Media("Premium Movie", "https://example.com/premium-movie", 5);
        Alacarte alacarteAccount = new Alacarte();

        if (!("Buy more points: Requires 5 points, you have 0".equals(alacarteAccount.play(premiumMedia))))
        {
            System.out.println("FAIL: expected Buy more points but got " + alacarteAccount.play(premiumMedia));
            result = 1;

        }


        alacarteAccount.buyPoints(10);

        if (!("Playing Premium Movie (https://example.com/premium-movie, 5 points)".equals(alacarteAccount.play(premiumMedia))))
        {
            System.out.println("FAIL: expected Playing Premium Movie but got " + alacarteAccount.play(premiumMedia));
            result = 1;
        }


        // Test Unlimited account play
        Unlimited unlimitedAccount = new Unlimited();

        if (!("Playing Premium Movie (https://example.com/premium-movie, 5 points)".equals(unlimitedAccount.play(premiumMedia))))
        {
            System.out.println("FAIL: expected Playing Premium Movie but got " + unlimitedAccount.play(premiumMedia));
            result = 1;
        }


        if(result != 0) System.err.println("\nFAIL: Error code " + result);
        System.exit(result);

    }
}
