package info.ds.misc;

public class Test {
    public static void main(String[] args) {

       char a = 2;
       char b = 3;

        System.out.println(a>b);


    }
}

class Node {
    public int data;
    public Node next;

    Node()
    {
        this.data = 0;
        this.next = null;
    }
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}