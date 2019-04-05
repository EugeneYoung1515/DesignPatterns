public class Main {

    public static void main(String[] args) {
       User user = new User().name("hh").password("1234").age(21).phoneNumber(12345678);
       System.out.println(user);

       User user2 = User.newBuilder().name("hh").password("1234").age(21).phoneNumber(12345678).build();
       System.out.println(user2);

       User user3 = new User.Builder().name("hh").password("1234").age(21).phoneNumber(12345678).build();
       System.out.println(user3);
    }
}
