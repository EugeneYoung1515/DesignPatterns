//观察者模式 监视者模式 发布者模式 订阅者模式 名字比较多
//Observer Publish Subscribe

//以前自己写过
//就是监听器

import java.util.ArrayList;
import java.util.List;

class Button{
    private String name;
    private List<Observer> observerList = new ArrayList<>();//可以注册多个

    private Listener listener;//只能注册一个

    public Button(String name) {
        this.name = name;
    }

    public void press(){
        System.out.println("Button "+name+" pressed");
        noteAll();

        if(listener!=null) {
            listener.perform(this);
        }
    }

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    private void noteAll(){
        for (Observer o:observerList){
            o.performed(this);
        }
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public String getName() {
        return name;
    }

}

public interface Observer {
    void performed(Button button);
}

class RedObserver implements Observer{
    private String name;

    public RedObserver(String name) {
        this.name = name;
    }

    @Override
    public void performed(Button button) {
        System.out.println(button.getName()+" note "+name);
    }
}
class BlueObserver extends RedObserver{
    public BlueObserver(String name) {
        super(name);
    }

    @Override
    public void performed(Button button) {

        System.out.println("BlueObserver");
        super.performed(button);
    }
}

interface Listener{
    void perform(Button button);
}

class easyListener implements Listener{

    @Override
    public void perform(Button button) {
        System.out.println(button.getName()+" note easyListener");
    }
}

class Main{
    public static void main(String[] args){
        Button button = new Button("small");
        button.addObserver(new RedObserver("red"));
        button.addObserver(new BlueObserver("blue"));
        button.press();

        button.setListener(new easyListener());
        button.press();

        Button button2 = new Button("big");
        button2.press();
    }
}
