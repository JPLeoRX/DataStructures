package com.tekleo.data_structures;

import com.tekleo.data_structures.collections.CollectionImmutable;
import com.tekleo.data_structures.utils.Iterator;

public class MyCollection<E> implements CollectionImmutable<E> {
    private E e;

    public MyCollection(E e) {
        this.e = e;
    }

    @Override
    public E getRandom() {
        return e;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            if (index < size())
                return true;
            else
                return false;
        }

        @Override
        public E next() {
            index++;
            return e;
        }
    }
}
