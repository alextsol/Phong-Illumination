package lightproject;

import lightproject.utility.Sphere;
import java.text.DecimalFormat;
import java.util.Scanner;
import lightproject.utility.Vector3D;

/**
 *
 * 
 */
public class LightProject {

    public static void main(String[] args) {
//            Vector3D v1 = new Vector3D(4,-3,5);
//            Vector3D v2 = new Vector3D(9,7,-10);
//
//            Vector3D vAdd;
//            vAdd = v1.add(v2);
//
//            Vector3D vNorm;
//            vNorm = v1.normalise();
//            Vector3D vSub = v1.sub(v2);
//
//            Vector3D vNormSq;
//
//            System.out.println("3 Dimensional Vector Operations for V1(and between V1-V2)");
//            System.out.println("Length: "+v1.length());
//            System.out.println("Length Squared: "+v1.lengthSquared());
//            System.out.println("Distance between V1 and V2: "+v1.distance(v2));
//            System.out.println("Squared Distance between V1 and V2: "+v1.distanceSquared(v2));
//            System.out.println("Normalized: "+v1.normalise());
//            System.out.println("Normalized squared: "+v1.normaliseSquared());
//            System.out.println("Minimum between V1 and V2: "+v1.min(v2));
//            //...
//
//            System.out.println("The angle is : "+v1.angle(v2));
//
//            System.out.println("Equals: "+v1.equals(v2));
//            System.out.println("The result of the addition is: ("+vAdd.x+", "+vAdd.y+", "+vAdd.z+")");
        
//System.out.println("The result of the subtraction is: ("+vAdd.x+", "+vAdd.y+", "+vAdd.z+")");
            

              //----------------------- Implementation of Sphere--------------------
              
              double r = 0.0;
              
              DecimalFormat fmt = new DecimalFormat();
              Scanner scan = new Scanner(System.in);
              System.out.println("Enter the diameter of the sphere: ");
              r = scan.nextDouble();
              
            //  Sphere sphere = new Sphere(r);
              
             // System.out.println(fmt.format(sphere.getVolume()));
          //    System.out.println(fmt.format(sphere.getSurface()));
    }
    
}
