/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector3d;

/**
 *
 * @author yefer
 */
public class Vector3D {

    private float x;
    private float y;
    private float z;
    
    public Vector3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void print() {
        System.out.println("[" + x + ", " + y + ", " + z + "]");
    }
    
    public static Vector3D add(Vector3D a, Vector3D b) {
        Vector3D ans = new Vector3D(a.x + b.x, a.y + b.y, a.z + b.z);
        return ans;
    }
    
    public static Vector3D sub(Vector3D a, Vector3D b) {
        Vector3D ans = new Vector3D(a.x - b.x, a.y - b.y, a.z - b.z);
        return ans;
    }
    
    public static Vector3D mult(Vector3D a, float k) {
        Vector3D ans = new Vector3D(a.x * k, a.y * k, a.z * k);
        return ans;
    }
    
    public static Vector3D div(Vector3D a, float k) {
        Vector3D ans = new Vector3D(a.x / k, a.y / k, a.z / k);
        return ans;
    }
    
    public float mag() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }
    
    public void setMag(float k) {
        Vector3D temp = mult(normalize(this), k);
        x = temp.x;
        y = temp.y;
        z = temp.z;
    }
    
    public static Vector3D normalize(Vector3D v) {
        return div(v, v.mag());
    }
    
    public static float dist(Vector3D a, Vector3D b) {
        Vector3D ans = sub(a, b);
        return ans.mag();
    }
    
    public static float angleBetween(Vector3D a, Vector3D b) {
        float ans = (float) Math.acos(dot(a, b) / (a.mag() * b.mag()));
        return (float) (180.0 / Math.PI * ans);
    }
    
    public static float dot(Vector3D a, Vector3D b) {
        return (a.x * b.x + a.y * b.y + a.z * b.z);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vector3D a = new Vector3D(3, 4, 0), b = new Vector3D(1, -1, 2);
        a.print();
        System.out.println("Mag " + a.mag());
        a.setMag(10);
        a.print();
        System.out.println("Mag " + Math.round(a.mag()));
        Vector3D m = new Vector3D(100, 0, 0), n = new Vector3D(0, 100, 0);
        System.out.println("Angle between m & n " + angleBetween(m, n));
    }
    
}
