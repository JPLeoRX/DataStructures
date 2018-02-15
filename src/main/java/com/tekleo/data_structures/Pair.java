package com.tekleo.data_structures;

import com.tekleo.data_structures.utils.Immutable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Pair of objects
 *
 * Immutable - we cannot change the contents of the pair after it was created
 *
 * @param <Left>
 * @param <Right>
 *
 * @author Leo Ertuna
 * @since 26.01.2018 14:31
 */
public class Pair<Left, Right> implements Immutable, Cloneable, Serializable {
    private final Left left;
    private final Right right;

    /**
     * Constructor
     * @param left object 1
     * @param right object 2
     */
    public Pair(Left left, Right right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Getter for the left object
     * @return
     */
    public Left getLeft() {
        return left;
    }

    /**
     * Getter for the right object
     * @return
     */
    public Right getRight() {
        return right;
    }

    /**
     * Static access for easier creation of new objects
     * @param a
     * @param b
     * @param <A>
     * @param <B>
     * @return
     */
    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    protected Pair<Left, Right> clone() throws CloneNotSupportedException {
        return new Pair<>(left, right);
    }
}