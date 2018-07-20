public class LinkedList {
    private static class Node{
        int id;
        Node next;
        Node prev;         Node(int n){
            id = n;
        }
    }
    private Node head = null;
    public void push(Node n){
        n.next = head;
        head = n;
    }
    public void push(int n){
        Node node = new Node(n);
        node.next = head;
        if(node.next != null)
            node.next.prev = node;
        head = node;
    }
    public void reverse(){
        LinkedList reversedList = new LinkedList();
        while (head != null){
               reversedList.push(this.pop());
        }
        head = reversedList.head;
    }
    public Node pop(){
        Node retNode = head;
        if(head != null)
            head = head.next;
        return retNode;
    }

    @Override
    public String toString(){
        StringBuilder ss = new StringBuilder();
        Node ptr = head;
        int i = 0;
        ss.append("[");
        while(ptr != null){
            if(i > 0)
                ss.append(", ");
            ss.append(ptr.id);
            ptr = ptr.next;
            i++;
        }
        ss.append("]");
        return ss.toString();
    }
}
