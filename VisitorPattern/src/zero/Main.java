package zero;

public class Main {
    public static void main(String[] args) {
        Child child = new Child(19,"jack");
        child.accept(new PrintAndReturnAge("q"));
        child.accept(new PrintName("w"));
    }

    //实际上还是回调接口
    //一个函数作为另一个函数参数
}
