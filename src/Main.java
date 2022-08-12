public class Main {


    public static void main(String[] args) {
        boolean validationTest = Validator.checkId("Test_123", "Test_123", "Test_123");
        if (validationTest) {
            System.out.println("Корректный логин и пароль");
        } else {
            System.out.println("Неверный логин или пароль");
        }
    }

}