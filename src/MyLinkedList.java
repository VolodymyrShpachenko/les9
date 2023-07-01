import java.util.LinkedList;

public class MyLinkedList<E>{
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
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index > this.size - 1) {
            throw new IndexOutOfBoundsException("Слишком большой индекс");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Вы ввели отрицательный индекс");
        }
        Node<E> prev = null;
        Node<E> current = first;
        boolean bool = true;
        int count = 0;
        if (index == 0) {
            current.prev = null;
            first = current.next;
            bool = false;
        }
        while (bool) {
            prev = current;
            current = current.next;
            count++;
            if (count == index) {
                if (count == size-1) {
                    prev.next = null;
                    bool = false;
                    continue;
                }
                prev.next = current.next;
                current.next.prev = prev;
                bool = false;
            }
        }
        size--;
    }
    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }
    public int size() {
        return this.size;
    }
    public E get(int index) {
        if (index > this.size - 1) {
            throw new IndexOutOfBoundsException("Слишком большой индекс");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Вы ввели отрицательный индекс");
        }
        E result = null;
        Node<E> current = first;
        boolean bool = true;
        int count = 0;
        while (bool) {
            if (count == index) {
                bool = false;
                result = current.item;
            }
            count++;
            current = current.next;
        }
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
