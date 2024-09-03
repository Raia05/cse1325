public class Purse
{
        public static void main(String[] args) 
        {
            Coin purse[] = 
            {
                new Coin(Denomination.DIME, 1993), // December 10 1993: when Doom was released
                new Coin(Denomination.NICKEL, 2014), // 2014 is when Five nights at freddies was released
                new Coin(Denomination.PENNY, 1999), // 1999 when one piece started
                new Coin(Denomination.QUARTER, 1972), // bangladesh independence  
                new Coin(Denomination.NICKEL, 1964) // when nick cage was born
            };
            
            int minYear = purse[0].getYear();
            int maxYear = purse[0].getYear();
            double sum = 0;
            double totalWeight = 0;

            for(Coin coin : purse)
            {
                System.out.println(coin);
                if(coin.getYear() < minYear)
                {
                    minYear = coin.getYear();
                }

                if (coin.getYear() > maxYear)
                {
                    maxYear = coin.getYear();
                }
                totalWeight+= coin.getWeight();
                sum+= coin.getValue();
            }

            System.out.println("You have $ " + sum + " in coins between " + minYear + " and " + maxYear + " weighing " + String.format("%.3f",totalWeight) + " grams");



        }
}