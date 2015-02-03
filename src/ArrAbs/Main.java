/**
 * Array Absurdity
 * https://www.codeeval.com/open_challenges/41/
 *
 * Author: todyerutz@plainintricacy.wordpress.com
 */

package ArrAbs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Tudor/IdeaProjects/ArrayAbsurdity/src/ArrAbs/numbers.txt"));
        String ln;
        int count=0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        System.out.println("Searching for duplicates in local file...");
        while((ln = reader.readLine())!=null){
            nums.clear();
            String[] parts = ln.split(" ");
            for(String i:parts){
                nums.add(Integer.parseInt(i));
            }
            System.out.print("Line " + count + ": ");
            findDupes(qSort(nums));
            count++;
        }
        reader.close();

    }

    public static ArrayList<Integer> qSort(ArrayList<Integer> q){
        ArrayList<Integer> smaller = new ArrayList<Integer>();
        ArrayList<Integer> greater = new ArrayList<Integer>();
        ArrayList<Integer> similar = new ArrayList<Integer>();

        if(q.size()<=1){
            return q;
        }
        Integer pivot = q.get(new Random().nextInt(q.size()));
        for(int i=0; i<q.size(); i++){
            if(q.get(i)<pivot){
                smaller.add(q.get(i));
            }else if(q.get(i)==pivot){
                similar.add(q.get(i));
            }else{
                greater.add(q.get(i));
            }
        }
        if(smaller.isEmpty()&&greater.isEmpty()){
            return similar;
        }
        smaller=qSort(smaller);
        greater=qSort(greater);

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.clear();
        result.addAll(smaller);
        result.addAll(similar);
        result.addAll(greater);
        return result;
    }

    public static void findDupes(ArrayList<Integer> x){
        for(int i=0; i<x.size()-1; i++){
            if(x.get(i)==x.get(i+1)){
                System.out.print(x.get(i) + " ");
                x.remove(i+1);
            }
        }
        System.out.println();
    }

}
