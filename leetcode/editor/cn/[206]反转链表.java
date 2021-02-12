//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1496 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {// [] -> []
            return null;
        } else if (head.next == null) {// [1] -> [1]
            return head;
        } else {// [1,x,y,z] -> [[x,y,z],1] 递归
            ListNode newHead = reverseList(head.next);
            head.next.next = head;//head.next就是reverseList(head.next)后的tail
            head.next = null;
            return newHead;
         }
    }
}*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
