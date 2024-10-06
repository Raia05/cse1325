package customer;
import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


/**
 * Unlimited Account type that has no point restrictions on how much media they can watch.
 * 
 * @version 1.0
 * @since 1.0
 * @author Nafiul Arefeen
 */
public class Unlimited extends Account
{
    public Unlimited() 
    {
        super();
    }

    public Unlimited(BufferedReader br) throws IOException 
    {
        super(br);
    }

    public void save(BufferedWriter bw) throws IOException 
    {
        super.save(bw);
    }
    /**
     * Attempts to play the specified media.
     * 
     * @param media the media to be played
     * @return a string indicating the media is playing
     */
    @Override
    public String play(Media media)
    {
        return "Playing " + media;
    }

}