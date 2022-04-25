### Iterator 인터페이스 
````java
public interface Iterator<E> {
    boolean hasNext();
    E next();
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
````

메소드
- hasNext()
- next()



### Iterable 인터페이스
최상위 인터페이스 (Set, Queue .. -> Collection -> Iterable)

메소드
- iterator()