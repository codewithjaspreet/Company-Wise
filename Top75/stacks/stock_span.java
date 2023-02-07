package Top75.stacks;

import java.util.Stack;

// next greater to left with there index manipulation

public class stock_span {
    
        // Function to calculate the span of stockâ€™s price for all n days.
        public static int[] calculateSpan(int price[], int n) {

            int[] nsl = new int[n];
            Stack<Integer> st = new Stack<>();

            st.push(0);

            nsl[0] = 1;

            for (int i = 1; i < n; i++) {

                while (st.size() > 0 && price[st.peek()] <= price[i])
                    st.pop();

                if (st.size() == 0) {

                    nsl[i] = 1;

                } else {

                    nsl[i] = i - st.peek();
                }

                st.push(i);
            }

            return nsl;

        }

    
}
