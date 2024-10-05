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

    public Account(BufferedReader br) throws IOException 
    {
        this.accountNumber = Integer.parseInt(br.readLine());
        Account.nextAccountNumber = Integer.parseInt(br.readLine());


    }

    public void save(BufferedWriter bw) throws IOException 
    {
        bw.write("" + this.accountNumber + "\n");
        bw.write("" + this.nextAccountNumber + "\n");


    }

    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    public abstract String play(Media media);

}