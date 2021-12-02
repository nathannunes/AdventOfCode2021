import java.io.*;
class Dive2 {
    public static void main(String[] args) throws IOException {
        File input = new File("C:\\practice\\part\\src\\Dive2Input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String st;

        int horizontal=0 , depth=0 , aim=0;
        while( (st = br.readLine()) != null){
            int X = Integer.parseInt(st.replaceAll("[^\\d.]" , ""));
            if(st.charAt(0) == 'f'){
                horizontal += X ;
                depth += aim * X;
            }else if(st.charAt(0) == 'd'){
                aim += X ;
            }else{
                aim -= X ;
            }
        }
        System.out.println(horizontal * depth);
    }
}