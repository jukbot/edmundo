import greenfoot.*;
public class console extends play
{
GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3"); 
GreenfootImage BG = new GreenfootImage("gui/console/console.png");
public console()
{
    removeObjects(getObjects(null));
    MouseCursorWhite.setImage(); 
    addObject(new start(),974,490);
    setBackground(BG);
}
public void act()
    {    
    if(Greenfoot.isKeyDown("escape")) 
    {
       SFX2.play();
       removeObjects(getObjects(null));
       Greenfoot.setWorld(new mainmenu());
    }
}
}