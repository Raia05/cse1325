public class Coin
{
    private final Denomination denomination;
    private final int year;

    public Coin(Denomination denomination, int year)
    {
        this.denomination = denomination;
        this.year = year;
    }

    public double getValue()
    {
        return 
            switch (this.denomination)
            {
                case PENNY -> 0.01;
                case NICKEL -> 0.05;
                case DIME -> 0.10;
                case QUARTER -> 0.25;
                default -> 0;

            };
    }

    public int getYear()
    {
        return this.year;
    }


}