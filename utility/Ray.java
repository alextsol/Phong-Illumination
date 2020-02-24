package lightproject.utility;


public class Ray extends Vector3D {
    public Vector3D origin;
    public Vector3D direction;
    
    public Ray ()
    {
        origin = new Vector3D();
        direction = new Vector3D(0.0,0.0,1.0);
    }
    
    public Ray(Vector3D origin, Vector3D direction){
       this.origin = new Vector3D(origin);
       this.direction = new Vector3D(direction);
    }//Constructor 
    
    public Ray(Ray otherRay)
    {
        if(this==otherRay)
        {
            return;
        }
        origin = otherRay.origin;
        direction = otherRay.direction;
    }//Copy Constructor
    
//    -------------------------------------------------
//                  Methods
//    -------------------------------------------------
    
    public void Equals(Ray otherRay)
    {
        if(this==otherRay)
        {
            return;
        }
        origin=otherRay.origin;
        direction = otherRay.direction;
    }//Equals
    
    public void normaliseDirection()
    {
        direction.normalise();
    }//normaliseDirection
    
    public Vector3D getPoint(Vector3D distance)
    {
        return (origin.add(direction)).vectorMul(origin);
    }//getPoint
    
    public void fromLineSegment(Vector3D start, Vector3D stop)
    {
        origin = start;
        direction = stop.sub(start);
    }//fromLineSegment
    
    
    public void toLineSegment(double distance, Vector3D start, Vector3D stop)
    {
        start = origin;
        stop = (origin.add(direction)).mul(distance);
    }//toLineSegment
    
}//Ray
