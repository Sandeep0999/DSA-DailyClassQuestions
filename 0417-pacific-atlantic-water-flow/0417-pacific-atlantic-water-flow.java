
class Solution {
    int m, n;

    int dir[][] = {
        {-1,0}, {0,-1}, {0,1}, {1,0}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;

        boolean p[][] = new boolean[m][n];
        boolean a[][] = new boolean[m][n];

        for(int i = 0; i < m; i++){
            dfs(i, 0, heights, p);
        }

        for(int i = 0; i < n; i++){
            dfs(0, i, heights, p);
        }

        for(int i = 0; i < m; i++){
            dfs(i, n - 1, heights, a);
        }

        for(int i = 0; i < n; i++){
            dfs(m - 1, i, heights, a);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(p[i][j] && a[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, int h[][], boolean vis[][]){

        vis[r][c] = true;

        for(int d[] : dir){

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc])
                continue;

            if(h[nr][nc] < h[r][c])
                continue;

            dfs(nr, nc, h, vis);
        }
    }
}
