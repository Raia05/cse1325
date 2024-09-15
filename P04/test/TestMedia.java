package test;

public class TestMedia
{
    public static void main(String[] args)
    {
        Media media = new Media("name", "URL");
        Media horror = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");

        if(!("name (URL)".equals(media.toString())))
        {
            System.out.println("FAIL: expected name (URL) but got " + media.toString());
        }

        if(!("The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)".equals(horror.toString())))
        {
            System.out.println("FAIL: expected The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0) but got " + horror.toString());
        }
    }
}