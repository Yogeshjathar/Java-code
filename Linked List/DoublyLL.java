public class DoublyLL {

    public class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        // step 1 - create newNode
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        // step 2 - add at first position in existing ll and update next and prev
        newNode.next = head;
        head.prev = newNode;
        // step 3 - update head
        head = newNode;
    }

    public void addLast(int data){
        // step 1 - create newNode
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        // step 2 - add at last position in existing ll and update next and prev
        tail.next = newNode;
        newNode.prev = tail;
        // step 3 - update tail
        tail = newNode;
    }

    public int removeFirst(){
        if(head == null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast(){
        if(head == null){
            System.out.println("dll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String args[]){
        DoublyLL dll = new DoublyLL();
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);

        dll.print();
        dll.reverse();
        dll.print();
    }
}