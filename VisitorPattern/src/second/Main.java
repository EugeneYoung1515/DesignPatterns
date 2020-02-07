package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>(Arrays.asList(new Father(),new Mother()));
        list.forEach(c->{
            c.accept(new PersonPrintVisitor());
        });
    }
}
