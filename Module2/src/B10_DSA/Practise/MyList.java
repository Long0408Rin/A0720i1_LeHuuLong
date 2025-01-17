package B10_DSA.Practise;

import java.util.Arrays;

public class MyList <E>{
    private int size;
    private static final int  DEFAULT_CAPACITY = 10;
    private Object element [];

    public MyList(){
        element = new Object[DEFAULT_CAPACITY];
    }

    // assembly method ensureCape
    // double size of array
    private void ensureCapa(){
        int newSize = element.length*2;
        element = Arrays.copyOf(element,newSize);
    }

    // setup method add
    // add element to end of list
    public void add(E e){
        if(size == element.length){
            ensureCapa();
        }
        element[size++] = e;
    }

    // setup method get
    // method get return value of index i in list
    public E get(int i){
        if (i >=size || i < 0){
            throw new IndexOutOfBoundsException("Index: "+ i +
                    ", Size "+ i);
        }
        return (E) element[i];
    }
}
