import greenfoot.*;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
/**
 * A user-controlled actor that walks and jumps, and is pulled down by gravity.
 * <l><li>Left arrow moves actor left (toward left scroll limit)</li>
 * <li>Right arrow moves actor right (toward right scroll limit)</li>
 * <li>Up arrow makes the actor jump</li><l>
 */
public class player extends Actor
{
    final int jSpeed = 25; // the initial 'jump' speed
    int ySpeed = 0, xSpeed = 0; // the initial vertical and horizontal speeds
    boolean aboutFace; // the direction (left or right) the actor is facing
    boolean onGround; // the state of the actor being set on an object or not
    static boolean left;
    GreenfootSound HitSFX = new GreenfootSound("sfx/ouch.mp3");
    GreenfootSound shootSFX = new GreenfootSound("sfx/shoot.wav");
    /** 
     * Checks for changes in direction and moves the main actor.
     */
    public void act()
    {
    Lobby lob = (Lobby) getWorld();
    if(!lob.isPaused()) 
       {     
        getDirection();
        move();
        checkHitBot();
    }
    }
    
    /**
     * Moves the actor with appropriate image.  Checks for obstacles and adjusts
     * the position of the actor accordingly.
     */
    private void move()
    {
        ySpeed++; // adds gravity
        if (xSpeed != 0 && onGround) xSpeed+=aboutFace?1:-1; // add friction
        setLocation(getX()+xSpeed/10, getY()+ySpeed/2);
        // check for change in horizontal direction
        if((xSpeed>0 && aboutFace) || (xSpeed<0 && !aboutFace)) 
        {
            getImage().mirrorHorizontally();
            aboutFace = !aboutFace;
        }
        
        // check for obstacles
        onGround=false; // initialize value
        // check below the actor
        while(getOneObjectAtOffset(0, getImage().getHeight()/2+1, null)!=null)
        {
            setLocation(getX(), getY()-1); 
            onGround=true; 
            ySpeed=0;
        }
        // check above the actor
        while(getOneObjectAtOffset(0, -getImage().getHeight()/2-1, null)!=null) 
        {
            setLocation(getX(), getY()+1);
            ySpeed = 0;
        }
        // check to right of actor
        while(getOneObjectAtOffset(getImage().getWidth()/2+1, 0, null)!=null)
        {
            setLocation(getX()-1, getY());
            xSpeed = 0;
        }
        // check to left of actor
        while(getOneObjectAtOffset(-getImage().getWidth()/2-1, 0, null)!=null)
        {
            setLocation(getX()+1, getY());
            xSpeed = 0;
        }
    }
    
    /**
     * Determines any changes in horizontal and vertical speeds for the actor.
     */
    private void getDirection()
    {
//         if (!onGround) return; // if not mid-air changes allowed
        // sets requested direction of move, or continues in current direction
        if (Greenfoot.isKeyDown("left") ){ xSpeed-=2; left = true; }// check left && xSpeed>-50
        if (Greenfoot.isKeyDown("right") ){ xSpeed+=2; left = false;} // check right && xSpeed<50
        if (Greenfoot.isKeyDown("up") && onGround) // check jump
        {
            ySpeed -= jSpeed; // add jump speed
        }
        if( Greenfoot.isKeyDown("space") )
        {
            shoot();
            shootSFX.play();
        }
    }
    
    private void shoot()
    {
      getWorld().addObject(new bullet(),getX(),getY());
    }
    
    public boolean isLeft() {
       return left;
    }
    
    private void checkHitBot()
    {
        HealthBar bar = new HealthBar(100,100);
        if(isTouching(jukbot.class)){
           //(bar, -100, Color.red);
           HitSFX.play();
        }
    }
    
    
    
    /*
    

    private int speed = 5;
    private int vSpeed = 10;
    private int gravity = 2;
    public void act() 
    {
       keyControl();
       fall();
    }
    
    public Onodera(){
    }
    
    public void keyControl(){
      if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY() - speed);
      }
      if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY() + speed);
      }
      if(Greenfoot.isKeyDown("left")){
          setImage("onoderaLeft.png");
          setLocation(getX() - speed,getY());
      }
      if(Greenfoot.isKeyDown("right")){
          setImage("onoderaRight.png");
          setLocation(getX() + speed,getY());
      }
      if(Greenfoot.isKeyDown("space")){
            jump();
      }
    }
    
    public void fall(){
        setLocation(getX(), getY() + vSpeed);
        vSpeed = gravity + vSpeed;
    }
    
    public void jump(){
        vSpeed = -10;
        fall();
    }
}
*/
}
