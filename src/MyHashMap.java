public class MyHashMap <K, V>{
    private int size = 0;
    private Node<K, V> first;
    private Node<K, V> last;
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public void put(K key, V value) {
        Node <K, V> current = first;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        final Node<K, V> l = last;
        final Node<K, V> newNode = new Node<>(key, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    public void remove(K key) {
        Node <K, V> current = first;
        Node <K, V> prev = null;
        while (current!= null) {
            if (current.key.equals(key)) {
                if (size() == 1) {
                    clear();
                    return;
                }
                if (current.equals(last)) {
                    prev.next = null;
                } else if (current.equals(first)) {
                    first = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }
    public int size() {
        return this.size;
    }
    public V get(K key) {
        if (size() == 0) {return null;}
        Node <K, V> current = first;
        while (current!= null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }


    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        StringBuilder result = new StringBuilder();
        result.append("{");
        Node<K, V> current = first;
        boolean bool = true;
        int count = 0;
        while (bool) {
            String k = String.valueOf(current.key);
            String v = String.valueOf(current.value);
            result.append(k).append(" - ").append(v);
            current = current.next;
            count++;
            if (count == size) {
                bool = false;
                result.append("}");
                continue;
            }
            result.append(";\n");
        }
        return new String(result);
    }
}
