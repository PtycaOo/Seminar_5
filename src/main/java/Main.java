import javax.imageio.IIOException;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        /*writeFile(zeroWrite(arr));*/
        System.out.println(Arrays.toString(rideFile("src/main/resources/test.txt")));
    }

    public static void writeFile(String arr) throws IOException {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/test.txt")) {
            fileWriter.write(arr);
        }
    }

    public static String zeroWrite(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int arrays : arr) {
            sb.append(arrays).append("0");
        }
        return sb.toString();
    }

    public static int[] rideFile(String path) throws IOException {
        ArrayList<Integer> array = new ArrayList<>();
        try (FileReader reader = new FileReader(path)) {
            int n;
            while ((n = reader.read()) != -1) {
                char temp = (char) n;
                if (temp != '0') {
                    try {
                        array.add(Integer.parseInt(String.valueOf(temp)));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        int[] result = new int[array.size()];
        int index = 0;
        for (Integer integer : array) {
            result[index++] = integer;
        }
        return result;
    }

}
