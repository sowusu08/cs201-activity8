import java.util.Arrays;
import java.util.Comparator;

public class LengthSort {
    public String[] /*static void*/ rearrange(String[] values){
        // you write code here and replace statement below
        //return null;

        //APPROACH
        // create local copy of "values" String array called "ret"
        // call Arrays.sort("ret", Comparator.comparing(...)) to sort by .length()
        // return ret

        // EXECUTION
        // create local copy of "values" String array called "ret"
        String ret[] = values;
        // sort alphabetically (natural order)
        Arrays.sort(ret);
        // then call Arrays.sort("ret", Comparator.comparing(...)) to sort by length
        Arrays.sort(ret, Comparator.comparing(String :: length));

        // return ret
        return ret;
        //System.out.println(Arrays.asList(ret));
    }

    /*public static void main(String[] args) {
        String[] values_ = {"cat", "bat", "flavor", "yellow", "easy", "code"};
        rearrange(values_);
    }*/
}