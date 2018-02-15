package com.tekleo.data_structures.utils;

/**
 * Wrapper of Java's default Iterable interface
 *
 * @author Leo Ertuna
 * @since 26.01.2018 17:40
 */
public interface Iterable<Data> extends java.lang.Iterable<Data> {
    @Override
    Iterator<Data> iterator();
}