import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cloud extends Actor
{
    public Cloud(){
        GreenfootImage image = getImage();
        image.scale(100, 150);
    }
    /**
     * Act - do whatever the slinder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         setLocation(getX() - 5, getY());
         if(getX() <= 1){
            setLocation(getX() + 300, Greenfoot.getRandomNumber(250)+50);
        }
    }    
}
