package com.tekleo.data_structures.collections.lists.linked_lists.nodes_concrete;

import java.io.Serializable;

public class NodeDoublyLinked<Data> implements Serializable, Cloneable  {
    private Data data;
    private NodeDoublyLinked<Data> prev;
    private NodeDoublyLinked<Data> next;

    public NodeDoublyLinked(Data data) {
        this.data = data;
    }

    public NodeDoublyLinked(Data data, NodeDoublyLinked<Data> prev, NodeDoublyLinked<Data> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Data getData() {
        return data;
    }

    public NodeDoublyLinked<Data> getPrev() {
        return prev;
    }

    public NodeDoublyLinked<Data> getNext() {
        return next;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setPrev(NodeDoublyLinked<Data> prev) {
        this.prev = prev;
    }

    public void setNext(NodeDoublyLinked<Data> next) {
        this.next = next;
    }
}
