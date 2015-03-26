import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class intro extends World
{
GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3"); 
GreenfootImage BG = new GreenfootImage("gui/intro/instruction.png");
public intro()
    {    
    super(1100,550,1);
    setBackground(BG);
    removeObjects(getObjects(null));
    MouseCursor.setImage(); 
    }
public void act()
{
      if(Greenfoot.isKeyDown("escape")) 
    {
       SFX2.play();
       removeObjects(getObjects(null));
       Greenfoot.setWorld(new console());
    }
    if(Greenfoot.isKeyDown("enter")) 
    {
       SFX2.play();
       removeObjects(getObjects(null));
       Greenfoot.setWorld(new Lobby());
    }
}
}
