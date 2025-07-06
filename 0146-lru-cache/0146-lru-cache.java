class LRUCache {
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> map; 
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(); 
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node data = map.get(key);
            remove(data);
            insertAfterHead(data);
            return data.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (capacity == map.size()) {
            remove(tail.prev);
        }
        insertAfterHead(new Node(key, value));
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev; 
    }

    public void insertAfterHead(Node node) {
        map.put(node.key, node);
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        nextNode.prev = node;
        node.next = nextNode;
    }
}
