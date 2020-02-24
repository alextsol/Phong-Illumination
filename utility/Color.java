package lightproject.utility;

/**
 *
 * 
 */
public class Color {
    public float r,g,b;
    
    public Color(){
        r=g=b=0.0f;
    }//Default Constructor
    
    public Color(float r, float g, float b){
       this.r=r; 
       this.g=g;
       this.b=b;
    }//Constructor
    
    public Color(Color color){
        r = color.r;
        g = color.g;
        b = color.b;
    }
    
    public void add(Color color){
        r += color.r;
        g += color.g;
        b += color.b;
    }//add Color
    
    public void divide(int scalar){
        r /= scalar;
        g /= scalar;
        b /= scalar;
    }//divide
    
    public int toInteger(){
        return (int)(r*255)<<16|(int)(g*255)<<8|(int)(b*255);
    }//Because BufferedImage needs an integer value for the color
}
