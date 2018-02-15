package com.tekleo.data_structures.collections.sets;

import com.tekleo.data_structures.collections.CollectionImmutable;

/**
 * @author Leo Ertuna
 * @since 13.02.2018 15:42
 */
public interface SetImmutable<Data> extends CollectionImmutable<Data> {
    /**
     *
     * @param otherSet
     * @return
     */
    public abstract SetImmutable<Data> union(SetImmutable<Data> otherSet);

    /**
     *
     * @param otherSet
     * @return
     */
    public abstract SetImmutable<Data> intersection(SetImmutable<Data> otherSet);

    /**
     *
     * @param otherSet
     * @return
     */
    public abstract SetImmutable<Data> difference(SetImmutable<Data> otherSet);

    /**
     *
     * @param subset
     * @return
     */
    public abstract boolean hasSubset(SetImmutable<Data> subset);
}