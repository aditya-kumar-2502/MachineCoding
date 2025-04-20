public class Deque {
    Node head, tail;

    public void moveToFront(Node node){
        if(node == head) return;
        node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
        head.prev = node;
        node.next = head;
        head = node;
    }

    public void removeTail(){
        if(tail == null){
            System.out.println("Deque is empty");
            return;
        }
        if(tail.prev == null){
            head = null;
            tail = null;
        } else{
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    public void addNode(Node node){
        if(head == null){
            head = node;
            tail = node;
        } else{
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
}
