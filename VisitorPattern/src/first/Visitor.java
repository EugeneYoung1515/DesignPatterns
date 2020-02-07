package first;

public interface Visitor<T,R> {
    R visit(T t);
}
