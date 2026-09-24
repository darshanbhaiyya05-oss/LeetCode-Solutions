class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (cycle(graph, i, vis, stack)) {
                    return false;   
                }
            }
        }
        return true;    
    }

    boolean cycle(List<List<Integer>> graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for (int next : graph.get(curr)) {
            if (stack[next]) {
                return true;
            }
            if (!vis[next]) {
                if (cycle(graph, next, vis, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }
}