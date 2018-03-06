package com.tekleo.data_structures.collections.lists.linked_lists.nodes;

import com.tekleo.data_structures.utils.Iterator;

/**
 * Iterator for singly linked nodes
 *
 * Iterates through the nodes until it reaches the end of the list
 *
 * @see NodeSinglyLinked node
 * @param <Data> generic type
 * @author Leo Ertuna
 */
public class NodeSinglyLinkedIterator<Data> implements Iterator<Data> {
    /**
     * The next node
     */
    private NodeSinglyLinked<Data> nextNode;

    /**
     * Constructor
     *
     * Takes the head node to start iterating
     *
     * @param head iteration start node
     */
    public NodeSinglyLinkedIterator(NodeSinglyLinked<Data> head) {
        this.nextNode = head;
    }

    /**
     * Check if we have a next node
     * @return true if next node is not null, false otherwise
     */
    @Override
    public boolean hasNext() {
        return nextNode != null;
    }

    /**
     * Retrieve data from next node and shift forward by one node
     * @return data from next node
     */
    @Override
    public Data next() {
        Data data = nextNode.getData();
        nextNode = nextNode.getNext();
        return data;
    }
}