public class LearnDoublyLinkedList {
    class Node{
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head,tail = null;
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            head.previous = null;
            tail.next = null;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void display() {
        Node curr = head;

        if(head == null) {
            System.out.println("Empty List");
            return;
        }
        while(curr != null) {
            System.out.println(""+curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        LearnDoublyLinkedList l = new LearnDoublyLinkedList();

        l.insert(10);
        l.insert(20);

        l.display();
    }
}