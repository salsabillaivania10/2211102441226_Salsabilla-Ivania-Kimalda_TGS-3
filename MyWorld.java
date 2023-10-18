import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 800x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1); 
        addObject(new Bird(), 100, 300);
        addObject(new Slinder(), 300, 150);
        addObject(new Score(), 300, 100);
        addObject(new Kaktus(),600, 450);
        addObject(new Cloud(), 100, 150);
        
    }
}
