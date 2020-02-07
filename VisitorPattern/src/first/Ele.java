package first;

public interface Ele<T> {
    <R> R accept(Visitor<T,R> visitor);
}
