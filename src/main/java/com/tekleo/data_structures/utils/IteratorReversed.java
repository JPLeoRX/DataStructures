package com.tekleo.data_structures.utils;

public interface IteratorReversed<Data> extends Iterator<Data> {
    boolean hasPrev();

    Data prev();
}