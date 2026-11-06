class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] visited = new boolean[n];
        // List<List<Integer>> adjList = new ArrayList<>();
        Stack<Integer> dfs = new Stack<>();

        Map<Integer, List<Integer>> neighborMap = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            neighborMap.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
            neighborMap.computeIfAbsent(to, key -> new ArrayList<>()).add(from);

            // neighborMap.put(from, neighborMap.getOrDefault(from, new ArrayList()).add(to));
            // neighborMap.put(to, neighborMap.getOrDefault(to, new ArrayList()).add(from));
        }

   

        for (int i = 0; i < n ; i++) {
            if (visited[i]) {
                continue;
            }
            count++;
            dfs.push(i);
            while (!dfs.isEmpty()) {
                int node = dfs.pop();
                visited[node] = true;

                List<Integer> neighbors = neighborMap.get(node);
                if(neighbors == null) continue;
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        dfs.push(neighbor);
                    }
                }
            }
        }
        return count;
    }
}
