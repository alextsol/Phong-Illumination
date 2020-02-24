package lightproject.utility;

/**
 *
 * @author Θάνος
 */
public class FrameBuffer {
    static int minresX=32;
    static int minresY=32;
    static int maxresX=8192;
    static int maxresY=8192;
    
    Vector3D Array[];
    int dimX,dimY;
    
    Vector3D empty = new Vector3D();
    public FrameBuffer(int resX,int resY){
       dimX = clamp(resX, minresX, maxresX);
       dimY = clamp(resY, minresY, maxresY);
       Array = new Vector3D[dimX*dimY];
       setBuffer(empty);
    }//Constructor

    public FrameBuffer(int resX, int resY, Vector3D initialColor){
       dimX = clamp(resX, minresX, maxresX);
       dimY = clamp(resY, minresY, maxresY);
       Array = new Vector3D[dimX*dimY];
       setBuffer(initialColor);
    }//Constructor
    
    public void setPixel(int x, int y, Vector3D color){
        assert(( x >= minresX) && (x <= maxresX));
        assert(( y >= minresY) && (y <= maxresY));
        Array[y * dimX + x] = color;
    }//setPixel
    
    public void add(int x, int y, Vector3D color){
        assert(( x >= minresX) && (x <= maxresX));
        assert(( y >= minresY) && (y <= maxresY));
        Array[y * dimX + x].inc(color);
    }//add
    
    public double aspectRatio(){
        return (double)dimX/(double)dimY;
    }//aspectRatio
    
    public int capacity(){
        return (int)empty.length() *dimX * dimY;
    }//capacity
    
    public int resolution(){
        return dimX*dimY;
    }//reolution
    
    Vector3D[] getData(){
        return Array;
    }//getData
    
    public void flipVertically(){
        int x,yMin=0;
        int yMax=dimY-1;
        while(yMin<yMax){
            for(x=0;x<dimX;x++){
                swap(Array[yMin*dimX+x],Array[yMax*dimX+x]);
            }//for
        yMin++;
        yMax--;
        }//while
    }//flip
    
    public void swap(Vector3D Array1,Vector3D Array2){
        Vector3D tmp;
        tmp = Array1;
        Array1 = Array2;
        Array2 = tmp;
    }//swap
    
    public void clampPixels(){
        Vector3D lo = new Vector3D();
        Vector3D hi = new Vector3D();
        int x,y;
        
        for(y=0;y<dimY;y++){
            for(x=0;x<dimX;x++){
                Array[y*dimX+x].clampSelf(lo,hi);
            }//x - for
        }//y - for
    }//clampPixels
    
    
    public void setBuffer(Vector3D color){
        for(int i=0;i<(dimX*dimY);i++){
            Array[i]= color;
        }
    }
        
     public int clamp(int a, int min, int max){
        if(a<min){
            a=min;
        }else if(a>max){
            a=max;
        }
        return a;
    }//clamp - 'a' could be x, y or z
}
