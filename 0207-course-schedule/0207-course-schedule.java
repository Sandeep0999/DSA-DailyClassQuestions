class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        int inDegree[] = new int[n];  
        for(int it[] : prerequisites){
            int u = it[0], v = it[1];
            adj.get(v).add(u);
            inDegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0) q.add(i);
        }
        int complete = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            complete++;
            for(int next : adj.get(node)){
                inDegree[next]--;
                if(inDegree[next] == 0) q.offer(next);
            }
        }
        return complete == n;
    }
       
    //     List<List<Integer>> graph = new ArrayList<>();
    //     for(int i = 0; i < numCourses; i++){
    //         graph.add(new ArrayList<>());
    //     }
    //     for(int[] pre : prerequisites){
    //         graph.get(pre[1]).add(pre[0]);  
    //     }
    //     int[] visited = new int[numCourses]; //0 - unvisited  1- currently visiting 2 - completely proccesed
        
    //     for(int i = 0; i < numCourses; i++){
    //         if(!dfs(i, graph, visited)){
    //             return false; 
    //         }
    //     }
    //     return true; 
    // }
    
    // private boolean dfs(int course, List<List<Integer>> graph, int[] visited){
    //     if(visited[course] == 1) {
    //         return false; 
    //     }
    //     if(visited[course] == 2) {
    //         return true; 
    //     }
    //     visited[course] = 1; 
        
    //     for(int next : graph.get(course)){
    //         if(!dfs(next, graph, visited)){
    //             return false;
    //         }
    //     }
    //     visited[course] = 2; 
    //     return true;
    // }
}