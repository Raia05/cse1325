package customer;
import product.Media;



/**
 * Unlimited Account type that has no point restrictions on how much media they can watch.
 * 
 * @version 1.0
 * @since 1.0
 * @author Nafiul Arefeen
 */
public class Unlimited extends Account
{
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