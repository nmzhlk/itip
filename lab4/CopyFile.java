package lab4;

import java.io.*;
import java.nio.file.*;

public class CopyFile {
    public static void main(String[] args) {
        Path inputPath = Paths.get("input.txt");
        Path outputPath = Paths.get("output.txt");

        try (InputStream inStream = Files.newInputStream(inputPath);
                OutputStream outStream = Files.newOutputStream(outputPath)) {
            // inStream.close();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Файл скопирован успешно");

        } catch (NoSuchFileException e) {
            System.out.println("Ошибка: файл " + e.getFile() + " не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода - IOException");
        }
    }
}
