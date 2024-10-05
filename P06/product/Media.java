package product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
/**
 * 
 * Models a Media instance for the Moes system using a title, url, and how many points it costs.
 * 
 * 
 * @version 1.0
 * @since 1.0
 * @author Nafiul Arefeen
 */
public class Media
{
    private String title;
    private String url;
    private int points;

    /**
     * Constructs a Media object with the specified title, URL, and points.
     * @since 1.0
     * @param title  the title of the media
     * @param url    the URL associated with the media
     * @param points the points or rating assigned to the media
     */
    public Media(String title, String url, int points)
    {
        this.title = title;
        this.url = url;
        this.points = points;
    }

    public Media(BufferedReader br) throws IOException
    {
        this.title = br.readLine();
        this.url = br.readLine();
        this.points = Integer.parseInt(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException
    {
        bw.write(this.title + "\n");
        bw.write(this.url + "\n");
        bw.write("" + this.points + "\n");
    }

    /**
     * Returns the points or cost of the media.
     * @since 1.0
     * @return the point cost of the media
     */
    public int getPoints()
    {
        return this.points;
    }

    /**
     * Returns a string representation of the media in the format 
     * "{title} ({url}, {points} points)".
     * @since 1.0
     * @return a formatted string representing the media
     */
    @Override
    public String toString()
    {
        return this.title + " (" + this.url + ", " + this.points + " points" +")";
    }
}