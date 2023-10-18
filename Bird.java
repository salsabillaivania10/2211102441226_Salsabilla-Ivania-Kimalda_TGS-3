import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Flappybird here.
 * setRotation((int)(1 * 16)); Greenfoot.playSound("flay.mp3");
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird extends Actor
{
    private double g = 1; 
    private int y = 300;
    private boolean haspressed = false;
    private boolean isalive = true;
    private boolean isacross = false;
    private boolean hasaddscore = false; //Nilai awal artinya belum ditambah terlalu banyak
    public Bird(){
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }
    /**
     * Act - do whatever the Flappybird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Jika menekan spasi, koordinat y akan berkurang dan terbang ke atas
        if(spacePressed()){
            g=-2;//Semakin rendah angkanya, semakin tinggi terbangannya
        }
        g +=0.1; //Nilai g meningkat 0,1 setiap saat
        y += g; //Dengan cara ini, nilai y tidak berubah dengan kecepatan konstan, tetapi menjadi semakin besar
        setLocation(getX(), (int)(y));
        //Jika menabrak kaktus maka game over
        if(isTouchkaktus()){
            isalive = false;
        }
        //Jika menabrak slinder maka game over
        if(isTouchslinder()){
            isalive = false;
        }
        //pemberian suara pada saat game over
        if(isAtEdge()){
            Greenfoot.playSound("peng.mp3");
            isalive = false;
        }
        //setelah jatuh atau menabrak slinder maka flappybird hilang
        if(!isalive){
            getWorld().addObject(new Gameover(), 300, 200);
            getWorld().removeObject(this);
        }
        //penambahan skor setalah melewati 1 slinder dan pemberian suara
        if(!hasaddscore && isacross && isalive){
            Greenfoot.playSound("score.mp3");
            Score.add(1);
        }
        hasaddscore = isacross;
        // Add your action code here.
    }
    //Mengembalikan apabila spasi ditekan
    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("space")){
            if(!haspressed){//Jika belum melepaskan spasi, jangan kembali true
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }
            haspressed = true; //spasi telah ditekan
        }else{
            haspressed = false;
        }
        return pressed;
    }
    //pemberian suara ketika menabrak selinder dan jatuh
    public boolean isTouchslinder(){
        isacross = false;
        for(Slinder slinder : getWorld().getObjects(Slinder.class)){
            if(Math.abs(slinder.getX() - getX()) < 60 ){
                if(Math.abs(slinder.getY() + 30 - getY()) > 37){
                    Greenfoot.playSound("peng.mp3");
                    isalive = false;
                }
                isacross = true; 
            }
        }
        return !isalive;
    }
    //pemberian suara ketika menabrak kaktus dan jatuh
    public boolean isTouchkaktus(){
        isacross = false;
        for(Kaktus kaktus : getWorld().getObjects(Kaktus.class)){
            if(Math.abs(kaktus.getX() - getX()) < 60 ){
                if(Math.abs(kaktus.getY() + 30 - getY()) > 37){
                    Greenfoot.playSound("peng.mp3");
                    isalive = false;
                }
                isacross = true; 
            }
        }
        return !isalive;
    }
}
