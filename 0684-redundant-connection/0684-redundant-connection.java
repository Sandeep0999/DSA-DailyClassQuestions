class Solution {
    class DisjointSet{
        int par[], size[];
        public DisjointSet(int n){
            par = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++){
                par[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x){
            if(par[x] == x) return x;
            par[x] = find(par[x]);
            return par[x];
        }
        public void unionBySize(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return;
            if(size[pu] < size[pv]){
                par[pu] = pv;
                size[pv] += size[pu];
            }
            else{
                par[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n+1);
        int ans[] = new int[2];
        for(int it[] : edges){
            int u = it[0], v = it[1];
            if(ds.find(u) == ds.find(v)){
                ans[0] = u;
                ans[1] = v;
            }
            else ds.unionBySize(u, v);
        }
        return ans;
    }
}