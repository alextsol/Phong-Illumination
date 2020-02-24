package lightproject.utility;

/**
 *
 * 
 */
public class Light {
    
    public Point3D position = new Point3D();
    public void setPosition(Point3D position){
        this.position = position;
    }//setPosition
    
    public Color intensity = new Color(1,1,1);
    public void setIntensity(Color intensity){
        this.intensity = intensity;
    }//setIntensity
    
    public Light(){ }
    
    @Override
    public String toString(){
        return "Light: "+position+" "+intensity;
    }
}
