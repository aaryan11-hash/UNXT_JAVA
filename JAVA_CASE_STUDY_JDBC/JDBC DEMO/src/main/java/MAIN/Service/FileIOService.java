package MAIN.Service;

import java.io.*;

public class FileIOService {

    public static final String FILE_LOCATION = "D:\\CERTIFICATES\\Teacher.txt";

    public static void printCertificate(String name) throws IOException {
        File file = new File(FILE_LOCATION);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int count = 2;
        while ((st = br.readLine()) != null) {

            if(count == 0) {
                System.out.println(st.replace("NAME",name));
                continue;
            }
            count--;

            System.out.println(st);

        }
    }
}
