package lightproject.utility;

/**
 *
 * 
 */
public class Normal {
    
    public double x, y, z;
    
    public Normal(){
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }//Default Constructor
    
    public Normal(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }//Constructor
    
    public Normal(Normal normal){
        x = normal.x;
        y = normal.y;
        z = normal.z;
    }//Normal copy constructor
    
}// Normal
