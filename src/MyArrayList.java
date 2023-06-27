import java.util.Arrays;

public class MyArrayList <E> {
    private Object [] array;
    public MyArrayList() {
        this.array = new Object[8];
    }
    public MyArrayList(int capacity) {
        this.array = new Object[capacity];
    }
    public void add(E e) {
        if (size() == array.length) {
            int newLength = array.length + (array.length / 2);
            array = Arrays.copyOf(array, newLength);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {continue;}
            else array[i] = e;
            return;
        }
    }
    public void remove(int index) throws IndexOutOfBoundsException {
        if(index > size()-1) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size()-1; i++) {
            array[i] = array[i+1];
        }
        array[size()-1] = null;
    }
    public void clear() {
        array = new Object[8];
    }
    public int size() {
        int size = 0;
        for (Object o: array) {
            if (o != null) {size++;}

        }
        return size;
    }
    public E get(int index) throws IndexOutOfBoundsException{
        if(index > size()-1) {
            throw new IndexOutOfBoundsException();
        }
        return (E)array[index];
    }
    public int capacity(){
        return array.length;
    }

    @Override
    public String toString() {
        return "MyArrayList " + Arrays.toString(array)+"; size - " + size() + "; capacity - " + capacity()+ ";";
    }
}
