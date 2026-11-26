
class Solution {

    class DSU {
        int[] par, size;

        DSU(int n) {
            par = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (par[x] == x) return x;
            return par[x] = find(par[x]);
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return false;

            if (size[pu] < size[pv]) {
                par[pu] = pv;
                size[pv] += size[pu];
            } else {
                par[pv] = pu;
                size[pu] += size[pv];
            }

            return true;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;

        int[] parent = new int[n + 1];

        int[] edge1 = null;
        int[] edge2 = null;

        // Step 1: Check if any node has two parents
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                edge1 = new int[]{parent[v], v};
                edge2 = new int[]{u, v};

                break;
            }
        }

        // Step 2: Detect cycle using DSU
        DSU ds = new DSU(n);

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // Skip the second edge if two parents exist
            if (edge2 != null &&
                edge[0] == edge2[0] &&
                edge[1] == edge2[1]) {
                continue;
            }

            if (!ds.union(u, v)) {

                // If two parents exist, remove the first edge
                if (edge1 != null) return edge1;

                // Otherwise remove the edge causing cycle
                return edge;
            }
        }

        // No cycle after skipping second edge
        return edge2;
    }
}
