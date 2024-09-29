package mdi;

public class MenuItem implements Runnable
{
    private Object menuText;
    private Runnable menuResponse;

    public MenuItem(Object menuText, Runnable menuResponse)
    {
        this.menuText = menuText;
        this.menuResponse = menuResponse;
    }

    @Override
    public void run()
    {
        menuResponse.run();
    }

    @Override
    public String toString()
    {
        return menuText.toString();
    }
}