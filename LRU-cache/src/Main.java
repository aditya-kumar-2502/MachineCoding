public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        System.out.println(cache.get(2)); // Expected: 200 (makes key 2 most recently used)

        cache.put(4, 400); // Evicts key 1 (least recently used)
        System.out.println(cache.get(1)); // Expected: -1 (evicted)
        System.out.println(cache.get(2)); // Expected: 200
        System.out.println(cache.get(3)); // Expected: 300
        System.out.println(cache.get(4)); // Expected: 400

        cache.put(2, 250); // Update key 2's value
        System.out.println(cache.get(2)); // Expected: 250

        cache.get(3);      // Access key 3
        cache.put(5, 500); // Evicts key 4 (least recently used now)

        System.out.println(cache.get(4)); // Expected: -1 (evicted)
        System.out.println(cache.get(2)); // Expected: 250
        System.out.println(cache.get(3)); // Expected: 300
        System.out.println(cache.get(5)); // Expected: 500

        System.out.println(cache.get(999)); // Expected: -1 (non-existent key)
    }
}