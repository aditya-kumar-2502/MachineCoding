public class Node {
    private int key;
    private int value;
    Node prev;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString(){
        return "Key: " + key + ", Value: " + value;
    }
}
