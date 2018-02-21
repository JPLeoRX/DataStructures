package com.tekleo.data_structures.collections.lists.linked_lists.nodes_concrete;

import java.io.Serializable;

public class NodeSinglyLinked<Data> implements Serializable, Cloneable {
    private Data data;
    private NodeSinglyLinked<Data> next;

    public NodeSinglyLinked(Data data, NodeSinglyLinked<Data> next) {
        this.data = data;
        this.next = next;
    }

    public NodeSinglyLinked(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public NodeSinglyLinked<Data> getNext() {
        return next;
    }

    public NodeSinglyLinkedIterator<Data> getIterator() {
        return new NodeSinglyLinkedIterator<>(this);
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setNext(NodeSinglyLinked<Data> next) {
        this.next = next;
    }
}