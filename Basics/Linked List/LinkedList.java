public class LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        // step 1- Create a new node
        Node newNode = new Node(data);
        size++;

        // for empty linked list
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2- new node next=head
        newNode.next = head;

        // step 3- head = newnode
        head = newNode;
    }

    public void addLast(int data){
        // step 1- Create a new node
        Node newNode = new Node(data);
        size++;

        // for empty linked list
        if(head == null){
            head = tail = newNode;
            return;
        }
        
        // step 2- tail next= newnode
        tail.next = newNode;
        
        // step 3- tail = newnode
        tail = newNode;
    }

    public void add(int idx,int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        // i = idx-1; temp-> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("ll is empty");
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
        size--;
        return val;
    }

    public int removeLast(){

        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        
        int val = prev.next.data;    // tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrativeSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int helper(Node head,int key){
        if (head == null) {
            return -1;
        }
        else if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    public int recursiveSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;    // tail = head
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthfromEnd(int n){
        // calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next; // remove first
            return;
        }

        int iToFind = sz-n;
        Node prev = head;
        int i = 1;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // step 1 - Find mid
        Node mid = findMid(head);

        // step 2 - reverse 2nd half
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = prev;
        }
        Node right = prev;
        Node left = head;

        // step 3 - check left half and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static boolean isCycle(){    // floyd's Cycle Finding Algorithm
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next;  // +2
            if(slow == fast){
                return true;    // Cycle exist
            }
        }
        return false;   // Cycle does not exist;
    }

    public static void removeCycle(){
        // Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }

        if(cycle == false){
            return;
        }

        // Find meeting point
        slow = head;
        Node prev = null;   // For tracking previous node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Lastnode.next = null
        prev.next = null;
    }

    public static Node getMidNNode(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;    // Mid node
    }

    public Node Merge(Node head1, Node head2){
        Node mergedll = new Node(-1);
        Node temp = mergedll;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        
        return mergedll.next;
    }

    public Node MergeSort(Node head){
        // Base Condition
        if(head == null || head.next == null){
            return head;
        }
        // Find mid
        Node mid = getMidNNode(head);

        // left and right half
        Node Righthead = mid.next;
        mid.next = null;

        Node newLeft = MergeSort(head);
        Node newRight = MergeSort(Righthead);

        // Merge Two ll
        return Merge(newLeft,newRight);
    }

    // Zig-Zag LL
    public void zigZagLL(){
        // Find Mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // Reverse 2nd Half and seprate halfs from mid
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Alternate Merging - Zig-Zag
        Node leftHead = head;
        Node rightHead = prev;
        Node nextL,nextR;

        while(leftHead != null && rightHead != null){
            // Zig-Zag
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;

            // Update
            leftHead = nextL;
            rightHead = nextR;
        }
    }

    public static void main(String[] args) {
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next= temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());


        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.print();
        ll.zigZagLL();
        ll.print();

        // ll.head = ll.MergeSort(ll.head);    // TC - O(nlogn)
        // ll.print();
    }
}