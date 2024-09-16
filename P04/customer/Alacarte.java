package customer;

import product.Media;

/**
 * Alacarte Account type that watches media by a point system rather than a as much as they like.
 * 
 * @version 1.0
 * @since 1.0
 * @author Nafiul Arefeen
 */
public class Alacarte extends Account
{
    private int pointsRemaining = 0;


    /**
     * Adds the specified number of points to the account.
     * @since 1.0
     * @param points the number of points to be added to the account
     */
    public void buyPoints(int points)
    {
        pointsRemaining+=points;
    }


    /**
     * Returns the number of points remaining in the account.
     * @since 1.0
     * @return the points remaining in the account
     */
    public int getPointsRemaining()
    {
        return this.pointsRemaining;
    }


    /**
     * Attempts to play the specified media, deducting points if enough points are available.
     * @since 1.0
     * @param media the media to be played
     * @return a string indicating whether the media is playing or if more points are needed
     */
    @Override
    public String play(Media media)
    {
        String playing;
        if(this.pointsRemaining >= media.getPoints())
        {
            playing = "Playing " + media;
        }
        else
        {
            playing = "Buy more points: Requires " + media.getPoints() + " points, you have " + this.pointsRemaining;
        }
        return playing;

    }

}