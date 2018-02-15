package com.tekleo.data_structures.collections;

import com.tekleo.data_structures.utils.Immutable;
import com.tekleo.data_structures.utils.Comparator;
import com.tekleo.data_structures.utils.Iterable;

import java.lang.reflect.Array;
import java.util.stream.Stream;

public interface CollectionImmutable<Data> extends Iterable<Data>, Immutable {
    // Contains
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Does this collection contain a given object?
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
     * Does this collection contain all objects from a given collection
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
    //------------------------------------------------------------------------------------------------------------------



    // Retrieving elements
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Retrieve a random element of this collection
     *
     * This method is extremely useful for providing us with the ability to use default implementation for many methods
     * It is used in {@link #min(Comparator)}, {@link #max(Comparator)}, {@link #toArray()}
     *
     * @return an element of this collection picked randomly
     */
    Data getRandom();
    //------------------------------------------------------------------------------------------------------------------



    // Min-Max elements
    //------------------------------------------------------------------------------------------------------------------
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
     * @return number of elements in this collection
     */
    int size();

    /**
     * Hom many instances of a given object this collection contains?
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
     * @return true if it is, false otherwise
     * @see #size()
     */
    default boolean isEmpty() {
        return this.size() == 0;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Reflections
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get array from this collection
     * @return array
     */
    default Data[] toArray() {
        // Create new array
        Data[] array = (Data[]) Array.newInstance(getRandom().getClass(), this.size());

        // Add objects from this collection
        int i = 0;
        for (Data data : this)
            array[i++] = data;
        return array;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Streams
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Get a stream from this collection
     * @return stream
     * @see #toArray
     */
    default Stream<Data> toStream() {
        return Stream.of(toArray());
    }

    /**
     * Get a parallel stream from this collection
     * @return parallel stream
     * @see #toStream()
     */
    default Stream<Data> toParallelStream() {
        return toStream().parallel();
    }
    //------------------------------------------------------------------------------------------------------------------
}