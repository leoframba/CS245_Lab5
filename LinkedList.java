public class LinkedList{
    //Definition of singly linked list
    private class Node{
        int val;
        Node next;
        Node() {}
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    //you can either make it static or non-static
    //here the node is static so it can be called directly in the main to test code
    Node head;
    private int size;

    /**
     * Default constructor that instantiate the head of your linked list
     */
    public LinkedList(){
    }

    /**
     * Add node of type int at the end of the list (5%)
     * @param val int to be added
     */
    public void add(int val) {
        if(head == null){
            head = new Node(val);
        }else{
            Node prev = head;
            for(int i = 0; i < size - 1; i++){
                prev = prev.next;
            }
            prev.next = new Node(val);
        }
        size++;
    }

    /**
     * Add node of type int at the given index (5%)
     * @param val int to be added
     * @param position where index to be added
     */
    public void add(int val, int position) {
        if(position == 0){
            Node node = new Node(val);
            node.next = head;
            head = node;
        }else if (position <= size && position > 0){
            Node prev = head;
            for(int i = 1; i < position; i++){
                prev = prev.next;
            }
            Node node = new Node(val);
            node.next = prev.next;
            prev.next = node;
        }else throw new IndexOutOfBoundsException();
        size++;

    }

    public void add(int[] arr){
        for (int j : arr) {
            add(j);
        }
    }

    /**
     * Remove and return the node of type int (10%)
     * @param position index to be deleted
     * @return removed linked list
     */
    public Node remove(int position) {
        if(position == 0){
            Node temp = head;
            head = head.next;
            size--;
            return head;
        }else if (position < size && position > 0){
            Node prev = head;
            for (int i = 1; i < position; i++) {
                prev = prev.next;
            }
            Node node = prev.next;
            prev.next = node.next;
            size--;
            return head;
        }else throw new IndexOutOfBoundsException();
    }

    /**
     * Reverse and return the new head (15%)
     * @param head list to be reversed
     * @return new linked list
     */
    public Node reverse(Node head) {
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
        return prev;
    }

    public void clearList(){
        head = null;
        size = 0;
    }

    public boolean isPalindrome(){ return isPalindrome(this.head); }

    /**
     * Function you need to implement (20% of the grade)
     * @param head from singly linked list
     * @return true if the linked list is palindrome
     */
    public boolean isPalindrome(Node head){
        int[] arr = new int[size];
        Node node = head;
        for (int i = 0; i < size; i++) {
            arr[i] = node.val;
            node = node.next;
        }
        node = reverse(this.head);
        for(int i = 0; i < size; i++){
            if(arr[i] != node.val) return false;
            node = node.next;
        }
        reverse(this.head);
        return true;
    }

    /**
     * convert the binary numbers of a linked list from base 2 to base 10 decimals
     * @param head head node of the list
     * @return decimals in base 10
     */
    public int getDecimalValue(Node head) {
       int result = 0;
       Node node = head;
        for (int i = size - 1; i >= 0; i--) {
            result += Math.pow(2, i) * node.val;
            node = node.next;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node node = head;
        while (node != null) {
            result.append(node.val).append("->");
            node = node.next;
        }
        result.append("NULL");
        return result.toString();
    }

    public static void main(String[] args) {
        //Modify the main as needed
        LinkedList myList = new LinkedList();
        myList.add(1);
        myList.add(3);
        myList.add(2);
        myList.add(1);
        System.out.print("Add list:  ");
        System.out.println(myList);

        System.out.print("Add 2 at index 1:  ");
        myList.add(2,1);
        System.out.println(myList);

        System.out.print("Remove element at index 4:  ");
        myList.remove(4);
        System.out.println(myList);

        System.out.print("Reverse list:  ");
        myList.reverse(myList.head);
        System.out.println(myList);

        myList.remove(3);
        System.out.println(myList);
        System.out.println(myList.isPalindrome());
        myList.add(3);
        System.out.println(myList);
        System.out.println(myList.isPalindrome());

        myList.clearList();
        myList.add(new int[]{1, 0 , 0, 1, 0, 0 , 1, 1 , 1, 0 ,0 , 0, 0 , 0, 0});
        System.out.println(myList.getDecimalValue(myList.head));
    }
}