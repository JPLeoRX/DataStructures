package com.tekleo.data_structures.collections.lists.array_lists;

public class ArrayList<Data> {
    Object[] array;
    int size;

    private int capacity() {
        return array.length;
    }

    private void grow() {
        // Get old capacity and calculate new capacity
        int oldCapacity = this.capacity();
        int newCapacity = (int) (1.5 * oldCapacity);

        // Stretch the array
        this.stretchArray(newCapacity);
    }

    private void trim() {
        // Get old capacity and calculate new capacity
        int oldCapacity = this.capacity();
        int newCapacity = (int) (0.5 * oldCapacity);

        // Shrink the array
        this.shrinkArray(newCapacity);
    }

    private void stretchArray(int newCapacity) {
        // Check for valid new capacity
        if (newCapacity <= this.capacity())
            throw new IllegalArgumentException("New capacity is less than or equal to old one");

        // Create new array
        Object[] newArray = new Object[newCapacity];

        // Copy elements from the old one
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];

        // Reassign to new array
        array = newArray;
    }

    private void shrinkArray(int newCapacity) {
        // Check for valid new capacity
        if (newCapacity >= this.capacity())
            throw new IllegalArgumentException("New capacity is greater than or equal to old one");

        // Create new array
        Object[] newArray = new Object[newCapacity];

        // Copy elements from the old one
        for (int i = 0; i < newCapacity; i++)
            newArray[i] = array[i];

        // Reassign to new array
        array = newArray;
    }
}
