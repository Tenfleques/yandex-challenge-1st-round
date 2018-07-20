public class Main {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; ++i)
            linkedList.push(i);
        System.out.println(linkedList);
        linkedList.reverse();
        System.out.println(linkedList);
    }
}
