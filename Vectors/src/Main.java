import BaseVector.BaseVector;
import BaseVector.Vector;
import VectorImpls.Vector3dImpl;

public class Main {

    public static void main(String[] args) {
        BaseVector vector3d = new Vector3dImpl(new int[]{1, 2, 3});
        BaseVector addition = vector3d.add(new Vector3dImpl(new int[]{1, 2, 3}));
        Vector subtraction = vector3d.subtract(new Vector3dImpl(new int[]{1, 2, 3}));
        Vector multiplication = vector3d.multiplyByScalar(5);
        System.out.println(vector3d.toString());
        System.out.println(addition.toString());
        System.out.println(subtraction.toString());
        System.out.println(multiplication.toString());
        System.out.println(vector3d.equalsByComponent(vector3d));
        System.out.println(vector3d.equalsByComponent(new Vector3dImpl(new int[]{1, 2, 3})));
        System.out.println(vector3d.equalsByComponent(addition));
        // write your code here
    }
}
