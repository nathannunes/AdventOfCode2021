package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.collections4.map.LinkedMap;
import org.apache.commons.collections4.map.MultiKeyMap;

public class Day5 {
    public static void main(String[] args) throws IOException {
        ArrayList<String[]> input = new ArrayList<>();
        String line;
        File file = new File("C:\\practice\\part\\src\\day5\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        while((line = br.readLine()) != null){
            input.add(line.split("->"));
        }

        solvePart(input , 1);
        solvePart(input , 2);

    }

    public static void getAns(MultiKeyMap cache){
        AtomicInteger ans = new AtomicInteger();
        cache.forEach((key,value)->{
            if((int)value >= 1){
                ans.addAndGet(1);
            }
        });
        System.out.println(ans);
    }

    public static void solvePart(ArrayList<String[]> input , int part){
        int x1=0,y1=0,x2=0,y2=0;
        MultiKeyMap cache = MultiKeyMap.multiKeyMap(new LinkedMap<>());
        for (String[] i : input) {
            String[] start = i[0].split(",") ; String[] end = i[1].split(",") ;
            x1 = Integer.parseInt(start[0].strip()) ; y1 = Integer.parseInt(start[1].strip()) ; x2 = Integer.parseInt(end[0].strip()) ;
            y2 = Integer.parseInt(end[1].strip()) ;

            if(part==1){
                int a = Math.max(x1,x2) , b = Math.min(x1 , x2) , c = Math.max(y1,y2) , d = Math.min(y1 , y2);
                if(x1 == x2 || y1 == y2){
                    for (int x= b ; x<=a ; x++){
                        for(int y=d ; y<=c ; y++){
                            if(cache.get(x,y) == null){
                                cache.put(x,y ,  0);
                            }else {
                                int p = (int) cache.get(x,y);
                                cache.put(x,y , Math.addExact(p,1));
                            }
                        }
                    }
                }
            }else{
                int dx = x2 - x1;
                int dy = y2 -y1;
                for(int x = 0 ; x<=Math.max(Math.abs(dx) , Math.abs(dy)) ; x++){
                    int a = x1 + (dx > 0? 1 : (dx < 0? -1 : 0)) * x;
                    int b = y1 + (dy > 0? 1 : (dy < 0? -1 : 0)) * x;
                    if(cache.get(a,b) == null){
                        cache.put(a,b ,  0);
                    }else {
                        int p = (int) cache.get(a,b);
                        cache.put(a,b , Math.addExact(p,1));
                    }
                }
            }

        }
        getAns(cache);
    }



}
