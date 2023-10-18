import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Slinder extends Actor
{
    public Slinder(){
        GreenfootImage image = getImage();
        image.scale(700, 900);
    }
    /**
     * Act - do whatever the slinder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         setLocation(getX() - 1, getY());
         if(getX() <= 1){
            setLocation(getX() + 600, Greenfoot.getRandomNumber(250)+50);
        }
    }    
}
