public class merge_k_sorted_LL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int si, int ei) {

        if (si > ei)
            return null;

        if (si == ei)
            return lists[si];

        int mid = (si + ei) / 2;

        ListNode left = mergeKLists(lists, si, mid);
        ListNode right = mergeKLists(lists, mid + 1, ei);

        return mergeTwoLists(left, right);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode c1 = l1;
        ListNode c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        prev.next = (c1 != null ? c1 : c2);

        return dummy.next;
    }

}
