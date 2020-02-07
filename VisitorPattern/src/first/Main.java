package first;

public class Main {
    public static void main(String[] args) {
        Child child = new Child(19,"jack");
        child.accept(new PrintAndReturnAge("q"));
        child.accept(new PrintName("w"));

        Father father = new Father();
        father.accept(new FatherPrint());
    }
}
