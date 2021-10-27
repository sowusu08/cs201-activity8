import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class SortedFreqs {
    public int[] /*static void*/ freqs(String[] data) {
        // APPROACH
        // put elements from data into TreeSet "dataSet"

        // init arrayList called "retList"

        // loop through each element in TreeSet
            // call Collections.frequency(data as a List, element) and store value in "retList"

        // return retList as an Array


        // EXECUTON
        // put elements from data into TreeSet "dataSet"
        TreeSet<String> dataSet = new TreeSet<>(Arrays.asList(data));

        // init arrayList called "retList"
        ArrayList<Integer> retList = new ArrayList<>();

        // loop through each element in TreeSet
        for(String word : dataSet) {
            // call Collections.frequency(data as a List, element) and store value in "retList"
            retList.add(Collections.frequency(Arrays.asList(data), word));
        }
        // return retList as an Array
        //System.out.println(retList);

        int[] ret = new int[retList.size()];

        for(int i = 0; i < retList.size(); i++){
            ret[i] = retList.get(i);
        }

        return ret;


    }

    /*public static void main(String[] args) {
        String[] data_ = {"apple", "pear", "cherry", "apple", "cherry", "pear", "apple", "banana"};

        freqs(data_);
    }*/
}