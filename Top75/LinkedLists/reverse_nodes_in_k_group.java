package Top75.LinkedLists;

public class reverse_nodes_in_k_group {

    static  class Node{
        Node next;
        int data;
        
    }
        public static Node reverse(Node node, int k) {
            // Your code here

            // reversing first k nodes

            Node prev = null;
            Node temp = null;

            Node cur = node;
            int count = 0;

            while (cur != null && count < k) {

                temp = cur.next;
                cur.next = prev;

                prev = cur;
                cur = temp;
                count++;

            }

            // recursive call will handle further

            if (temp != null) {

                node.next = reverse(temp, k);
            }

            return prev;

        }
    }

