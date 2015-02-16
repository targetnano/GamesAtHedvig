package games.core;

class LongestIncreasingSequenceInMatrix {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    private static boolean[][] visited;
    
    public static void main(String[] args) 
    {
        int[][] matrix = { {1,-1}, {3,-2} };
        System.out.println(longestIncSequence(matrix));
    }

    private static int longestIncSequence(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0) 
            return 0;
        
        visited = new boolean[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++) 
        {
            for(int j = 0; j < matrix[0].length; j++) 
            {
                int length = getLength(i,j,matrix);
                max = Math.max(max, length);
            }
        }
        return max;
    }
    
    private static int getLength(int i, int j, int[][] matrix) 
    {
            visited[i][j] = true;
            int max = 1;
            for(int r = 0; r < 4; r++) 
            {
                int nextX = i+dx[r];
                int nextY = j+dy[r];
                if(isValid(nextX, nextY, matrix) && !visited[nextX][nextY] && matrix[nextX][nextY] > matrix[i][j]) 
                {
                    int length = getLength(nextX, nextY, matrix);
                    max = Math.max(max, length+1);
                }
            }
            visited[i][j] = false;
        return max;
    }
    
    private static boolean isValid(int x, int y, int[][] matrix) 
    {
        if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length)
            return true;
        return false;
    }
}