
/**
 * Maman 14, Openu 2017
 *
 * @author Ran Shiloni
 * @version 301892212
 */
public class Ex14
{
    /**
     * Return the location of k[][] if there's a sink (row of 0s and a column of 1s except the row), otherwise returns -1
     * Efficiency O(n) 
     * @param int[][] mat square matrix
     * @return int the location of the sink, or -1 if there isn't one
     */

    public static int isSink (int [][] mat)
    {
        int i,j,k = -1;
        for (i=0; i<mat.length; i++)
        {
            if (mat[i][i] == 0) //if the row has the potential to be a sink, [k][k] == 0
            {
                for (j=0; j<mat.length; j++)
                {
                    if(mat [i][j] == 1 && !(i==j))
                    {
                        if (i<j) // to prevent infinite loops 
                            i=j-1; // **for efficiency** - skipping potential k's that can not be qualified because we found 0s in the columns on other rows
                        break;
                    }
                }

                if (j==mat.length)// a row of zeros has been found, and only one is permitted to have a sink
                {
                    k=i;
                    break;
                }
            }
        }
        if (k>=0) //if a row has been found
        {
            for (j=0; j<mat.length; j++) 
            {
                if (!(k==j) && mat[j][k] == 0) //if the column is all 1s except the sink
                {
                    break;
                }
            }
            if (j==mat.length) //a column of 1s found except the k point, therefore a sink
                return k;
        }
        //no sink found
        return -1;
    }

    /**
     * 
     */
    public static boolean find(int[][] mat, int x)
    {
        int highRow, highClm, lowRow, lowClm, middle;

        highRow = mat.length -1;
        highClm = mat.length -1;
        lowRow = 0;
        lowClm = 0;

        while ((highRow!=lowRow)&&(lowClm!=highClm))
        {
            middle = (lowRow+highClm)/2; 
            if(mat[middle][highClm] > x)  // the number might be on top horizontal half of the square 
            {
                highRow = middle;
                if (mat[middle][middle] > x)
                //number might be on the 1st quarter
                    highClm = middle; //!! doesnt work with 4X4
                else
                {
                    //the number might be on the 2nd quarter
                    lowRow = middle+1;
                    lowClm = middle+1;
                }
            }
            else // the number might be found on the bottom horizontal half
            {
                lowRow = middle+1;
                if (mat[middle][highRow] > x)
                //the number might be on the 3rd quarter
                    highClm = middle;
                else
                {
                    lowClm = middle+1;
                }
            }
        }
        return checkSquare(mat,x,highRow); //the highRow would be the index location where surrounding the number could be found
    }
    /**
     * Returns true if a number x if found a square surrounding an index
     * @param x number to be found
     * @param index index of the square
     */
    private static boolean checkSquare (int[][] mat, int x, int index){
        if((mat[index][index]==x)||(mat[index-1][index]==x)||(mat[index][index-1]==x)||(mat[index-1][index-1]==x))
        return true;
        else 
        return false;
    }
}
