package dev.xfj.types.index;

public sealed interface IndexType<T> permits IndexByte, IndexUByte, IndexInt16, IndexUInt16, IndexInt32{
    T getValue();
    void setValue(T value);
}