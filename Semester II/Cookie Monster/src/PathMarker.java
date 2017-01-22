
/* Use this class to represent the current "position" of a path.
 * Why do we only need row, col and total? */

public class PathMarker implements Comparable<PathMarker> {
    public int row;
    public int col;
    public int total;

    public PathMarker(int r, int c, int t) {
        row = r;
        col = c;
        total = t;
    }

    /* Comparable */
    public int compareTo(PathMarker other) //path1.compareTo(path2) > 1 then path1 has the most amount of cookies
    {
        return this.total - other.total; //defining smaller from total number of cookies 
        //switching total. and this. would switch negative sign. It would consider paths with most cookies first.
    }
}
