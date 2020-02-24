package lightproject.utility;

import java.text.NumberFormat;

/**
 *
 * 
 */
public class Sphere extends Shape {
    
    public double radius;
    public Vector3D center;
    
    
    public Sphere ()
    {
        radius = 0.0;
        center = new Vector3D();
        ambient = new Vector3D();
        diffuse = new Vector3D();
        specular = new Vector3D();
        shininess = 0.0;
        reflective = false;
        transparent = false;
    }//Default Constructor
   
    
    public Sphere(double rad, Vector3D cen,Vector3D amb,Vector3D diff,Vector3D spec,double shi,boolean ref,boolean trans)
    {
        radius = rad;
        center = cen;
        ambient = amb;
        diffuse = diff;
        specular = spec;
        shininess = shi;
        reflective = ref;
        transparent = trans;
    }//Constructor
            
    
    public Sphere (Sphere otherSP)
    {
        if(this==otherSP)
        {
            return;
        }
        radius = otherSP.radius;
        center = otherSP.center;
        ambient = otherSP.ambient;
        diffuse = otherSP.diffuse;
        specular = otherSP.specular;
        shininess = otherSP.shininess;
        reflective = otherSP.reflective;
        transparent = otherSP.transparent;
    }//Copy Constructor
            
            
    //------------------------------------
    //               METHODS
    //------------------------------------
    
    
    public void equals(Sphere SP)
    {
        if(this == SP)
        {
            return;
        }
        
        center=SP.center;
        radius=SP.radius;
    }//equals
    
    public boolean collidesWith(Sphere otherSP)
    {
        return center.distance(otherSP.center) <=(radius + otherSP.radius);
    }//collidesWith
    
    
    public double getSurface()
    {
        return 4.0 * Math.PI * radius *radius;
    }//getSurface
            
    public double getVolume()
    {
        return 4.0/3.0 * Math.PI * radius *radius *radius;
    }//getVolume
    
    
    public boolean intersected(Ray ray , Vector3D point)
    {
       Vector3D OC = new  Vector3D(center.sub(ray.origin));
       double v = OC.dotProduct(ray.direction);
       double disc = (radius * radius) + v * v - OC.dotProduct(OC);
       double root; 
       
       if (disc < 0.0)
       {
           return false;
       }//if
       else 
       {
           root = Math.sqrt(disc);
           point = (ray.origin.add(ray.direction)).mul(v-root);
           // point = ray.origin + ray.direction * (v-root)
           //Vector3D a  = ((point.sub(center)).normalise());
           // point = center + (point - center).normalise() * radius
           point = center.add((point.sub(center)).normalise()).mul(radius);
           return true;
       }//else
    }//intersected
   
    
    
    public boolean intersected(Ray ray , Vector3D point,Vector3D normalSurface)
    {
       Vector3D OC = new  Vector3D(center.sub(ray.origin));
       double v = OC.dotProduct(ray.direction);
       double disc = (radius * radius) + v * v - OC.dotProduct(OC);
       double root; 
       
       if (disc < 0.0)
       {
           return false;
       }//if
       else 
       {
           root = Math.sqrt(disc);
           point = (ray.origin.add(ray.direction)).mul(v-root);
           // point = ray.origin + ray.direction * (v-root)
           
           normalSurface = (point.sub(center)).normalise();
           
           // point = center + normalSurface * radius;
           
           point = center.add(normalSurface).mul(radius);
           return true;
       }//else
    }//intersected
    
/* 
           
    @Override
    public String toString(){
        NumberFormat fmt = NumberFormat.getNumberInstance(); // Formats the number output
        return fmt.format(getDiameter());
    }//toString
*/
    
    
    
}//Sphere
