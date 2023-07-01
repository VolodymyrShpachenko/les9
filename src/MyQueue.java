public class MyQueue <E>{

    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }
    public int size() {
        return this.size;
    }
    public E peek() {
        if (size == 0) {return null;}
        return this.first.item;
    }
    public E poll() {
        if (size == 0) {return null;}
        E result = first.item;
        if (size == 1) {
            clear();
            return result;
        }
        first = first.next;
        first.prev = null;
        size--;
        return result;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        StringBuilder result = new StringBuilder();
        result.append("{");
        Node<E> current = first;
        boolean bool = true;
        int count = 0;
        while (bool) {
            String s = String.valueOf(current.item);
            result.append(s);
            current = current.next;
            count++;
            if (count == size) {
                bool = false;
                result.append("}");
                continue;
            }
            result.append(", ");
        }
        return new String(result);
    }
}
