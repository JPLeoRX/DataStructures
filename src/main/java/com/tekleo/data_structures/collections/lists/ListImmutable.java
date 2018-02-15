package com.tekleo.data_structures.collections.lists;

import com.tekleo.data_structures.collections.CollectionImmutable;

/**
 * List with immutable contents
 *
 * Once created we cannot add new elements to it, or remove old elements from it
 *
 * @author Leo Ertuna
 * @since 27.01.2018 02:12
 */
public interface ListImmutable<Data> extends CollectionImmutable<Data> {
    // Getting
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get the first element of this list
     * @return first element of this list
     */
    public abstract Data getFirst();

    /**
     * Get the last element of this list
     * @return last element of this list
     */
    public abstract Data getLast();

    /**
     * Get element at a given index
     * @param index index
     * @return element at a given index,
     * @throws IllegalArgumentException is the index is out of bounds
     */
    public abstract Data get(int index);
    //------------------------------------------------------------------------------------------------------------------



    // Finding
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Find indexes of all occurrences of a given object
     * @param data object to find
     * @return array of indexes of all its occurrences
     */
    default int[] findAllIndexes(Data data) {
        // Create new array to store indexes
        int[] indexes = new int[this.size()];

        // For each element in this collection
        for (int i = 0, j = 0; i < this.size(); i++)
            // If the element is found
            if (this.get(i).equals(data))
                // Store its index
                indexes[j++] = i;

        return indexes;
    }

    /**
     * Find the index of first occurrence of a given object
     * @param data object to find
     * @return index of first occurrence of given object, or -1
     * @see #findAllIndexes(Object)
     */
    default int findFirstIndex(Data data) {
        int[] indexes = findAllIndexes(data);
        return indexes.length > 0 ? indexes[0] : -1;
    }

    /**
     * Find the index of last occurrence of a given object
     * @param data object to find
     * @return index of last occurrence of given object, or -1
     * @see #findAllIndexes(Object)
     */
    default int findLastIndex(Data data) {
        int[] indexes = findAllIndexes(data);
        return indexes.length > 0 ? indexes[indexes.length - 1] : -1;
    }
    //------------------------------------------------------------------------------------------------------------------
}