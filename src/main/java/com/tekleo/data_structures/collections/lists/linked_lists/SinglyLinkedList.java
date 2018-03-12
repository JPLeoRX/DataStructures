package com.tekleo.data_structures.collections.lists.linked_lists;

import com.tekleo.data_structures.collections.lists.List;
import com.tekleo.data_structures.collections.lists.linked_lists.nodes.NodeSinglyLinked;
import com.tekleo.data_structures.collections.lists.linked_lists.nodes.NodeSinglyLinkedIterator;
import com.tekleo.data_structures.utils.Comparator;
import com.tekleo.data_structures.utils.Iterator;

public class SinglyLinkedList<Data> implements List<Data> {
    private int size;
    private NodeSinglyLinked<Data> head;

    private NodeSinglyLinked<Data> findNodeAt(int index) {
        NodeSinglyLinked<Data> currentNode = head;
        for (int i = 0; i < index - 1; i++)
            currentNode = currentNode.getNext();
        return currentNode;
    }

    // Collection Immutable
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public int size() {
        return size;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Collection
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public void clear() {
        // Reset size
        this.size = 0;

        // Reset head
        this.head = null;
    }
    //------------------------------------------------------------------------------------------------------------------


    // List Immutable
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Data get(int index) {
        return this.findNodeAt(index).getData();
    }
    //------------------------------------------------------------------------------------------------------------------



    // List
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Data add(int index, Data data) {
        // If we have illegal arguments
        if (this.isIllegalIndex(index))
            throw new IllegalArgumentException("Index not within bounds, i=" + index + ", size=" + this.size());

        // If this is an empty list
        if (this.isEmpty())
            // Initialize the list with new head node
            this.head = new NodeSinglyLinked<>(data);

        // If we add data instead of the head
        if (index == 0) {
            head = new NodeSinglyLinked<>(data, head);
        }

        else {
            // Find the node after which data should be inserted
            NodeSinglyLinked<Data> currentNode = this.findNodeAt(index);

            // Set the next node
            currentNode.setNext(new NodeSinglyLinked<>(data, currentNode.getNext()));
        }

        // In any scenario - increment the size
        size++;

        // Return inserted data
        return data;
    }

    @Override
    public Data remove(int index) {
        NodeSinglyLinked<Data> nodeBefore = this.findNodeAt(index - 1);
        NodeSinglyLinked<Data> nodeToRemove = nodeBefore.getNext();
        NodeSinglyLinked<Data> nodeAfter = nodeToRemove.getNext();

        nodeBefore.setNext(nodeAfter);

        size--;

        return nodeToRemove.getData();
    }

    @Override
    public Data replaceAtIndex(int index, Data newData) {
        // Get node at index
        NodeSinglyLinked<Data> node = this.findNodeAt(index);

        // Replace value
        node.setData(newData);

        // Return
        return newData;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Iterable
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Iterator<Data> iterator() {
        return new SinglyLinkedListIterator<>(this);
    }

    private static class SinglyLinkedListIterator<Data> extends NodeSinglyLinkedIterator<Data> implements Iterator<Data> {
        public SinglyLinkedListIterator(SinglyLinkedList<Data> list) {
            super(list.head);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
