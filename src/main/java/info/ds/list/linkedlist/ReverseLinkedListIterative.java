package info.ds.list.linkedlist;

public class ReverseLinkedListIterative {

    public static Node reverseLinkedList(Node head)
    {
        Node prev = null;
        Node cur = head ;
        Node next = cur.next;
        while(cur!=null){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next!=null) next = next.next;
        }

        return prev;
    }
}
