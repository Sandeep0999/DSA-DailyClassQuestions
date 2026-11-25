class Solution {
    class Pair{
        int node, time;
        public Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=1; i<=n; i++) adj.add(new ArrayList<>());
        for(int t[] : times){
            adj.get(t[0]-1).add(new Pair(t[1]-1,t[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time - b.time);
        int dist[] = new int[n+1];
        int INF = (int)1e9;
        Arrays.fill(dist, INF);
        dist[k-1] = 0;
        pq.offer(new Pair(k-1, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node, time = p.time;
            for(Pair it : adj.get(node)){
                int nextNode = it.node, wt = it.time;
                if(time + wt < dist[nextNode]){
                    dist[nextNode] = time + wt;
                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}