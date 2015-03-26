import greenfoot.*;
public class music extends gui
{
    public static GreenfootSound BGM = new GreenfootSound("bg/K-Hole.mp3");   
    public String filename;
    private boolean mouseOver = false;
    private static boolean isPlay;
    private static boolean BGMisPlay;
    private static int BGMvolume;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    public void setImageON()
    {
        getWorld().addObject(new ON(), 585, 165);
        getWorld().removeObject(this);
    }
    public void setImageOFF()
    {
        getWorld().addObject(new OFF(), 585, 165);
        getWorld().removeObject(this);
    }
    public static void startBGM()
    {
        BGM.playLoop(); 
        BGMisPlay = true;
    }
    public static void stopBGM(){
        BGM.stop();
        BGMisPlay = false;
    } 
    public static void setVolumeBGM(int a) { 
        BGM.setVolume(a);
    }
    
    public int getVolumeBGM() {
       return BGM.getVolume();
    }
    
    public String toString() {
        String s = super.toString() + " file: " + filename + " ";
        if(BGM != null) {
            s += ". Is playing: " + BGM.isPlaying();
        }
        else {
            s += ". Not found.";
        }
        return s;
    }
    
    public boolean BGMstatus() {
       return BGMisPlay;    
    }
    
    public boolean BGMisPlaying() {
        if(BGM.isPlaying()) {isPlay = true;}
        if(!BGM.isPlaying()) {isPlay = false;}
        return isPlay;
    }
    
    public String BGMname() {
        return BGM.toString();
    }
}
