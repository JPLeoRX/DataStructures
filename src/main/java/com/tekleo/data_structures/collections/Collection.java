package com.tekleo.data_structures.collections;

/**
 * General representation of collection
 *
 * @author Leo Ertuna
 * @since 26.01.2018 17:30
 */
public interface Collection<Data> extends CollectionImmutable<Data> {
    // Add
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Add new object to this collection
     * Try to implement it so that it runs O(n) in worst case and O(1) in general
     * @param data object to be added
     * @return added object
     */
    Data add(Data data);

    /**
     * Add all objects from a given collection to this collection
     * Runs in O(n * m) worst case, should be O(m) in general
     * @param collection objects to add
     * @return added collection
     * @see #add(Object)
     */
    default Collection<? extends Data> addAll(Collection<? extends Data> collection) {
        for (Data data : collection)
            this.add(data);
        return collection;
    }

    /**
     * Add all objects from a given array to this collection
     * Runs in O(n * m) worst case, should be O(m) in general
     * @param array objects to add
     * @return added array
     * @see #add(Object)
     */
    default Data[] addAll(Data[] array) {
        for (Data data : array)
            this.add(data);
        return array;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Remove
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Remove all items from this collection
     * Try to implement it so that it runs O(n)
     */
    void clear();

    /**
     * Remove all occurrences of a given object from this collection
     * Try to implement it so that it runs O(n) in worst case
     * @param data object to be removed
     * @return removed object
     */
    Data removeAll(Data data);

    /**
     * Remove all occurrences of all objects of a given collection from this collection
     * Runs in O(n * m)
     * @param collection objects to be removed
     * @return removed collection
     * @see #removeAll(Object)
     */
    default Collection<? extends Data> removeAll(Collection<? extends Data> collection) {
        for (Data data : collection)
            this.removeAll(data);
        return collection;
    }

    /**
     * Remove all occurrences of all objects of a given array from this collection
     * Runs in O(n * m)
     * @param array objects to be removed
     * @return removed array
     * @see #removeAll(Object)
     */
    default Data[] removeAll(Data[] array) {
        for (Data data : array)
            this.removeAll(data);
        return array;
    }
    //------------------------------------------------------------------------------------------------------------------
}