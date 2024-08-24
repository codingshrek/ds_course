package info.ds.list.linkedlist;

public class CheckPalindromeLL {

    public static boolean isPalindrome(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow.next);

        Node first = head;
        Node sec = newHead;

        while(sec!=null){

            if(first.data!=sec.data){
                reverse(newHead);
                return false;
            }
            first = first.next;
            sec = sec.next;
        }
        reverse(newHead);
        return true;

    }

    private static Node reverse(Node head){
        if(head.next==null) return head;
        Node newHead = reverse(head.next);
        Node next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }
}
