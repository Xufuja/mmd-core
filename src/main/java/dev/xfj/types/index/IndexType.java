package dev.xfj.types.index;

public interface IndexType<T> {
    T getValue();
    void setValue(T value);
}