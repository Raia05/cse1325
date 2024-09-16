package test;

import customer.Student;
import product.Media;

public class TestStudent
{

    public static void main(String[] args)
    {
        int vector = 1;
        int result = 0;
        // Existing test for Student Kevin and Steve
        Student kevin = new Student("kevin", 1024353565, "kev0234@mavs.uta.edu", true);
        Student steve = new Student("steve", 1024453595, "kev0234@uta.edu", true);

        if(!("kevin (1024353565, kev0234@mavs.uta.edu, Account #1)".equals(kevin.toString())))
        {
            System.out.println("FAIL: expected kevin (1024353565, kev0234@mavs.uta.edu, Account #1) but got " + kevin.toString());
            result |= vector;

        }

        if(!("steve (1024453595, kev0234@uta.edu, Account #2)".equals(steve.toString())))
        {
            System.out.println("FAIL: expected steve (1024453595, kev0234@uta.edu, Account #2) but got " + steve.toString());
            result |= vector;

        }

        vector <<= 1;

        try
        {
            Student bapu = new Student("bapu", 102456795, "bapu0234@desi.education", true);
            System.err.println("FAIL: non-uta email not exception but " + bapu.toString());
            result |= vector;
        }
        catch(IllegalArgumentException e)
        {
        }

        // Check media playing with unlimited account
        Student student = new Student("Prof Rice", 1001234567, "george.rice@mavs.uta.edu", true);
        Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 0);

        if(!("Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0, 0 points)".equals(student.requestMedia(media))))
        {
            System.out.println("FAIL: expected Playing The Little Shop of Horrors but got: " + student.requestMedia(media));
            result |= vector;
        }


        // Additional test for Alacarte account and point system
        Student alacarteStudent = new Student("John", 1001452367, "john.doe@mavs.uta.edu", false);
        Media premiumMedia = new Media("Premium Movie", "https://example.com/premium-movie", 5);

        if(!("Buy more points: Requires 5 points, you have 0".equals(alacarteStudent.requestMedia(premiumMedia))))
        {
            System.out.println("FAIL: Expected to request more points for alacarte account but got: " + alacarteStudent.requestMedia(premiumMedia));
            result |= vector;

        }

        vector <<= 1;

        if(result != 0) System.err.println("\nFAIL: Error code " + result);
        System.exit(result);
    }
}
