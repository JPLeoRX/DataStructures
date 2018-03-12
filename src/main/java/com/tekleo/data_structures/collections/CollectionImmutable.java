package com.tekleo.data_structures.collections;

import com.tekleo.data_structures.utils.Immutable;
import com.tekleo.data_structures.utils.Comparator;
import com.tekleo.data_structures.utils.Iterable;

import java.lang.reflect.Array;
import java.util.stream.Stream;

/**
 * This interface presents core functionality of a collection
 *
 * We keep the collection immutable for this interface
 *
 * Methods implemented here rely heavily on {@link com.tekleo.data_structures.utils.Iterator} implementation
 *
 * @param <Data> generic parameter
 * @author Leo Ertuna
 * @since 16.02.2018 13:37
 */
public interface CollectionImmutable<Data> extends Iterable<Data>, Immutable {
    // Contains, All, Any
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Does this collection contain a given object?
     * Runs in O(n)
     * @param data object to be searched for
     * @return true if this object is in this collection, false otherwise
     */
    default boolean contains(Data data) {
        for (Data d : this)
            if(d.equals(data))
                return true;
        return false;
    }

    /**
     * Does this collection contain all objects from a given collection
     * Runs in O(n * m)
     * @param collection objects to be searched for
     * @return true if all the objects are in this collection, false otherwise
     * @see #contains(Object)
     */
    default boolean containsAll(Collection<? extends Data> collection) {
        for (Data data : collection)
            if (!this.contains(data))
                return false;
        return true;
    }

    /**
     * Does this collection contain all objects from a given array
     * Runs in O(n * m)
     * @param array objects to be searched for
     * @return true if all the objects are in this collection, false otherwise
     * @see #contains(Object)
     */
    default boolean containsAll(Data[] array) {
        for (Data data : array)
            if (!this.contains(data))
                return false;
        return true;
    }

    /**
     * Does this collection contain any single object from a given collection
     * Runs in O(n * m) worst case, but for general case it should be much better
     * @param collection objects to be searched for
     * @return true if any of the objects are in this collection, false otherwise
     * @see #contains(Object)
     */
    default boolean containsAny(Collection<? extends Data> collection) {
        for (Data data : collection)
            if (this.contains(data))
                return true;
        return false;
    }

    /**
     * Does this collection contain any single object from a given array
     * Runs in O(n * m) worst case, but for general case it should be much better
     * @param array objects to be searched for
     * @return true if any of the objects are in this collection, false otherwise
     * @see #contains(Object)
     */
    default boolean containsAny(Data[] array) {
        for (Data data : array)
            if (this.contains(data))
                return true;
        return false;
    }

    /**
     * Does this collection contain only unique (not-repeating) elements
     * Meaning each item in the collection occurs only once
     * Runs in O(n * n)
     * Can be overriden to O(1) by specific classes that contain only unique elements by definition
     * TODO improve it to O(n) using hash-map or hash-set in the future
     * @return true if it is unique, false if it's not
     * @see #count(Object)
     */
    default boolean containsOnlyUniqueElements() {
        for (Data data : this)
            if (this.count(data) > 1)
                return false;
        return true;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Retrieving elements
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Retrieve a random element of this collection
     *
     * This method is extremely useful for providing us with the ability to use default implementation for many methods
     *
     * It is used in {@link #min(Comparator)}, {@link #max(Comparator)}, {@link #toArray()}
     *
     * Try to implement it in a way that it runs in O(1), but most likely it will run in O(n)
     *
     * This should not be truly random
     *
     * @return an element of this collection picked randomly
     */
    Data getRandom();
    //------------------------------------------------------------------------------------------------------------------



    // Min-Max elements
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get smallest element in this collection
     * Runs in O(n)
     * @param comparator comparator of {@link Data} objects
     * @return minimum element
     */
    default Data min(Comparator<Data> comparator) {
        // Get a random element as current min
        Data min = this.getRandom();

        // For each element in this
        for (Data next : this)
            // If next element is smaller than current minimum
            if (comparator.compare(next, min) < 0)
                // Overwrite current min with new value
                min = next;

        // Return resulting minimum
        return min;
    }

    /**
     * Get largest element in this collection
     * Runs in O(n)
     * @param comparator comparator of {@link Data} objects
     * @return maximum element
     */
    default Data max(Comparator<Data> comparator) {
        // Get a random element as current max
        Data max = this.getRandom();

        // For each element in this
        for (Data next : this)
            // If next element is greater than current maximum
            if (comparator.compare(next, max) > 0)
                // Overwrite current max with new value
                max = next;

        // Return resulting maximum
        return max;
    }
    //------------------------------------------------------------------------------------------------------------------




    // Size and counting
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get the size of this collection
     * Runs in O(1)
     * @return number of elements in this collection
     */
    int size();

    /**
     * Hom many instances of a given object this collection contains?
     * Runs in O(n)
     * @param data object to be counted
     * @return number of occurrences of a given object
     */
    default int count(Data data) {
        int count = 0;
        for (Data d : this)
            if(d.equals(data))
                count++;
        return count;
    }

    /**
     * Is this collection empty?
     * Runs in O(1)
     * @return true if it is, false otherwise
     * @see #size()
     */
    default boolean isEmpty() {
        return this.size() == 0;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Array/Streams
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get array from this collection
     * Runs in O(n)
     * @return array
     */
    default Data[] toArray() {
        // Check to make sure that #getRandom() method will not return null
        if (!this.isEmpty()) {
            // Create new array
            Data[] array = (Data[]) Array.newInstance(getRandom().getClass(), this.size());

            // Add objects from this collection
            int i = 0;
            for (Data data : this)
                array[i++] = data;

            // Return resulting array
            return array;
        }

        // Is it is empty, TODO solve the empty case in some other way
        else {
            return (Data[]) new Object[]{};
        }
    }

    /**
     * Get a stream from this collection
     * Runs in O(n) probably, depends on Java's implementation of Stream
     * @return stream
     * @see #toArray
     */
    default Stream<Data> toStream() {
        // Get default stream of array
        return Stream.of(toArray());
    }

    /**
     * Get a parallel stream from this collection
     * Runs in O(n) probably, depends on Java's implementation of Stream and ParallelStream
     * @return parallel stream
     * @see #toStream()
     */
    default Stream<Data> toParallelStream() {
        // Get parallel stream from default stream
        return toStream().parallel();
    }
    //------------------------------------------------------------------------------------------------------------------
}