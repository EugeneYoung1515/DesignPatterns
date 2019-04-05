public class User {

    private String name;
    private String password;
    private int age;
    private int phoneNumber;

    public User(){}

    //idea生成的
    private User(Builder builder) {
        setName(builder.name);
        setPassword(builder.password);
        setAge(builder.age);
        setPhoneNumber(builder.phoneNumber);
    }

    //idea生成的
    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //自己写的builder模式
    public User name(String name){
        this.name=name;
        return this;
    }

    public User password(String password){
        this.password=password;
        return this;
    }

    public User age(int age){
        this.age=age;
        return this;
    }

    public User phoneNumber(int phoneNumber){
        this.phoneNumber=phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                '}';
    }


    //idea生成的
    public static final class Builder {
        private String name;
        private String password;
        private int age;
        private int phoneNumber;

        //注释掉 Main类中User3就能用了
        //private Builder() {
        //}

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder phoneNumber(int val) {
            phoneNumber = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
