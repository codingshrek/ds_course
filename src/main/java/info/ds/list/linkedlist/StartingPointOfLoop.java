package info.ds.list.linkedlist;

public class StartingPointOfLoop {

    public static Node firstNode(Node head) {

        Node slow  = head;
        Node tracker  = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next ;
            fast = fast.next.next;
            if(fast==slow){
                while(tracker!=fast){
                    tracker= tracker.next;
                    fast=fast.next;
                }
                return tracker;
            }
        }

        return null;

    }
}
