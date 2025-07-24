class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
 int[] nextGreater = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
           while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextGreater[i] = 0;
            } else {
                nextGreater[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return nextGreater;
    }
}