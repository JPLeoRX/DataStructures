package com.tekleo.data_structures.collections.lists;

import com.tekleo.data_structures.utils.Comparator;

/**
 * More advanced list operations go here
 *
 * @author Leo Ertuna
 * @since 13.03.2018 00:13
 */
public interface ListAdvanced<Data> extends List<Data> {
    /**
     * Sort the elements in the list according to a given comparator
     * @param comparator rule for comparing elements of the list
     */
    void sort(Comparator<Data> comparator);

    /**
     * Reverse elements in the list
     */
    void reverse();

    /**
     * Shuffle elements in the list
     */
    void shuffle();
}