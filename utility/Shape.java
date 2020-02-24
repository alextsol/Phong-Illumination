package lightproject.utility;


public class Shape  
{
    
    public Vector3D ambient;
    public Vector3D diffuse;
    public Vector3D specular;
    public double shininess;
    public boolean reflective;
    public boolean transparent;

public Shape()
{
    ambient = new Vector3D();
    diffuse = new Vector3D();
    specular = new Vector3D();
    shininess = 0.0;
    reflective = false;
    transparent = false;
}//Default Constructor

public Shape(Vector3D amb,Vector3D diff,Vector3D spec,double shi,boolean ref,boolean trans)
{
 ambient = amb;
 diffuse = diff;
 specular = spec;
 shininess = shi;
 reflective = ref;
 transparent = trans;
 
}//Constructor


public Shape(Shape otherShape)
{
    if (this== otherShape)
    {
        return ;
    }
    ambient = otherShape.ambient;
    diffuse = otherShape.diffuse;
    specular = otherShape.specular;
    shininess = otherShape.shininess;
    reflective = otherShape.reflective;
    transparent = otherShape.transparent;
}//Copy Constructor;

//-------------------------------------------------
//                  METHODS
//-------------------------------------------------

public boolean isReflective(){return reflective;}
public boolean isTransparent(){return transparent;}
public boolean setReflective(){return true;}
public boolean setTransparent(){return true;}
public boolean clearReflectivity(){return false;}
public boolean clearTransparency(){return false;}

public boolean intersected (Ray ray)
{
    return false;
}
public boolean intersected (Ray ray,Vector3D point)
{
    return false;
}
public boolean intersected (Ray ray,Vector3D point, Vector3D normSurface)
{
    return false;
}


}
