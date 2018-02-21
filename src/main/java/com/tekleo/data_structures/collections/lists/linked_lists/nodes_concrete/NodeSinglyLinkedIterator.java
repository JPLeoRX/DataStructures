package com.tekleo.data_structures.collections.lists.linked_lists.nodes_concrete;

import com.tekleo.data_structures.utils.Iterator;

public class NodeSinglyLinkedIterator<Data> implements Iterator<Data> {
    private NodeSinglyLinked<Data> currentNode;

    public NodeSinglyLinkedIterator(NodeSinglyLinked<Data> head) {
        this.currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public Data next() {
        Data data = currentNode.getData();
        currentNode = currentNode.getNext();
        return data;
    }
}