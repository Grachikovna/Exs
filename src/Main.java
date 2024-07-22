public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    private static final String AllLetters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";

    public static void main(String[] args) {
        try {
            confirmationOfDate("Rima", "qwerty_22", "qwerty_22");
            System.out.println("Проверка пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Проверка не пройдена");
            e.printStackTrace();
        }
    }

    public static void confirmationOfDate(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина больше 20");
        }
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("В логине недопустмые символы");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Длина пароля больше 20");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException(("В пароле недопустмые символы"));
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли друг с другом не совпадают");
        }
    }

}

