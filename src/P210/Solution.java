class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        // if (numCourses == 0 || numCourses == 1) return true;
        
        for (int i = 0;i < prerequisites.length;i++) {
            indegree[prerequisites[i][0]]++;
        }
        
        for (int i = 0;i < numCourses;i++) {
            if (indegree[i] == 0) stack.push(i);
        }
        int count = 0;
        int[] res = new int[numCourses];
        
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            res[count++] = tmp;
            for (int i = 0;i < prerequisites.length;i++) {
                if (prerequisites[i][1] == tmp) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) stack.push(prerequisites[i][0]);
                }
            }
        }
        
        if (count != numCourses) return new int[0];
        
        return res;
    }
}