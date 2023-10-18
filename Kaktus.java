import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Kaktus extends Actor
{
    public Kaktus(){
        GreenfootImage image = getImage();
        image.scale(300, 500);
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
            setLocation(getX() + 300, Greenfoot.getRandomNumber(250)+50);
        }
    }    
}
