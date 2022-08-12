public class Validator {

    private static final String validSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    public static boolean checkId(String login,
                                  String password,
                                  String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void validate(String login,
                                String password,
                                String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Длина логина привышает 20 символов");
        }
        if (!checkSymbols(login)) {
            throw new WrongLoginException("Логин содержит недопустимые символы");
        }
        if (password == null || password.length() >= 20 ||
                confirmPassword == null || confirmPassword.length() >= 20) {
            throw new WrongPasswordException("Длина пароля привышает 20 символов");
        }
        if (!checkSymbols(password) || !checkSymbols(confirmPassword)) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static boolean checkSymbols(String s) {
        char[] symbols = s.toCharArray();
        for (char symbol : symbols) {
            if (!validSymbols.contains(String.valueOf(symbol))) {
                return false;
            }
        }
        return true;
    }
}
