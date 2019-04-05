public interface Waiter {
    void serve();
}

class WaiterImpl implements Waiter{
    private Waiter nextWaiter;

    @Override
    public void serve() {
        System.out.println("一号服务完");
        nextWaiter.serve();
    }

    public void setNextWaiter(Waiter nextWaiter) {
        this.nextWaiter = nextWaiter;
    }
}

class WaiterImpl2 implements Waiter{
    private Waiter nextWaiter;

    @Override
    public void serve() {
        System.out.println("二号服务完");
        if(nextWaiter!=null) {
            nextWaiter.serve();
        }
    }

    public void setNextWaiter(Waiter nextWaiter) {
        this.nextWaiter = nextWaiter;
    }
}

interface Employee{
    void work(EmployeeChain employeeChain);
}
class EmployeeChain{
    private Employee employee;
    private EmployeeChain nextEmployeeChain;
    private Manager manager;
    public void work(){
        if(employee!=null) {//隐藏了Employee中的判断逻辑
            employee.work(nextEmployeeChain);//需要数据结构了吧 要先有最后一个EmployeeChain 再往前
        }else{
            manager.work();
        }
    }
    public EmployeeChain employee(Employee employee){
        this.employee = employee;
        return this;
    }
    public EmployeeChain nextEmployeeChain(EmployeeChain nextEmployeeChain){
        this.nextEmployeeChain = nextEmployeeChain;
        return this;
    }
    public EmployeeChain manager(Manager manager){
        this.manager=manager;
        return this;
    }
}
class Manager{
    void work(){
        System.out.println("管理");
    }
}

class Employee1 implements Employee{
    @Override
    public void work(EmployeeChain employeeChain) {
        System.out.println("第一个员工");
        employeeChain.work();
    }
}

class Employee2 implements Employee{
    @Override
    public void work(EmployeeChain employeeChain) {
        System.out.println("第二个员工");
        employeeChain.work();
    }
}

class Employee3 implements Employee{
    @Override
    public void work(EmployeeChain employeeChain) {
        System.out.println("第三个员工");
        employeeChain.work();
    }
}


class Main{
    public static void main(String[] args){
        WaiterImpl waiter = new WaiterImpl();
        WaiterImpl2 waiter2 = new WaiterImpl2();
        waiter.setNextWaiter(waiter2);
        waiter.serve();

        Employee employee1 = new Employee1();
        //EmployeeChain employeeChain1 = new EmployeeChain();

        Employee employee2 = new Employee2();
        EmployeeChain employeeChain2 = new EmployeeChain();

        Employee employee3 = new Employee3();
        EmployeeChain employeeChain3 = new EmployeeChain();


        employeeChain3.employee(employee3).nextEmployeeChain(new EmployeeChain().manager(new Manager()));
        employeeChain2.employee(employee2).nextEmployeeChain(employeeChain3);
        //employeeChain1.employee(employee1).nextEmployeeChain(employeeChain2);
        employee1.work(employeeChain2);
    }
}