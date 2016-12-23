public class ArrayUtils {

    /* countOdds
     * This method should return the number of odd integers in the array.
     * Odd integers are not divisible by 2.
     * 0 is an even integer.
     */
    public static int countOdds(int[] nums) {
      int row = nums.length;
      int numOfOdds = 0;

      for (int x = 0; x < row; x++)
      {
        if(nums[x]%2 == 1 || nums[x]%2 == -1)
          numOfOdds++;
      }
      return numOfOdds;
    }

    /* onDiagonal
     * This method takes a 2D array of integers, and a single integer parameter.
     * It returns true if and only if the value of the parameter lies on a diagonal of the
     * 2D array.
     *
     * Diagonals are illustrated here (X is on diagonal, . is not):
     *
     * X.X  X..X  X...X X....X
     * .X.  .XX.  .X.X. .X..X.
     * X.X  .XX.  ..X.. ..XX..
     *      X..X  .X.X. .X..X.
     *            X...X X....X
     *
     * 2D arrays that are not square do not have diagonals, and should always return false.
     */
    public static boolean onDiagonal(int[][] matrix, int test) {
        int r = matrix.length;
        int c = matrix[0].length;
        //check if 2D array is even a diagonal
        if (r == c)
        {
          return (test == traverseMatrix(matrix,test));
        }
        return false;
    }

    public static int traverseMatrix(int[][] matrix, int test)
    {
      int r1 = 0;
      int c1 = 0;

      while(true){
        try{
          if(matrix[r1][c1] == test)
            return matrix[r1][c1];
          r1++; c1++;
        }
        catch(IndexOutOfBoundsException e)
        {
          break;
        }
      }

      r1 = matrix.length;
      c1 = matrix[0].length;

      while(true){
        try{
          if(matrix[r1][c1] == test)
            return matrix[r1][c1];
          r1--;
          c1--;
        }
        catch(IndexOutOfBoundsException e)
        {
          break;
        }
      }
      return test++;
    }
    /* addElements
     * This method takes two 1D integer arrays: list and increment.
     * The list array is mutated such that the ith element of list will be incremented by the ith
     * element of increment.
     *
     * e.g.             list -> (0, 0, 1, 1,  2,  2)
     *             increment -> (4, 5, 6, 7,  8,  9)
     * after returning, list -> (4, 5, 7, 8, 10, 11)
     *
     * If increment is not as long as list, treat unspecified values as 0.
     *
     * e.g.             list -> (0, 0, 1, 1, 2, 2)
     *             increment -> (4, 5, 6, 7)
     * after returning, list -> (4, 5, 7, 8, 2, 2)
     *
     * If increment has more elements than list, ignore the extra elements.
     */
    public static void addElements(int[] list, int[] increment) {
        int index = increment.length;
        while(list.length < index)
          index--;
        for (int x = 0; x < index; x++) // uses < because converts from length to index
        {
          list[x] += increment[x];
        }
    }

    /* embiggen
     * Merges two 1D integer arrays into a single 2D integer array.
     * The [i][j] element of the resulting array is whichever value is larger: array1[i] or array2[j].
     * { 1, 0, 3, 9, 8, 2 }
     * { 9, 6, 5, 2, 3, 7 }
     */
/*
    public static int[][] embiggen(int[] array1, int[] array2) {
      private int[][] newArray = new int[1][array2.size]
      for(int x = 0; x <= array1.size; x++)
      {
          newArray[0][x] = array1[x];
      }
      for (int y = 0; y<= )

      //for second for statement use lenght of newArray
    }
    */
}
