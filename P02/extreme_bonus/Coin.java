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
        return this.denomination.getValue();
    }

    public int getYear()
    {
        return this.year;
    }

    public double getWeight()
    {
        double weight = 0; 
        switch(this.denomination)
        {
            case PENNY:
                weight = (this.year < 1983) ? 3.110 : 2.500;
                break;
            case NICKEL:
                weight = 5.000;
                break;
            case DIME:
                weight = (this.year < 1965) ? 2.500 : 2.268;
                break;
            case QUARTER:
                weight = (this.year < 1965) ? 6.250 : 5.670;
                break;

            default:
                weight = 0;
        }

        return weight;
    }

    @Override
    public String toString()
    {
        return this.year + " " + this.denomination;
    }


}