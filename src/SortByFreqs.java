import java.sql.Array;
import java.util.*;

public class SortByFreqs {

    public String[] /*static void*/ sort(String[] data) {
        // APPROACH
        // make copy of "data" String arrayList and call it "retList"
        // Sort "retList" by frequency using Comparator.comparing(retList, String::Collections.frequency(retList, String))
        // then sort alphabetically using Collections.sort(retList)
        // add elements form "retList" to TreeSet (order is kept by duplicates removed) called "retSet"
        // add elements from "retSet" to an Array "ret" of length retSet.size()
        // return "ret"

        // OR

        // create TreeSet of data called "dataSet"
        // initialize HashMap "counts"
        // convert "data" to ArrayList "dataList"
        // loop through elements in "dataSet"
            // get Collections.frequency(element, "dataSet")
            // store result in map where key is element and value is frequency
        // create List "mapEntries" <Map.Entry<Sting, Integer>> that receives ArrayList of "counts".entrySet()
        // sort "mapEntries" using .sort(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        // initialize arrayList "retList" of size of "dataSet"
        // loop through each element in "mapEntries" (of type Map.Entry<String, Integer>)
            // and add element.getKey() to "retList"
        // call Collections.sort() on "retList" to sort alphabetically
        // return retList as an Array

        // EXECUTION
        // create set of data called "dataSet"
        HashSet<String> dataSet = new HashSet<>(Arrays.asList(data));
        // initialize HashMap "counts"
        HashMap<String, Integer> counts = new HashMap<>();

        // loop through elements in "dataSet"
        for(String s : dataSet){
            // get Collections.frequency(element, "dataList")
            // store result in map where key is element and value is frequency
            counts.put(s, Collections.frequency(Arrays.asList(data), s));
        }
        //System.out.println(counts);

        // create List "mapEntries" <Map.Entry<Sting, Integer>> that receives ArrayList of "counts".entrySet()
        List<Map.Entry<String, Integer>> mapEntries = new ArrayList<>(counts.entrySet());
        // sort alphabetically
        mapEntries.sort(Map.Entry.comparingByKey(Comparator.naturalOrder()));
        // then sort "mapEntries" by frequency using .sort(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        mapEntries.sort( Map.Entry.comparingByValue(Comparator.reverseOrder()) );

        // initialize return ArrayList
        ArrayList<String> retList = new ArrayList<>();
        // loop through each element in "mapEntries" (of type Map.Entry<String, Integer>)
        for(Map.Entry<String, Integer> e : mapEntries){
            // and add element.getKey() to "ret"
            retList.add(e.getKey());
        }
        // return "retList" as Array
        //System.out.println(retList);
        return retList.toArray(new String[retList.size()]);

        // WOW I honetly have no idea what Comparator, comparing, etc. are gdoing..

    }

    /*public static void main(String[] args) {
       String[] data_ = {"cherry", "cherry", "cherry", "apple", "apple", "apple", "banana", "banana", "asparagus", "asparagus", "watermelon", "orange"};

       sort(data_);
    }*/
}