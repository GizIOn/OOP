package BaseVector;

import VectorImpls.Vector3dImpl;
import VectorImpls.Vector5dImpl;
import VectorImpls.VectorNdImpl;

import java.util.Arrays;

import static BaseVector.Operation.ADD;
import static BaseVector.Operation.SUBTRACT;

public abstract class BaseVector implements Vector {
    private final int[] mi_componentsArray;
    private final int mi_componentsArrayLength;

    public BaseVector(int dimensions, int[] components) {
        mi_componentsArray = new int[dimensions];
        mi_componentsArrayLength = dimensions;

        if (dimensions != components.length) throw new IllegalArgumentException();

        System.arraycopy(components, 0, mi_componentsArray, 0, dimensions);
    }

    @Override
    public BaseVector add(BaseVector another) {
        return processOperation(another, ADD);
    }

    @Override
    public BaseVector subtract(BaseVector another) {
        return processOperation(another, SUBTRACT);
    }

    @Override
    public BaseVector multiplyByScalar(int scalar) {
        int[] componentsArray = new int[mi_componentsArrayLength];
        for (int i = 0; i < mi_componentsArrayLength; i++) {
            componentsArray[i] = mi_componentsArray[i] * scalar;
        }

        return new VectorNdImpl(mi_componentsArrayLength, componentsArray);
    }

    @Override
    public boolean equalsByComponent(BaseVector another) {
        if (this == another) return true;

        if (mi_componentsArrayLength != another.mi_componentsArrayLength) return false;

        for (int i = 0; i < mi_componentsArrayLength; i++) {
            if (mi_componentsArray[i] != another.mi_componentsArray[i]) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "BaseVector.Vector: " + Arrays.toString(mi_componentsArray);
    }

    /**
     * Method for evaluating expressions with vectors
     *
     * @param another   vector which will be the second operand
     * @param operation what to do with vectors
     * @return resulting vector
     */
    private BaseVector processOperation(BaseVector another, Operation operation) {
        if (mi_componentsArrayLength != another.mi_componentsArrayLength) throw new IllegalArgumentException();

        int[] componentsArray = new int[another.mi_componentsArrayLength];
        switch (operation) {
            case ADD:
                for (int i = 0; i < another.mi_componentsArrayLength; i++) {
                    componentsArray[i] = mi_componentsArray[i] + another.mi_componentsArray[i];
                }
                break;
            case SUBTRACT:
                for (int i = 0; i < another.mi_componentsArrayLength; i++) {

                    componentsArray[i] = mi_componentsArray[i] - another.mi_componentsArray[i];
                }
                break;
        }

        if (mi_componentsArrayLength == 3) return new Vector3dImpl(componentsArray);
        if (mi_componentsArrayLength == 5) return new Vector5dImpl(componentsArray);
        return new VectorNdImpl(mi_componentsArrayLength, componentsArray);
    }
}
