package com.tekleo.data_structures;

import com.tekleo.data_structures.collections.Collection;
import com.tekleo.data_structures.utils.Immutable;

public class Sequence<Data> implements Immutable {
    public Sequence(Data ... array) {

    }

    public Sequence(Collection<Data> collection) {
        this(collection.toArray());
    }
}
