public class Queue_Impl_Array {
    static class Queue{
        static int size;
        static int arr[];
        static int rear;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static void add(int data){
            // Check if array is full 
            if(rear == size-1){
                System.out.println("Queue is full");
                return;
            }

            // add data 
            rear = rear + 1;
            arr[rear] = data;
        }

        public static int remove(){
            // Check if queue is empty
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            // Remove data that is front from queue
            int front = arr[0];
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            // Update rear value 
            rear = rear - 1;
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[0];
        }
    }
    public static void main(String[] args){
        Queue q = new Queue(3);
        q.add(1);
        q.add(2); 
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

        // Time Complexity
        // add - O(1)
        /*remove - O(n) so to reduce this to O(1) we will use circular queue 
                        and update condition according to it (for front and rear) */
        // peek - O(1)
    }
}