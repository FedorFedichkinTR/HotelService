package com.epam.util;


import java.util.function.Consumer;

@FunctionalInterface
public interface ExceptionalConsumer<T, E extends Throwable> extends Consumer<T> {

    static <T, E extends Throwable> Consumer<T> toUncheckedConsumer(ExceptionalConsumer<T, E> exceptionalConsumer) {
        return exceptionalConsumer;
    }

    void call(T t) throws E;

    @Override
    default void accept(T t) {
        try {
            call(t);
        } catch (Throwable e) {
            ifThrowable((E) e);
        }
    }

    default void ifThrowable(E e) {
        throw new RuntimeException(e);
    }
}
