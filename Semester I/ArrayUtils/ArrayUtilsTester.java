import java.util.Arrays;

public class ArrayUtilsTester {
    
    public static void main(String [] args) {
        
        int[] a1 = { 0, 0, 1, 1, 2, 2, -2, -1 };
        int[] a2 = { };
        int[] a3 = { -100, 1, 100 };
        System.out.println("Odds: " + ArrayUtils.countOdds(a1));
        System.out.println("Odds: " + ArrayUtils.countOdds(a2));
        System.out.println("Odds: " + ArrayUtils.countOdds(a3));
        
        int[][] m1 = { { 1 } };
        int[][] m2 = { { 2, 3 }, { 4, 5 } };
        int[][] m3 = { { 2, 3, 7, 3 }, { 4, 5, 10, 12 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0} };
        int[][] m4 = { { 2, 3, 7, 3 }, { 4, 5, 10, 12 }, { 1, 1, 1, 1 } };
        System.out.println("Diag: " + ArrayUtils.onDiagonal(m1, 1)); // true
        System.out.println("Diag: " + ArrayUtils.onDiagonal(m1, 2)); // prints true, should be false
        System.out.println("Diag: " + ArrayUtils.onDiagonal(m2, 3)); // true
        System.out.println("Diag: " + ArrayUtils.onDiagonal(m2, 4)); // true
        System.out.println("Diag: " + ArrayUtils.onDiagonal(m2, 6)); //prints true, should be false
        System.out.println("Diag: " + ArrayUtils.onDiagonal(m3, 10));// true
        System.out.println("Diag: " + ArrayUtils.onDiagonal(m3, 12));// prints true, should be false
        System.out.println("Diag: " + ArrayUtils.onDiagonal(m3, 0)); // true
        System.out.println("Diag: " + ArrayUtils.onDiagonal(m4, 1)); // false
        
        int[] l1 = { 0, 0, 0, 0 };
        int[] i1 = { 1, 2, 3, 4 }; 
        ArrayUtils.addElements(l1, i1);
        
        int[] l2 = { 3, 4, 5, 6, 7 };
        int[] i2 = { -10, -10, -30 };
        ArrayUtils.addElements(l2, i2);
        
        int[] l3 = { 3, 4 };
        int[] i3 = { 5, 6, 7, 8 }; 
        ArrayUtils.addElements(l3, i3);
        
        System.out.println("addE: " + Arrays.toString(l1));
        System.out.println("addE: " + Arrays.toString(l2));
        System.out.println("addE: " + Arrays.toString(l3));
        
        /*
        int[] array1 = { 1, 0, 3, 9, 8, 2 };
        int[] array2 = { 9, 6, 5, 2, 3, 7 };
        int[][] emb = ArrayUtils.embiggen(array1, array2);
        System.out.println("embiggen: ");
        for (int[] a : emb) {
            System.out.println(Arrays.toString(a));
        }
        */
    }
    
}