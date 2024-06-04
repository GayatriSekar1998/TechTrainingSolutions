public class LearnList {

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display(){
        Node currentNode = head;
        if(head == null){
            System.out.println("List is empty");
        }
        else {
            while(currentNode != null) {
                System.out.println(""+currentNode.data);
                currentNode = currentNode.next;
            }
        }
    }

    public void reverse() {
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode = null;
        while(currentNode != null) {
            //assign next node to next variable
            nextNode = currentNode.next;// who is next node
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode=nextNode;
        }
        head = previousNode;
    }

    public void displayReverse() {
        Node currentNode = head;
        System.out.println("Reverseing the node list:");
        while(currentNode != null) {
            System.out.println(""+currentNode.data);
            currentNode=currentNode.next;
        }
    }


    public static void main(String[] args) {
        LearnList l = new LearnList();
        l.insert(10);
        l.insert(20);

        l.display();

        l.reverse();
        l.displayReverse();
    }
}