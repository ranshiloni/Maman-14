
public class StudentTester {

    public static void main(String[] args) {
        
        // checknumPaths();
        
        // checkIsSumOf();
        
        checkIsSink();
        
        Find();

    }

    // private static void checknumPaths() {
        // int[][] mat4 = {
                // {1, 2, 3},
                // {4, 5, 6},
                // {7, 8, 9}};
        
        // int x1 = 0,  y1 = 0, x2 = 1, y2 = 0;

        // if(0 != Ex14.numPaths(mat4, x1, y1, x2, y2))
            // System.out.println("checknumPaths() is failed");
        
    // }

    // private static void checkIsSumOf() {
        // if(Ex14.isSumOf(new int[] {4,5}, 11) || !Ex14.isSumOf(new int[] {4,5}, 13))
            // System.out.println("checkIsSumOf() is failed");
        
    // }
    
    private static void Find() {
        int i;
        int[][] mat = {
                {1, 2},
                {3, 4}};
                
        int [][] mat1 = {
            {-4, -2, 5, 9},
            {2,5,12,13},
            {13,24,24,25},
            {22,24,49,49}};
        
        if(Ex14.find(mat, 3))  
            System.out.println(1 +" found");
            else 
            System.out.println(1 + "not found");
            
            for (i = -4; i<58; i++) 
        {
        if(Ex14.find(mat1, i))  
            System.out.println(i +" found");
            else 
            System.out.println(i + "not found");
        } 
        
    }

    private static void checkIsSink() {
        int[][] mat1 = { //sink=1
                {0,0},
                {1,0}};
        
        int[][] mat2 = { //sink=2
                {0, 1, 1},
                {0, 0, 0},
                {0, 0, 0}};

        if(Ex14.isSink(mat1) != 0 || Ex14.isSink(mat2) != -1)
        
            System.out.println("isSink() is failed");
        else
            System.out.println("isSink() is a great success");
            
        
        int[][] mat3 = { //sink=2
                {0, 1, 1},
                {0, 0, 1},
                {0, 1, 0}};
                
        if(Ex14.isSink(mat3) != -1)
        
            System.out.println("isSink3() is failed");
        else
            System.out.println("isSink3() is a great success");
            
        int[][] mat4 = { //sink=2
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};
                
        if(Ex14.isSink(mat4) != 2)
        
            System.out.println("isSink4() is failed");
        else
            System.out.println("isSink4() is a great success");
                    
        int[][] mat5 = { //sink=2
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0}};
                
        if(Ex14.isSink(mat5) != 1)
        
            System.out.println("isSink4() is failed");
        else
            System.out.println("isSink4() is a great success");
                
                
        
    }

}
