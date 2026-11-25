class Solution {
    class Pair{
        int node, price;
        public Pair(int node, int price){
            this.node = node;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int it[] : flights){
            graph.get(it[0]).add(new Pair(it[1],it[2]));
        }
        int cost[] = new int[n];
        int INF = (int)1e9;
        Arrays.fill(cost, INF);
        cost[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int city = arr[0], stops = arr[1], costSoFar = arr[2];
            if(stops > k) continue;
            for(Pair p : graph.get(city)){
                int nextCity = p.node;
                int price = p.price;
                if(costSoFar + price < cost[nextCity]){
                    cost[nextCity] = costSoFar + price;
                    q.offer(new int[]{nextCity, stops + 1, cost[nextCity]});
                }
            }
        }
        return cost[dst] != INF ? cost[dst] : -1;
    }
}