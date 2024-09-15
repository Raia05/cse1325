public class TestStudent
{
    public static void main(String[] args)
    {
        Student kevin = new Student("kevin", 1024353565, "kev0234@mavs.uta.edu");
        Student steve = new Student("steve", 1024453595, "kev0234@uta.edu");

        if(!("kevin (1024353565, kev0234@mavs.uta.edu, Account #1)".equals(kevin.toString())))
        {
            System.out.println("FAIL: expected kevin (1024353565, kev0234@mavs.uta.edu, Account #1) but got " + kevin.toString());

        }

        if(!("steve (1024453595, kev0234@uta.edu, Account #2)".equals(steve.toString())))
        {
            System.out.println("FAIL: expected steve (1024453595, kev0234@uta.edu, Account #2) but got " + steve.toString());

        }

        try
        {
            Student bapu = new Student("bapu", 102456795, "bapu0234@desi.education");
            System.err.println("FAIL: non-uta email not exception but " + bapu.toString());
            System.exit(-1);

        }
        catch(Exception e)
        {
            
        }

        Student student = new Student("Prof Rice", 1001234567, "george.rice@mavs.uta.edu");
        Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");

        if(!("Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)".equals(student.requestMedia(media))))
        {
            System.out.println("expected Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0) but got: " + student.requestMedia(media));
        }
    }



}