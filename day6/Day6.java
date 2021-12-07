package day6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


public class Day6 {
    public static void main(String[] args) throws IOException {
        String line;
        long[] input =   new long[9];
        File file = new File("C:\\practice\\part\\src\\day6\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null){
            for (String val : line.split(",")) {
                input[Integer.valueOf(val)]++;
            }
        }
        solve(input , 80);
        solve(input , 256);
    }

    public static void solve(long[] input , int days){
        for (int i=0;i<days; i++) {
            long[] tmp = new long[9];
            for (int j=0; j<9; j++) {
                if (j == 0) {
                    tmp[6] += input[0];
                    tmp[8] += input[0];
                }
                else tmp[j-1] += input[j];
            }
            input = tmp;
        }
        System.out.println(LongStream.of(input).sum());
    }

}
