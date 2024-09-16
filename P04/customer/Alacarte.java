package customer;

import product.Media;

public class Alacarte extends Account
{
    private int pointsRemaining;

    public void buyPoints(int points)
    {
        pointsRemaining+=points;
    }

    public int getPointsRemaining()
    {
        return this.pointsRemaining;
    }

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