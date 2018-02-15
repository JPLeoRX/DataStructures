package com.tekleo.data_structures.utils;

/**
 * Wrapper of Java's default Comparator interface
 *
 * @author Leo Ertuna
 * @since 13.02.2018 12:03
 */
public interface Comparator<Data> extends java.util.Comparator<Data> {
    @Override
    int compare(Data o1, Data o2);

    @Override
    boolean equals(Object obj);
}