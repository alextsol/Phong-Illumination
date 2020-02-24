package lightproject.utility;

/**
 *
 *
 */
public class Vector3D {
    
    public double x,y,z;
    
    public Vector3D(){
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }//Default Constructor
    
    
    public Vector3D(double x,double y,double z){
       this.x=x; 
       this.y=y;
       this.z=z;
    }//Constructor

    public Vector3D(Vector3D vector){
        x = vector.x;
        y = vector.y;
        z = vector.y;
    }
    
    
    
    
    //-----------------------------Functions-----------------------------------
    
    
    
    public double  length(){
        return (Math.sqrt(x*x + y*y + z*z));
    }//length
    
    public double lengthSquared(){
        return (x*x + y*y + z*z);
    }//lengthSquared
    
    public double distance(Vector3D b){
        double tmp =((b.x-x)*(b.x-x)+ ((b.y-y)*(b.y-y)) + ((b.z-z)*(b.z-z)));
        return Math.sqrt(tmp);
    }//distance
    
    public double distanceSquared(Vector3D b){
        return ((b.x-x)*(b.x-x)+ ((b.y-y)*(b.y-y)) + ((b.z-z)*(b.z-z)));
    }//distanceSquared
    
    public Vector3D normalise(){
        double len = length();
        if ( len > 1.0e-7 )
        {
            len = 1.0 / len;
            return new Vector3D(x*len,y*len,z*len);
        }else{
            return new Vector3D();
        }
    }//normalise
    
    public Vector3D normaliseSquared(){
        x /=(x*x+y*y+z*z);
        y /=(x*x+y*y+z*z);
        z /=(x*x+y*y+z*z);
        
        Vector3D result = new Vector3D(x,y,z);
        return result;
    }//normaliseSquad
    
    public double dotProduct(Vector3D other){
         return (x*other.x + y*other.y* + z*other.z);
    }//dotProduct
    
    public void crossProduct(Vector3D other){
      x = (y*other.z - z*other.y) ;
      y = (z*other.x - x*other.z) ;
      z = (x*other.y - y*other.x) ;
    }//crossProduct
    
    public boolean equals(Vector3D other){
       return (x == other.x) && (y == other.y ) && (z == other.z);
    }//equals
    
    public boolean notEquals(Vector3D other){
       return (x != other.x) && (y != other.y ) && (z != other.z);
   }//unEquals
     
    
    public boolean min(Vector3D other){
        return this.length() < other.length();
    }//if "this" is smaller than "other"/
     
    public boolean max(Vector3D other){
        return this.length() > other.length();
    }//megalutero apo ta 2 vector
    

    public double angle(Vector3D other){
//        double k1 = (Math.sqrt(x*x+y*y+z*z)) + (Math.sqrt(x*x+y*y+z*z)) + (Math.sqrt(x*x+y*y+z*z));
//        double k2 = (Math.sqrt(other.x*other.x+other.y*other.y+other.z*other.z)) + (Math.sqrt(other.x*other.x+other.y*other.y+other.z*other.z)) + (Math.sqrt(other.x*other.x+other.y*other.y+other.z*other.z));
//        
//        double arithmitis = 1/(Math.cos((this.mul(other))));
//        double paronomastis = this.length()*other.length();
        
        //double theta= ((this.mul(other)) /(this.length()*other.length()));
        //double result = 1/(Math.cos((this.mul(other)) /(this.length()*other.length())));
        //return (1/((Math.acos((this.mul(other)) / (k1*k2) )));
        return (1/(Math.cos((this.mul(other)) /(this.length()*other.length()))));
    }//na briskei thn gwnia anamesa apo ta 2 vector 
    
    public void clampSelf(Vector3D Lo, Vector3D Hi){
        if(this.x<Lo.x){
            this.x=Lo.x;
        }else if(x>Hi.x){
            this.x=Hi.x;
        }//clamp for x
        
        if(this.y<Lo.y){
            this.y=Lo.y;
        }else if(this.y>Hi.y){
            this.y=Hi.y;
        }//clamp for x
        
        if(this.z<Lo.z){
            this.z=Lo.z;
        }else if(this.z>Hi.z){
            this.z=Hi.z;
        }//clamp for x
    }//clamp - 'a' could be x, y or z
    
    
    
//-----------------------------Operators----------------------------------------
    
    
    
    public Vector3D add(Vector3D other){
        Vector3D result = new Vector3D(x+other.x,y+other.y,z+other.z);
        return result;
    }//+
    
    
    public Vector3D add(double other)
    {
         Vector3D result = new Vector3D(x+other,y+other,z+other);
         return result;
    }//kanei to idio me tn add alla pairnei san orisma double
       
    
    public void inc(Vector3D other){
        x += other.x;
        y += other.y;
        z += other.z;
    }//Increase
     

    public Vector3D sub(Vector3D other){
        
        Vector3D result = new Vector3D(x-other.x, y-other.y, z-other.z);
        return result;
    }//Subtract 


     public Vector3D sub(double other){
        
        Vector3D result = new Vector3D(x-other, y-other, z-other);
        return result;
     }//kanei to idio me tn sub alla pairnei san orisma double
 
    public void dec(Vector3D other){
        x -= other.x;
        y -= other.y;
        z -= other.z;
    }//Decrease -=
    


    
    public Vector3D mul(double other)
    {
        Vector3D result = new Vector3D(x*other, y*other , z*other);
        return result;
    }
    
    public double mul(Vector3D other)
    {
        return (x*other.x+y*other.y+z*other.z);
    }//Multiply
    
   
    //alla3a auto gia na mporoume na broume to getPoint sto Ray
    public Vector3D vectorMul(Vector3D other)
    {
        double newX = x*other.x;
        double newY = y*other.y;
        double newZ = z*other.z;
        
        Vector3D result = new Vector3D(newX,newY,newZ);
        return result;
    }//vectorMul
     
    public void mulEq(Vector3D other){
        x *= other.x;
        y *= other.y;
        z *= other.z;
    }
    
    public Vector3D div(double num){
        if(num == 0.0 )
        {
            return null;
        }
        Vector3D result = new Vector3D(x / num, y / num, z / num);
        return result;
    }//Divide
    
    
    public void divEq(double num)
    {
        x /= num;
        y /= num;
        z /= num;
    }//divideEqual
   
}//Vector3D
