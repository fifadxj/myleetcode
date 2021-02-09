//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5620 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal sum = convert(l1).add(convert(l2));
        System.out.println(sum);

        if (sum.compareTo(BigDecimal.ZERO) == 0) {
            return new ListNode(0);
        }

        Queue<Integer> queue = new LinkedList<>();

        while (sum.compareTo(BigDecimal.ZERO) > 0) {
            //System.out.println(sum + "" + "%10=" + (int) sum % 10);
            queue.add(sum.intValue() % 10);
            sum = sum.divide(BigDecimal.TEN);
        }

        ListNode head = new ListNode();
        ListNode prev = head;
        while (queue.size() > 0) {
            ListNode node = new ListNode(queue.poll());
            prev.next = node;
            prev = node;
        }

        return head.next;
    }

    BigDecimal convert(ListNode node) {
        Queue<Integer> queue = new LinkedList<>();
        ListNode current = node;

        while (current != null) {
            queue.add(current.val);
            current = current.next;
        }

        BigDecimal num = BigDecimal.ZERO;
        int i = 0;
        while (queue.size() > 0) {
            BigDecimal add = BigDecimal.valueOf(queue.poll()).multiply(BigDecimal.TEN.pow(i++));
            num = num.add(add);
        }

        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
