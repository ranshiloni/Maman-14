
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
        int middle, quarter;
        middle = (mat.length-1)/2;
        if(mat[middle][mat.length-1] > x) //finding which quarter would the number might be
        {
            if (mat[middle][middle] >= x)
                quarter=1;
            else
            {
                quarter=2;
            }
        }
        else // the number might be found on the bottom horizontal half
        {
            if (mat[mat.length-1][middle] >= x)
                quarter=3;
            else
            {
                quarter=4;
            }
        }
        if (middle==0){ //if it's a 2X2 square, optimize the 2nd quarter.
            if (mat[0][1] == x) 
                return true;
        }
        return checkQuarter(mat,x,middle,quarter); //the highRow would be the index location where surrounding the number could be found

    }

    private static boolean checkQuarter (int[][] mat, int x, int middle, int quarter)
    {
        int highRow, lowRow, highClm, lowClm;
        //initialise coordinates to focus on in the matrix instead of creating a new one
        switch (quarter)
        {
            case 1: highRow = middle;
            highClm = middle;
            lowRow = 0;
            lowClm = 0;
            break;
            case 2: highRow = middle;
            highClm = mat.length-1;
            lowRow = 0;
            lowClm = middle;
            break;
            case 3: highRow = mat.length-1;
            highClm = middle;
            lowRow = middle+1;
            lowClm = 0;
            break;
            case 4: highRow = mat.length-1;
            highClm = mat.length-1;
            lowRow = middle+1;
            lowClm = middle+1;
            break;        
            default: return false;
        }

        //find the potential row
        int potentialRow = -1;
        int i;

        for (i=lowRow; i<=highRow; i++) //find which row is the potential one
        {
            if ((mat[i][lowClm]<=x)&&(mat[i][highClm]>=x))
            {
                potentialRow = i;
                break;
            }
        }
        if (potentialRow > -1)
        {//found the row it is most likely to be in
            for (i=lowClm; i<=highClm; i++) //itterate on the potenrial row in the quarter
            {
                if (mat[potentialRow][i] == x) 
                    return true;
            }
        }
        return false;
    }
}
