public class MyArrayList<E> extends MyAbstractList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    public MyArrayList() {

    }

    public MyArrayList(E[] objects) {
        for (E element : objects) {
            add(element);
        }

    }

    public void add(int index, E e) {

        EnsureCapacity();

        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    public void EnsureCapacity() {
        if (size == data.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(data, 0, data2, 0, size);
            data = newData;
        }
    }

    @Override
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        for (E element : data) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0 ; i < size ; i++) {
            if (e.equals(data[i])); {
                return true;
            }
        }
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size-1; i >= 0 ; i++) {
            if (e.equals(data[i])); {
                return i;
            }
        }
        return 0;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E e = data[index];
        for (int j = index; j < size-1 ; j++) {
            data[j] = data[j+1];
        }

        data[size-1] = null;
        size--;

        return e;
    }
}