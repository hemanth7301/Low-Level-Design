public class HashMap<K, V> {
    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    Entry[] hashTable;

    HashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    HashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

    }

    class Entry<K, V> {
        K key;
        V value;
        Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

    public void put(K key, V value) {
        int index = key.hashCode() % hashTable.length;
        Entry node = hashTable[index];
        Entry newNode = new Entry(key, value);
        if (node == null) {
            hashTable[index] = newNode;
        } else {
            Entry previousNode = node;
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                }
                previousNode = node;
                node = node.next;
            }
            previousNode.next = newNode;
        }
    }

    public V get(K key) {
        int index = key.hashCode() % hashTable.length;
        Entry node = hashTable[index];
        while (node != null) {
            if (node.key == key) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(7);
        map.put(1, "Hemanth");
        map.put(2, "is");
        map.put(3, "a");
        map.put(4, "good");
        map.put(5, "boy");
        map.put(6, "Thats");
        map.put(7, "a");
        map.put(8, "fact");
        map.put(9, "!!!!!");
        map.put(10, "hehe");

        String value = map.get(1);
        System.out.println(value);

    }
}