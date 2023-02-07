package Top75.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class copy_list_with_random_pointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
        public Node copyRandomList(Node head) {
            Map<Node, Node> nodes = new HashMap<>();
            Node newHead = null;
            Node temp = head;
            Node newTemp = null;
            while (temp != null) {
                if (newHead == null) {
                    newHead = new Node(temp.val);
                    newTemp = newHead;
                } else {
                    Node newNode = new Node(temp.val);
                    newTemp.next = newNode;
                    newTemp = newTemp.next;
                }
                nodes.put(temp, newTemp);
                temp = temp.next;
            }
            temp = head;
            newTemp = newHead;
            while (temp != null) {
                if (temp.random == null) {
                    newTemp.random = null;
                } else {
                    newTemp.random = nodes.get(temp.random);
                }
                temp = temp.next;
                newTemp = newTemp.next;
            }
            return newHead;
        }
    
}
