// Rotten Oranges
// Send Feedback
// You are given a 2D array of integers of size N * M. Each of the cell contains either of these 3 integers: 0, 1, 2. The integer 2 denotes a rotten orange, 1 denotes a fresh orange and 0 denotes an empty cell.
// Each rotten orange can rot fresh oranges in 4 adjacent cells in 1 unit of time. The 4 cells are left, right, top and bottom cell.
// For a given matrix, find the minimum units of time in which all oranges become rot. Return -1, if it is not possible.
// Input Format:
// The first line of input contains 2 space separated integers, N and M, that denotes size of given 2D array.
// The following N lines contains M space separated integers, that denotes the value of cells of given 2D array.
// Constraints:
// Value of N and M lies in the range: [1, 10000].
// Value of each cell in 2D array can be either 0, 1 or 2.
// Output Format:
// Print the required integer, as described in the problem description.   
// Sample Input 1:
// 3 5
// 2 1 0 2 1
// 1 0 1 2 1
// 1 0 0 2 1
// Sample Output 1:
// 2
// Explanation:
//  In the first unit of time, fresh oranges at coordinates: (0, 1), (0, 4), (1, 0), (1, 2), (1, 4), (2, 4).
//  In the second unit of time, fresh orange at coordinate: (2, 0) gets rot. Hence, in 2 units of time, all the fresh oranges become rot.
// Sample Input 2:
// 3 5
// 2 1 0 2 1
// 1 0 1 0 1
// 1 0 0 0 2
// Sample Output 2:
// -1
// Explanation:
// It is impossible to rot the fresh orange at (1, 2)

/*import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here

	

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
    
   public static int orangesRotting(int[][] mat) {
        Queue<int[]> rotten = new LinkedList<>();
        int[][] fourDir = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int i=0; i< mat.length*mat[0].length; i++) {
            int r = i/mat[0].length;
            int c = i%mat[0].length;
            if(mat[r][c]==2) {
                int[] current = new int[]{r,c};
                rotten.add(current);
            }
        }
        int l = 0;
        while(!rotten.isEmpty()) {
            int size = rotten.size();
            l++;
            while(size > 0) {
                int[] val = rotten.poll();
                for(int i=0; i< fourDir.length; i++) {
                    int r = val[0]+fourDir[i][0];
                    int c = val[1]+fourDir[i][1];
                    if(r<0 || c<0 || r == mat.length || c== mat[0].length || mat[r][c] != 1) continue;
                    mat[r][c] = 3;
                    rotten.add(new int[]{r,c});
                }
                size--;
            }
        }
        
        for(int i=0; i< mat.length*mat[0].length; i++) {
            int r = i/mat[0].length;
            int c = i%mat[0].length;
            if(mat[r][c]==1) return -1;
        }
        
        return (l>0) ? l-1 : 0;
    }
	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        
        int[][] mat = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = s.nextInt();
            }
        }
        
        System.out.println(orangesRotting(mat));

	}

}