package product;


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
     * 
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

    /**
     * Returns the points or cost of the media.
     * 
     * @return the point cost of the media
     */
    public int getPoints()
    {
        return this.points;
    }

    /**
     * Returns a string representation of the media in the format 
     * "{title} ({url}, {points} points)".
     * 
     * @return a formatted string representing the media
     */
    @Override
    public String toString()
    {
        return this.title + " (" + this.url + ", " + this.points + " points" +")";
    }
}