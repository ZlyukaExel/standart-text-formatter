import text_formatter.TextFormatter;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Выберите файл для форматирования: ");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String input;
            try {
                input = Files.readString(file.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.print(file.getAbsolutePath() +
                    "\nМаксимальная ширина текста (в символах): ");
            int width = sc.nextInt();

            System.out.print(file.getAbsolutePath() +
                    "\nРазмер отступа (в пробелах): ");
            int padding = sc.nextInt();

            String result = TextFormatter.formatText(input, width, padding);
            System.out.println(result);
        }
        else {
            System.out.println("Файл не был выбран!");
        }
    }
}