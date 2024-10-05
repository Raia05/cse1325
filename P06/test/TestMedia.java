package test;

import product.Media;

public class TestMedia
{
    public static void main(String[] args)
    {
        int vector = 1;
        int result = 0;

        Media media = new Media("name", "URL", 0);
        Media horror = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 0);
        Media premiumMedia = new Media("Premium Movie", "https://example.com/premium-movie", 5);

        if(!("name (URL, 0 points)".equals(media.toString())))
        {
            System.out.println("FAIL: expected name (URL, 0 points) but got " + media.toString());
            result |= vector;

        }


        if(!("The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0, 0 points)".equals(horror.toString())))
        {
            System.out.println("FAIL: expected The Little Shop of Horrors but got " + horror.toString());
            result |= vector;
        }


        if(!("Premium Movie (https://example.com/premium-movie, 5 points)".equals(premiumMedia.toString())))
        {
            System.out.println("FAIL: expected Premium Movie but got " + premiumMedia.toString());
            result |= vector;
        }

        if(result != 0) System.err.println("\nFAIL: Error code " + result);
        System.exit(result);

    }
}
