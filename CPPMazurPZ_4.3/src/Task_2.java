import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input message: ");
        String msg = scanner.nextLine();
        System.out.println("Select output method: \n1. Terminal\n2. Error terminal\n3. File");
        int outputMethod = scanner.nextInt();
        switch (outputMethod) {
            case 1 -> {
                Printable printable = new Printable() {
                    @Override
                    public void print(String msg) {
                        System.out.println(msg);
                    }
                };
                printable.print(msg);
            }
            case 2 -> {
                printMessage(msg, (msg1) -> System.err.println(msg1));
            }
            case 3 -> {
                printMessage(msg, Task_2::printFile);
            }
            default -> throw new InputMismatchException("Invalid input");
        }
    }

    private static void printMessage(String msg, Printable p) {
        p.print(msg);
    }

    private static void printFile(String msg) {
        try (FileWriter fw = new FileWriter("file.txt")) {
            fw.write(msg);
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }
}