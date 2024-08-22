package info.ds.list.linkedlist;

public class ReverseLinkedListRecursive {
    public static Node reverseLinkedList(Node cur)

    {
        if(cur.next == null ) return cur;
        Node newHead = reverseLinkedList(cur.next);
        Node front  = cur.next;
        front.next = cur;
        cur.next = null;
        return newHead;
    }

}
