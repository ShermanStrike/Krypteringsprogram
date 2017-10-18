import java.io.*;
import java.util.Scanner;

/**
 * Created by magnus on 2017-09-27.
 */
public class fileCopy {
    public static void main(String[] args) {
        String filename;
        char copyType;
        Scanner in = new Scanner(System.in);

        System.out.print("Ange filnamn att kopiera: ");
        filename = in.nextLine();
        System.out.print("Ska filen kopieras som (T)ext eller (B)inärt? ");
        copyType = in.nextLine().charAt(0);

        if (copyType == 'T') {
            textCopy(filename);
        } else if (copyType == 'B') {
            binaryCopy(filename);
        } else {
            System.out.println("You make no sense");
        }
    }

    private static void binaryCopy(String filename) {
        DataInputStream input;
        DataOutputStream output;
        try {
            input = new DataInputStream (new BufferedInputStream(new FileInputStream(filename)));
            output = new DataOutputStream (new BufferedOutputStream(new FileOutputStream("Encrypted - "+filename)));
        } catch (FileNotFoundException e) {
            input = null;
            output = null;
            e.printStackTrace();
        }
        try {
            while(true) {
                byte b = input.readByte();
                output.write(b);
            }
        } catch (IOException e) {
            System.out.println("Klar");
        }
        try {
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void textCopy(String filename) {
        PrintWriter utFil;
        BufferedReader inFil;

        try {
            FileWriter fw = new FileWriter("Encrypted - " + filename);
            BufferedWriter bw = new BufferedWriter(fw);
            utFil = new PrintWriter(bw);
            FileReader fr = new FileReader(filename);
            inFil = new BufferedReader(fr);

            String line = inFil.readLine();
            while (line != null) {
                // kryptera line
                String key = "William";
                String cryptLine = crypt(line, key);

                utFil.println(cryptLine);
                line = inFil.readLine();
            }
            utFil.flush();
            utFil.close();
            inFil.close();

        } catch (IOException e) {
            System.out.println("Error when opening files");
            e.printStackTrace();
        }
    }
    public static String crypt(String m, String k) {
        String result = "";
        // keyexpansion
        while (k.length() < m.length())
            k += k;

        for (int i = 0; i < m.length(); i++) {
            result += (char) (m.charAt(i) ^ k.charAt(i));
        }
        return result;
    }
}
