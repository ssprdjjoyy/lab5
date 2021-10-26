import java.io.File;
import java.io.*;
import java.util.Scanner;

public class lab5_var2 {
    public static void main(String[] args){
        try {
            File f1 = new File("numDouble.txt");
            f1.createNewFile();
            if (f1.exists()) {
                System.out.println("Создан!");
                System.out.println("Полный путь1: " + f1.getAbsolutePath());
            }
            Scanner sc = new Scanner(System.in);
            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));

            System.out.print("Введите строки для записи в файл => ");
            for (int i = 0; i < 2; i++) {
                String s=sc.nextLine();
                wr.writeUTF(s +"\n");}

            System.out.println("Введите числа: ");
            for (int i = 0; i < 5; i++){
                wr.writeDouble(sc.nextDouble());}
            wr.flush();
            wr.close();
            File f2 = new File("Result.txt");
            f2.createNewFile();
            if (f2.exists()) {
                System.out.println("Создан!");
                System.out.println("Полный путь1: " + f2.getAbsolutePath());
            }
            DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));

            String stroka = rd.readUTF();
            wr.writeUTF(stroka + "\1");
            System.out.println(" Строка " + (String) stroka);
            try {
                while (true) {
                    double number = rd.readDouble();
                    if ((double) number > 0) {
                        wr.writeDouble(number);
                        System.out.println(" Число " + (double) number);
                    }
                }
            } catch(EOFException e){}
            wr.flush();
            wr.close();
            rd.close();
        } catch (IOException e) {
            System.out.println("End of file");
        }

    }
}