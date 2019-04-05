
//抽象父类 未抽象的方法 调用 抽象方法 抽象方法教给子类实现

//模版方法没这么简单
//还有好几个概念

/*
基本方法

        抽象方法：由抽象模板角色声明，abstract修饰，具体模板角色实现。

        钩子方法：由抽象模板角色声明并实现，具体模板角色可实现加以扩展。

        具体方法：由抽象模板角色声明并实现，而子类并不实现。


        也要设计修饰符
        如protected private final

        */




public abstract class JdbcTemplate {
    public void execute(String sql){
        //System.out.println("获得连接");
        getConnection();

        System.out.println("预备语句预编译");
        System.out.println(sql);
        setParameters();
        if(isQuery()) {
            System.out.println("执行查询");
            columnToProperty();
        }else{
            System.out.println("执行更新");
        }
        System.out.println("关闭资源");
    }
    protected abstract void setParameters();//设置预备语句中的参数
    //这一句 在抽象父类实现就好 不要交给子类 可变参数或者Object[]
    //上面的抽象方法 实际使用时 是要有方法参数和返回值的

    //抽象方法由子类实现

    protected void columnToProperty(){};//结果集的每列到对象的属性的映射
    //钩子方法

    protected boolean isQuery(){//钩子方法
        return true;
    }

    private final void getConnection(){//具体方法
        System.out.println("获得连接");
    }
}

class JdbcTemplateChild extends JdbcTemplate{
    @Override
    public void setParameters() {
        System.out.println("设置参数");
    }

    @Override
    public void columnToProperty() {
        System.out.println("结果集映射");
    }
}
class JdbcTemplateChild2 extends JdbcTemplate{
    @Override
    protected void setParameters() {
        System.out.println("设置参数");
    }

    @Override
    protected boolean isQuery() {
        return false;
    }
}

class JdbcTemplate2{
    public void execute(String sql,Parameters parameters,ColumnToPropertyHandler handler){
        System.out.println("获得连接");
        System.out.println("预备语句预编译");
        System.out.println(sql);
        parameters.setParameters();
        System.out.println("执行查询");
        handler.columnToProperty();
        //使用回调接口替代模版方法

        System.out.println("关闭资源");
    }
}

interface Parameters{
    void setParameters();
}

interface ColumnToPropertyHandler{
    void columnToProperty();
}

class Main{
    public static void main(String[] args){
        JdbcTemplate jdbcTemplate = new JdbcTemplateChild();
        jdbcTemplate.execute("SELECT * FROM t_user");

        JdbcTemplate jdbcTemplate2 = new JdbcTemplateChild2();
        jdbcTemplate2.execute("UPDATE t_user SET user_name = ? WHERE user_id = ?");

        JdbcTemplate2 jdbcTemplate3 = new JdbcTemplate2();
        jdbcTemplate3.execute("SELECT COUNT(*) FROM t_user", new Parameters() {
            @Override
            public void setParameters() {
                System.out.println("设置参数");
            }
        }, new ColumnToPropertyHandler() {
            @Override
            public void columnToProperty() {
                System.out.println("结果集映射");
            }
        });
    }
}
