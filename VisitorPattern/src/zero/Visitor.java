package zero;

public interface Visitor<T> {
    T visit(Child p);
}
