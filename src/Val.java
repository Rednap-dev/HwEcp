import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Val {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Pattern patternLog = Pattern.compile("[A-z]{4,20}[^\\s]+");
        Pattern patternPass = Pattern.compile("[A-z]{4,20}[^\\s]+[\\d]+");
        while (true) {
            try {
                System.out.println("Введите логин: ");
                String login = scanner.nextLine();
                System.out.println("Введите пароль: ");
                String password = scanner.nextLine();
                System.out.println("Повторите пароль: ");
                String confirmPass = scanner.nextLine();
                Matcher matcherL = patternLog.matcher(login);
                Matcher matcherP = patternPass.matcher(password);
                if (!matcherL.matches()) {
                    throw new MyException("Wrong Login!");
                }
                if (!matcherP.matches()) {
                    throw new MyException("Wrong Password!");
                }
                if (!confirmPass.equals(password)) {
                    throw new MyException("Password mismatch!");
                }else {
                    System.out.println("Вы зарегестрировались!");
                }
                break;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
