import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
        //Task 1.1
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        findNumbers(input);
         */
        /*
        //Task 1.2
        Scanner scanner = new Scanner(System.in);
        boolean cyc = true;
        while (cyc) {
            System.out.println("Enter a binary code to convert an integer :");
                String input = scanner.nextLine();
                if (tryParse(input)) {
                    int num = Integer.parseInt(input);
                    if (checkBinary(num)) {
                        System.out.println("A binary converted to an integer has a value :" + convertBinToDec(num));
                        cyc = false;
                    } else {
                        System.out.println("Entered value isn't a binary");
                    }
                }else {
                    System.out.println("Entered value isn't a binary");
                }
        }
        */
        //Task 1.2 Hex
        /*
        while (true) {
            System.out.println("Enter a hex code to convert an integer :");
            try {
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt(16);
                System.out.println("A hex converted to an integer has a value :" + input);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entered value isn't a hex");

            }
        }
        */
        //Task 2.1
        /*
        Scanner scanner = new Scanner(System.in);
        int j = 0;
        float[] mas = new float[5];
        while (j<5){
            System.out.print("mas["+j+"]=");
            mas[j]=scanner.nextFloat();
            j++;
        }
        System.out.println("***************");
        int i = 0;
        for (float x: mas) {
            System.out.print("mas["+i+"]=");
            System.out.printf("%+7.2f", x);
            System.out.println();
            i++;
        }
        */
        //Task 2.2
        String[] code = {"AUD","GBP","BYR"};
        int[] unit = {1,1,1000};
        String[] currency ={"Австралійський долар", "Фунт стерлінгів", "Білоруський рубль"};
        double[] equivalent ={23.9883, 45.8429, 19,7716};

    }

    //Task 1.1
    public static void findNumbers(String input) {
        Scanner sc = new Scanner(input);
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            String x = sc.findInLine("-?\\d+");
                System.out.println("Numbers found: " + x);
                list.add(x);
        }
        System.out.println("Total number of integers found: " + list.size());
    }

    //Task 1.2
    public static boolean checkBinary(int input){
        if (input <0||input==0) {
            return false;
        }
            while (input != 0) {
                if (input % 10 > 1) {
                    return false;
                }
                input = input / 10;
            }
            return true;
    }
    public static int convertBinToDec(int bin){
        int res = 0;
        int n = 0;
        boolean cyc=true;
        while(cyc){
            if(bin == 0){
                cyc=false;
            } else {
                int temp = bin%10;
                res += (int) (temp*Math.pow(2, n));
                bin = bin/10;
                n++;
            }
        }
        return res;
    }
    public static boolean tryParse(String input) {
        boolean res=true;
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            res = false;
        }
        return res;
    }
}
