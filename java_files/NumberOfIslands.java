import java.util.*;
public class NumberOfIslands {
   static int m,n;
   static char[][] matrix;
   static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row");
        m =scanner.nextInt();
        System.out.println("Enter column");
         n=scanner.nextInt();
         scanner.nextLine();
        matrix = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
        }
        System.out.println(islands());
        scanner.close();
    }
        static int islands(){
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1' && !visited[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    static void dfs(int i, int j){
        if(i<0 || i>=m||j<0||j>=n||matrix[i][j] !='1' ||visited[i][j]){
            return;
        }
        visited[i][j] =true;
        dfs(i+1,j); //dowm
        dfs(i-1,j); //up
        dfs(i,j+1); //right
        dfs(i,j-1); //left
    }
    
}
