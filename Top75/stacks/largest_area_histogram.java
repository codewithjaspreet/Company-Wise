package Top75.stacks;
import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int[] nsr = nextSmallerRight(heights);
        int[] nsl = nextSmallerleft(heights);
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nsr[i] - nsl[i] - 1);
            if (area > max)
                max = area;
        }

        return max;

    }

    public static int[] nextSmallerRight(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] nsr = new int[heights.length];
        st.push(heights.length - 1);
        nsr[heights.length - 1] = heights.length;

        for (int i = heights.length - 2; i >= 0; i--) {

            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsr[i] = heights.length;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        return nsr;
    }

    public static int[] nextSmallerleft(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] nsl = new int[heights.length];
        st.push(0);
        nsl[0] = -1;
        for (int i = 1; i < heights.length; i++) {

            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }

            st.push(i);
        }

        return nsl;
    }
}