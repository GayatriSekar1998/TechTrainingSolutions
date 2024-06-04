public class QueueImplementation {

    int maxSize;
    int front;
    int rear;
    int numOfItems;
    int arr[];

    public QueueImplementation(int size) {
        maxSize = size;
        arr = new int[size];
        front = 0;
        rear = -1;
        numOfItems = 0;
    }

    public boolean checkFull() {
       return numOfItems == maxSize;
    }

    public boolean checkEmpty() {
        return numOfItems == 0;
    }

    public void enqueue(int data) {
        if(checkFull()){
            System.out.print("Queue is full");
        }
        else {
            rear++;
            arr[rear] = data;
            numOfItems++;
        }
    }

    public void dequeue() {
        if (checkEmpty()) {
            System.out.print("Queue is empty");
        }
        else {
            System.out.print("Queue element is : "+arr[front]);
            front++;
            numOfItems--;
        }
    }
    public static void main(String[] args) {
        QueueImplementation queue = new QueueImplementation(3);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
    }
}