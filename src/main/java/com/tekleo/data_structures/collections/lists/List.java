package com.tekleo.data_structures.collections.lists;

import com.tekleo.data_structures.collections.Collection;
import com.tekleo.data_structures.utils.Comparator;

/**
 * @author Leo Ertuna
 * @since 26.01.2018 17:25
 */
public interface List<Data> extends Collection<Data>, ListImmutable<Data> {
    // Adding
    //------------------------------------------------------------------------------------------------------------------
    Data add(int index, Data data);

    default Data addFirst(Data data) {
        return add(0, data);
    }

    default Data addLast(Data data) {
        return add(this.size(), data);
    }

    @Override
    default Data add(Data data) {
        return addLast(data);
    }
    //------------------------------------------------------------------------------------------------------------------



    // Removing
    //------------------------------------------------------------------------------------------------------------------
    Data remove(int index);

    default Data removeFirst() {
        return remove(0);
    }

    default Data removeLast() {
        return remove(this.size() - 1);
    }
    //------------------------------------------------------------------------------------------------------------------



    // Replacing
    //------------------------------------------------------------------------------------------------------------------
    Data replaceFirst(Data oldData, Data newData);

    Data replaceLast(Data oldData, Data newData);

    Data replaceAll(Data oldData, Data newData);

    Data replaceAtIndex(int index, Data newData);

    default Data replace(Data oldData, Data newData) {
        return replaceFirst(oldData, newData);
    }
    //------------------------------------------------------------------------------------------------------------------

    void sort(Comparator<Data> comparator);

    void reverse();

    void shuffle();




}