package com.tekleo.data_structures.collections.lists.linked_lists;

import com.tekleo.data_structures.collections.lists.List;
import com.tekleo.data_structures.collections.lists.linked_lists.nodes_concrete.NodeSinglyLinked;
import com.tekleo.data_structures.collections.lists.linked_lists.nodes_concrete.NodeSinglyLinkedIterator;
import com.tekleo.data_structures.utils.Comparator;
import com.tekleo.data_structures.utils.Iterator;

public class SinglyLinkedList<Data> implements List<Data> {
    private int size;
    private NodeSinglyLinked<Data> head;

    @Override
    public Data add(int index, Data data) {
        // If we have illegal arguments
        if (this.isIllegalIndex(index))
            throw new IllegalArgumentException("Index not within bounds, i=" + index + ", size=" + this.size());

        // If this is an empty list
        if (this.isEmpty()) {
            // Initialize the list with new head node
            this.head = new NodeSinglyLinked<>(data);
        }

        // If it is not empty
        else {
            // If data is added in the beginning of the list
            if (index == 0) {
                this.head = new NodeSinglyLinked<>(data, head);
            }

            // If data is added in any other part of the list
            else {
                // Find the node after which data should be inserted
                NodeSinglyLinked<Data> currentNode = head;
                for (int i = 0; i < index - 1; i++)
                    currentNode = currentNode.getNext();

                // Set the next node
                currentNode.setNext(new NodeSinglyLinked<>(data, currentNode.getNext()));
            }
        }

        // In any scenario - increment the size
        size++;

        // Return inserted data
        return data;
    }

    @Override
    public Data remove(int index) {
        return null;
    }

    @Override
    public Data replaceFirst(Data oldData, Data newData) {
        return null;
    }

    @Override
    public Data replaceLast(Data oldData, Data newData) {
        return null;
    }

    @Override
    public Data replaceAll(Data oldData, Data newData) {
        return null;
    }

    @Override
    public Data replaceAtIndex(int index, Data newData) {
        return null;
    }

    @Override
    public void sort(Comparator<Data> comparator) {

    }

    @Override
    public void reverse() {

    }

    @Override
    public void shuffle() {

    }

    @Override
    public void clear() {

    }

    @Override
    public Data removeAll(Data data) {
        return null;
    }

    @Override
    public Data get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Data> iterator() {
        return head.getIterator();
    }
}
