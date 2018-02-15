package com.tekleo.data_structures.collections;

/**
 * @author Leo Ertuna
 * @since 26.01.2018 17:30
 */
public interface Collection<Data> extends CollectionImmutable<Data> {
    // Add
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Add new object to this collection
     * @param data object to be added
     * @return added object
     */
    Data add(Data data);

    /**
     * Add all objects from a given collection to this collection
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
     */
    void clear();

    /**
     * Remove a given object from this collection
     * @param data object to be removed
     * @return removed object
     */
    Data remove(Data data);

    /**
     * Removes all object of a given collection from this collection
     * @param collection objects to be removed
     * @return removed collection
     * @see #remove(Object)
     */
    default Collection<? extends Data> removeAll(Collection<? extends Data> collection) {
        for (Data data : collection)
            this.remove(data);
        return collection;
    }

    /**
     * Removes all object of a given array from this collection
     * @param array objects to be removed
     * @return removed array
     * @see #remove(Object)
     */
    default Data[] removeAll(Data[] array) {
        for (Data data : array)
            this.remove(data);
        return array;
    }
    //------------------------------------------------------------------------------------------------------------------
}