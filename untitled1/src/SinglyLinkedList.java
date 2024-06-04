public class SinglyLinkedList {
    class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head=null;
    Node tail=null;
    public void insert(int data){
       Node node =new Node(data);
       if(head==null) {
           head = node;
           tail = node;
       }
       else {
           tail.next = node;
           tail = node;
       }
    }

    public void display(){
        Node current = head;
        if(head == null) {
            System.out.print("Empty list");
            return;
        }
        while(current!=null){
            System.out.println(""+current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insert(100);
        sl.insert(200);

        //display the elements in list
        sl.display();
    }

}