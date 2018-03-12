package com.tekleo.data_structures.collections.lists;

import com.tekleo.data_structures.collections.Collection;

/**
 * List
 *
 * @author Leo Ertuna
 * @since 26.01.2018 17:25
 */
public interface List<Data> extends Collection<Data>, ListImmutable<Data> {
    // Adding
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Add an element to the list, placing it at a given index
     * @param index index at which newly added element should be placed in the list
     * @param data added element
     * @return added element
     */
    Data add(int index, Data data);

    /**
     * Add an element to the list, placing it in the beginning of the list
     * @param data added element
     * @return added element
     * @see #add(int, Object)
     */
    default Data addFirst(Data data) {
        return add(0, data);
    }

    /**
     * Add an element to the list, placing it in the end of the list
     * @param data added element
     * @return added element
     * @see #add(int, Object)
     */
    default Data addLast(Data data) {
        return add(this.size(), data);
    }

    /**
     * This method exists just for the sake of naming conventions
     * It just redirects to another method
     * @param data added element
     * @return added element
     * @see #addLast(Object)
     */
    @Override
    default Data add(Data data) {
        return addLast(data);
    }
    //------------------------------------------------------------------------------------------------------------------



    // Removing
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Remove the element at a given index from this list
     * Try to make it run in O(1) or O(n)
     * @param index index
     * @return removed element
     */
    Data remove(int index);

    /**
     * Remove the first element from this list
     * Runs in O(n) or O(1) depending on the implementation of {@link #remove(int)}
     * @return removed element
     * @see #remove(int)
     */
    default Data removeFirst() {
        return remove(0);
    }

    /**
     * Remove the last element from this list
     * Runs in O(n) or O(1) depending on the implementation of {@link #remove(int)}
     * @return removed element
     * @see #remove(int)
     */
    default Data removeLast() {
        return remove(this.size() - 1);
    }

    /**
     * Remove all occurrences of a given object from this collection
     * Runs in O(n * n)
     * @param data object to be removed
     * @return removed object
     * @see #findAllIndexes(Object)
     * @see #remove(int)
     */
    @Override
    default Data removeAll(Data data) {
        // Find all indexes of data
        int[] indexes = this.findAllIndexes(data);

        // For each index
        for (int index : indexes)
            // Remove old data with new data
            this.remove(index);

        // Return data
        return data;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Replacing
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Replace the data at a given index with new value
     * Try to make in run in O(n) or better
     * @param index index
     * @param newData new value
     * @return new value
     */
    Data replaceAtIndex(int index, Data newData);

    /**
     * Replace the first found occurrence of an object with new value
     * Runs in O(n), but technically it is 3 * O(n)
     * @param oldData old value
     * @param newData new value
     * @return new value
     * @see #findFirstIndex(Object)
     * @see #replaceAtIndex(int, Object)
     */
    default Data replaceFirst(Data oldData, Data newData) {
        // Find firs index
        int firstIndex = this.findFirstIndex(oldData);

        // Replace old data with new data at first index
        this.replaceAtIndex(firstIndex, newData);

        // Return new data
        return newData;
    }

    /**
     * Replace the last found occurrence of an object with new value
     * Runs in O(n), but technically it is 3 * O(n)
     * @param oldData old value
     * @param newData new value
     * @return new value
     * @see #findLastIndex(Object)
     * @see #replaceAtIndex(int, Object)
     */
    default Data replaceLast(Data oldData, Data newData) {
        // Find last index
        int lastIndex = this.findLastIndex(oldData);

        // Replace old data with new data at last index
        this.replaceAtIndex(lastIndex, newData);

        // Return new data
        return newData;
    }

    /**
     * Replace all found occurrences of an object with new value
     * Runs in O(n * n), but technically it is 2 * O(n) + O(n * n)
     * @param oldData old value
     * @param newData new value
     * @return new value
     * @see #findAllIndexes(Object) (Object)
     * @see #replaceAtIndex(int, Object)
     */
    default Data replaceAll(Data oldData, Data newData) {
        // Find all indexes of old data
        int[] indexes = this.findAllIndexes(oldData);

        // For each index
        for (int index : indexes)
            // Replace old data with new data
            this.replaceAtIndex(index, newData);

        // Return new data
        return newData;
    }

    /**
     * This method exists just for the sake of naming conventions
     * It just redirects to another method
     * @param oldData old value
     * @param newData new value
     * @return new value
     * @see #replaceFirst(Object, Object)
     */
    default Data replace(Data oldData, Data newData) {
        // Redirect method
        return this.replaceFirst(oldData, newData);
    }
    //------------------------------------------------------------------------------------------------------------------
}