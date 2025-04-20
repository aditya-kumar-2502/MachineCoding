import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Deque dq;
    Map<Integer, Node> nodes = new HashMap<>();
    int size, capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.dq = new Deque();
    }

    public int get(int key) {
        if(!nodes.containsKey(key)){
            return -1;
        }
        Node node = nodes.get(key);
        dq.moveToFront(node);
        return node.getValue();
    }

    public void put(int key, int value) {
        if(nodes.containsKey(key)){
            Node node = nodes.get(key);
            node.setValue(value);
            dq.moveToFront(node);
        } else{
            if(size == capacity){
                nodes.remove(dq.tail.getKey());
                dq.removeTail();
                size--;
            }
            Node node = new Node(key, value);
            dq.addNode(node);
            nodes.put(key, node);
            size++;
        }
    }
}
