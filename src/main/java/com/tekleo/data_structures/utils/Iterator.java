package com.tekleo.data_structures.utils;

/**
 * Wrapper of Java's default Iterator interface
 *
 * @author Leo Ertuna
 * @since 26.01.2018 22:45
 */
public interface Iterator<Data> extends java.util.Iterator<Data> {
    @Override
    boolean hasNext();

    @Override
    Data next();
}