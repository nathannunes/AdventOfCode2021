package day3;

import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Day3p2 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>();
        String line;
        File file = new File("C:\\practice\\part\\src\\day3\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        while((line = br.readLine()) != null){
            input.add(line);
        }
        System.out.println(calculateOxygen(input) * calculateCarbon(input));
    }

    public static int calculateOxygen(ArrayList<String> input){
        String oxygen ="";
        int one=0 , zero = 0;
        for (int j = 0; j < input.get(0).length(); j++) {
            for (int i = 0; i < input.size(); i++) {
                if (input.get(i).charAt(j) == '1') one++;
                 else zero++;
            }
            int finalJ = j;
            input = one >= zero? (ArrayList<String>) input.stream().filter(i -> i.charAt(finalJ) == '1').collect(Collectors.toList()) :
                    (ArrayList<String>) input.stream().filter(i -> i.charAt(finalJ) == '0').collect(Collectors.toList());
            one = 0;zero = 0;
            if (input.size() == 1) oxygen = input.get(0);
        }
        return Integer.parseInt(oxygen , 2);
    }

    public static int calculateCarbon(ArrayList<String> input){
        int one=0 , zero = 0;
        String carbon ="";
        int length = input.get(0).length();
        while(!input.isEmpty()){
            for (int j = 0; j < length ; j++) {
                for (int i = 0; i < input.size(); i++) {
                    if (input.get(i).charAt(j) == '1') one++;
                    else zero++;
                }
                int finalJ = j;
                input = one >= zero? (ArrayList<String>) input.stream().filter(i -> i.charAt(finalJ) == '0').collect(Collectors.toList()) :
                        (ArrayList<String>) input.stream().filter(i -> i.charAt(finalJ) == '1').collect(Collectors.toList());

                one=0 ; zero = 0;
                if (input.size() == 1) carbon = input.get(0);
            }
        }
        return Integer.parseInt(carbon , 2);
    }


}
