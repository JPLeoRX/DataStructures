package com.tekleo.data_structures.collections.lists;

import com.tekleo.data_structures.collections.CollectionImmutable;
import com.tekleo.data_structures.utils.Immutable;

import java.util.Random;

/**
 * List with immutable contents
 *
 * Once created we cannot add new elements to it, or remove old elements from it
 *
 * Core concept of lists is that the data is indexed
 * For each index we have only one element
 * The default implementations in this interface heavily rely on indexes
 *
 * @author Leo Ertuna
 * @since 27.01.2018 02:12
 */
public interface ListImmutable<Data> extends CollectionImmutable<Data>, Immutable {
    // Getting
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get element at a given index
     * Try to make it run in O(1). For linked lists it runs in O(n).
     * @param index index
     * @return element at a given index,
     * @throws IllegalArgumentException is the index is out of bounds
     */
    Data get(int index);

    /**
     * Get the first element of this list
     * Runs in O(1)
     * @return first element of this list
     * @see #get(int)
     */
    default Data getFirst() {
        return get(0);
    }

    /**
     * Get the last element of this list
     * Runs in O(1). For singly linked lists it runs in O(n).
     * @return last element of this list
     * @see #get(int)
     */
    default Data getLast() {
        return get(this.size() - 1);
    }

    /**
     * Retrieve a random element of this collection
     * Runs in O(n) or O(1) depending on the implementation of {@link #get(int)}
     * @return an element of this collection picked randomly
     * @see #get(int)
     */
    @Override
    default Data getRandom() {
        // Create a new random
        Random random = new Random();

        // Generate new random index
        int randomIndex = random.nextInt(this.size());

        // Get the element of that index
        return get(randomIndex);
    }
    //------------------------------------------------------------------------------------------------------------------



    // Finding
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Find indexes of all occurrences of a given object
     * Runs in O(n), although, technically, it is 2 * O(n)
     * @param data object to find
     * @return array of indexes of all its occurrences
     */
    default int[] findAllIndexes(Data data) {
        // Count how many occurrences of the given object are in this list
        int occurrences = this.count(data);

        // Check if it's zero - we need to exit right now and return empty array
        if (occurrences == 0) {
            return new int[]{};
        }

        // If we indeed have some occurrences - pass through the list for a second time
        else {
            // Create new array to store indexes
            int[] indexes = new int[occurrences];

            // For each element in this collection
            for (int i = 0, j = 0; i < this.size(); i++)
                // If the element is found
                if (this.get(i).equals(data))
                    // Store its index
                    indexes[j++] = i;

            // Return resulting indexes
            return indexes;
        }
    }

    /**
     * Find the index of first occurrence of a given object
     * Runs in O(n), but technically it is 2 * O(n)
     * @param data object to find
     * @return index of first occurrence of given object, or -1
     * @see #findAllIndexes(Object)
     */
    default int findFirstIndex(Data data) {
        // Find all indexes
        int[] indexes = findAllIndexes(data);

        // Get first index, or -1 if none were found
        return indexes.length > 0 ? indexes[0] : -1;
    }

    /**
     * Find the index of last occurrence of a given object
     * Runs in O(n), but technically it is 2 * O(n)
     * @param data object to find
     * @return index of last occurrence of given object, or -1
     * @see #findAllIndexes(Object)
     */
    default int findLastIndex(Data data) {
        // Find all indexes
        int[] indexes = findAllIndexes(data);

        // Get last index, or -1 if none were found
        return indexes.length > 0 ? indexes[indexes.length - 1] : -1;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Helpers
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Is the given index within bounds of this list?
     * Runs in O(1)
     * @param i index to check
     * @return true if it is, false if it's not
     */
    default boolean isIndexWithinBounds(int i) {
        return (0 <= i) && (i < this.size());
    }

    /**
     * Is the given index illegal for this list? (not within bounds)
     * Generally this method may yield better performance than {@link #isIndexWithinBounds(int)}
     * Runs in O(1)
     * @param i index to check
     * @return true if it is, false if it's not
     */
    default boolean isIllegalIndex(int i) {
        return (i < 0) || (i > this.size());
    }
    //------------------------------------------------------------------------------------------------------------------
}