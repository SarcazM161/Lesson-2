package Lessons;
import java.util.Iterator;
import java.util.List;

public class iterator <Type> implements Iterator<Type>, Iterable<Type> {

    private List<Type> arrayList;
    private int currentSize;

    public iterator(List<Type> newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.size()-1;
    }

    @Override
    public Iterator<Type> iterator() {
        return this;
    }


            @Override
            public boolean hasNext() {
                return currentSize >= 0;
            }

            @Override
            public Type next() {
                return arrayList.get(currentSize--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }


