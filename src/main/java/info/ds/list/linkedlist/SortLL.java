package info.ds.list.linkedlist;

public class SortLL {

    public static Node sortList(Node head) {
        return mergeSort(head);
    }

    private static Node merge(Node h1,Node h2){

        Node dummy = new Node(-1);
        Node dummyHead = dummy;

        while(h1!=null && h2!=null){
            if(h1.data>h2.data){
                dummy.next = h2;
                h2 = h2.next;
            }
            else{
                dummy.next=h1;
                h1=h1.next;
            }
            dummy= dummy.next;
        }

        if(h1!=null){
            dummy.next = h1;
        }
        if(h2!=null){
            dummy.next=h2;
        }

        return dummyHead.next;
    }

    private static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    private static Node mergeSort(Node head){
        if(head ==null || head.next==null) return head;

        Node mid = findMid(head);
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        leftHead = mergeSort(leftHead);
        rightHead =  mergeSort(rightHead);
        return merge(leftHead,rightHead);
    }
}
