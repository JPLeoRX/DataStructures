package com.tekleo.data_structures.collections.lists;

import com.tekleo.data_structures.collections.Collection;

/**
 * @author Leo Ertuna
 * @since 26.01.2018 17:25
 */
public interface List<Data> extends Collection<Data>, ListImmutable<Data> {
    // Adding
    //------------------------------------------------------------------------------------------------------------------
    Data addFirst(Data data);

    Data addLast(Data data);

    Data add(int index, Data data);

    @Override
    default Data add(Data data) {
        return addLast(data);
    }

    default Data set(int index, Data data) {
        return replaceAtIndex(index, data);
    }
    //------------------------------------------------------------------------------------------------------------------



    // Removing
    //------------------------------------------------------------------------------------------------------------------
    Data removeFirst();

    Data removeLast();

    @Override
    default Data remove(Data data) {
        return removeFirst();
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

    void sort();

    void reverse();

    void shuffle();




}