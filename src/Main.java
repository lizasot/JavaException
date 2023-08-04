import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Main {
    public static String[] inputData() throws Exception {
        Scanner in = new Scanner(System.in);
        var input = in.nextLine();
        String[] datas = input.split("\\s+");
        if (datas.length < 6) {
            throw new Exception("Недостаточно введённых данных.");
        } else if (datas.length > 6) {
            throw new Exception("Введены лишние данные.");
        }
        return datas;
    }
    // 0 = date
    // 1 = phone
    // 2 = gender
    // 3 = name
    public static int checkTypeData(String data) {
        String regexNumb = "\\d+\\.*\\d*\\.*\\d*";
        if (data.matches(regexNumb)) {
            if (data.indexOf(".") >= 0) {
                DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
                try {
                    df.parse(data);
                } catch (Exception e) {
                    return -1;
                }
                return 0;
            } else if (data.length() == 11) {
                return 1;
            }
        } else {
            if (data.equals("f") || data.equals("m") ) {
                return 2;
            } else {
                return 3;
            }
        }
        return -1;
    }
    public static void loadFileData(String filename, String data) throws IOException {
        Path path = Paths.get(filename + ".txt");
        Files.write(path, data.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }
    public static void main(String[] args) {
        boolean succes = false;
        String[] datas = {};
        while (!succes) {
            System.out.println("Укажите ФИО, дату рождения, телефон (беззнаковое число), пол (f/m) через пробел:\n");
            try {
                succes = true;
                datas = inputData();
                String[] result = new String[6];
                for (String word : datas) {
                    int type = checkTypeData(word);
                    if (type != -1) {
                        if (type == 3) {
                            for (int i = 3; i < 6; i++) {
                                if (result[i] == null || result[i].isEmpty()) {
                                    result[i] = word;
                                    break;
                                }
                            }
                        } else {
                            result[type] = word;
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    if (result[i] == null || result[i].isEmpty()) {
                        if (i == 0) {
                            System.out.println("Некорректно введены данные о дате рождения. Повторите ввод снова.\n");
                        } else if (i == 1) {
                            System.out.println("Некорректно введены данные о номере телефона. Повторите ввод снова.\n");
                        } else if (i == 2) {
                            System.out.println("Некорректно введены данные о поле. Повторите ввод снова.\n");
                        } else if (i >= 3) {
                            System.out.println("Некорректно введены данные о ФИО. Повторите ввод снова.\n");
                        }
                        succes = false;
                        break;
                    }
                }
                if (succes) {
                    loadFileData(result[3], String.join(" ", result[3], result[4], result[5], result[0], result[1], result[2]) + "\n");
                }
            } catch (Exception e) {
                succes = false;
                System.out.println(e.getMessage() + "\n");
            }
        }
    }
}