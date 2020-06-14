import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Chapter2 {
    //2.1
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
        @Override
        public String toString(){
            return String.valueOf(val);
        }
    }
    //1 2 3 3 3 4 4 5
    //the book simply removes the duplicate after its first appearance, while I'm removing all duplicates
    public static ListNode removeDups(ListNode head){
        Map<Integer, Integer> hs = new HashMap<>();
        ListNode dummy = new ListNode(0); dummy.next = head;
        ListNode curr = head;

        while(curr != null){
            hs.compute(curr.val, (key, val) -> (val == null) ? 1 : val+1);
            curr = curr.next;
        }
        System.out.println(hs);
        curr = head;    ListNode prev = dummy;
        while(curr != null){
            if(hs.get(curr.val) > 1){
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy;
    }

    //See lc 19
    public static ListNode lastKth(ListNode head, int n){
        ListNode dummy = new ListNode();    dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;   ListNode fast = curr;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = curr.next;
        return dummy.next;
    }

    public static ListNode delete(ListNode head){
        
    }
    //lc 86
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode big = new ListNode(0);
        ListNode bigHead = big;
        
        while(head != null){
            if(head.val < x){
                small.next = new ListNode(head.val);
                small = small.next;
            }else{
                big.next = new ListNode(head.val);
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }

    public static void printList(ListNode node){
        while(node!= null){
            System.out.print(node + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[]args){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);  head.next = second;
        ListNode third = new ListNode(2);   second.next = third;
        ListNode fourth = new ListNode(3);  third.next = fourth;
        ListNode fifth = new ListNode(3);   fourth.next = fifth;
        ListNode sixth = new ListNode(4);   fifth.next = sixth; 
        ListNode seventh = new ListNode(4); sixth.next = seventh; seventh.next = null;
        printList(head);
        removeDups(head);
        printList(head);
    }
}