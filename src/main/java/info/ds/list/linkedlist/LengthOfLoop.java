package info.ds.list.linkedlist;

public class LengthOfLoop {
    public static int lengthOfLoop(Node head) {

        Node slow = head ;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                int count = 0;
                do{
                    fast = fast.next;
                    count++;
                }
                while(fast!=slow);
                return count;
            }
        }

        return 0;


    }
}
