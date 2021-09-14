package pzl.study;

// 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例 1：
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
// 示例 2：
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
// 示例 3：
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
// 提示：
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 6751 👎 0
public class Demo0002 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Demo0002 demo = new Demo0002();
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(7, new ListNode(3));
//        ListNode node1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
//        ListNode node2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode node = demo.addTwoNumbers(node1, node2);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = l1;
        boolean flag = false;
        while (l1 != null) {
            if (flag) {
                if (l2 == null) {
                    l1.val++;
                } else {
                    l1.val = l1.val + l2.val + 1;
                }
            } else if (l2 != null){
                l1.val = l1.val + l2.val;
            }

            if (l1.val > 9) {
                l1.val %= 10;
                flag = true;
            } else {
                flag = false;
            }
            if (l1.next == null) {
                if (flag) {
                    l1.next = new ListNode(1);
                    flag = false;
                } else if (l2 != null){
                    l1.next = l2.next;
                    l2.next = null;
                }
            }
            l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return head;
    }
}
