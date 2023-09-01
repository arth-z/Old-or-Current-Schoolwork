import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A victory screen - mostly empty world displaying some text, and a ScoreBoard.
 * 
 * @author Arthur Zeng, Michael Liu
 * @version 2.00
 */
public class WinScreen extends World
{
    /**
     * Constructor for objects of class winScreen.
     * Adds the visual elements of the screen onto the world and accepts a score parameter to pass into UserInfo and its scoreboard.
     * Accepts this score from JestersRevenge, typically.
     * 
     * @param newScore          the new score of the User, to be passed into a scoreboard or userinfo.
     */
    public WinScreen(int newScore)
    {    
        super(1200, 800, 1); 
        if (UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();
            if (newScore > myInfo.getScore()) {
                myInfo.setScore(newScore);
                myInfo.store();  // write back to server
            }
        }
        setBackground("deathScreen.jpg");
        addObject(new Image(new GreenfootImage("victory.png")), getWidth()/2, getHeight() - getHeight() / 5);
        addObject(new ScoreBoard(300, 400), getWidth() / 2, getHeight() / 3);
    }
    
    /**
     * Stops Greenfoot.
     */
    public void act() {
        Greenfoot.stop();
    }
}
