package js8ri.ch01.ex09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * Q:どのような場面でそのメソッドを活用できるでしょうか
 * A:構文解析などで活用可能
 *
 */

public interface Collection2<E> extends Collection<E> {

    default void forEachIf(Consumer<? super E> action, Predicate<? super E> filter) {
        Objects.requireNonNull(action);
        Objects.requireNonNull(filter);
        this.stream().filter(filter).forEach(action);
    }

    class ArrayList2<E> extends ArrayList<E> implements Collection2<E>{
    }


}