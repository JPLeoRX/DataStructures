package com.tekleo.data_structures.collections.lists.linked_lists.nodes;

import java.io.Serializable;
import java.util.Objects;

/**
 * Node with a single link to the next node
 * @param <Data> generic type
 * @author Leo Ertuna
 */
public class NodeSinglyLinked<Data> implements Serializable, Cloneable {
    private Data data;
    private NodeSinglyLinked<Data> next;

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Full constructor
     * @param data data to be stored in this node
     * @param next next node
     */
    public NodeSinglyLinked(Data data, NodeSinglyLinked<Data> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Only data constructor
     * @param data data to be stored in this node
     */
    public NodeSinglyLinked(Data data) {
        this(data, null);
    }

    /**
     * No-arguments constructor
     */
    public NodeSinglyLinked() {
        this(null, null);
    }
    //------------------------------------------------------------------------------------------------------------------



    // Getters/Setters
    //------------------------------------------------------------------------------------------------------------------
    public Data getData() {
        return data;
    }

    public NodeSinglyLinked<Data> getNext() {
        return next;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setNext(NodeSinglyLinked<Data> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.getNext() != null;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Others
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "NodeSinglyLinked{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeSinglyLinked)) return false;
        NodeSinglyLinked<?> that = (NodeSinglyLinked<?>) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public NodeSinglyLinked<Data> clone() {
        return new NodeSinglyLinked<>(data);
    }
    //------------------------------------------------------------------------------------------------------------------
}