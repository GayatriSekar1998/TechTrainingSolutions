
public class StackImplementation {

        public int maxSize;
        public int arr[];
        public int top;

        public StackImplementation(int size) {
            this.maxSize = 3;
            this.arr = new int[3];
            this.top = 1;
        }


    public void push(int data) {
        if(top == maxSize - 1) {
            System.out.print("Stack is full");
        } else {
            top++;
            arr[top] = data;
        }
    }

    public void pop() {
        if(top == -1) {
            System.out.print("Stack is empty");
        }
        else {
            System.out.println("Popped element: "+arr[top]);
            top--;
        }
    }

    public void main(String[] args) {
        StackImplementation stack = new StackImplementation(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.pop();
    }
}