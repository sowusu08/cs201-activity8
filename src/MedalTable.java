import java.util.*;

public class MedalTable {

    // Approach Part 1
    // EXECUTION Part 1
    // create class Country
    // with public instance variables myName, myGold, myBronze, mySilver

    // write constructor where myGold, myBronze, mySilver set to 0 each and myName set to
    // variable passed to constructor

    // write method init() which is passed country name (String) and country counts (arrayList)
    // inits myName to country name; and myGold,... to counts in arrayList


    // write method getString() which is passed a country name
    // returns String this.myName+" "+this.myGold" "+" "+this.mySilver" "+" "+this.myBronze;

    // Ignore---------
    // write method updateCount which is passed a string of country names
    // splits string into String array "countries"
    // loops through each string (country name) in "countries"
    // creates Country object where my
    //--------

    // write .getName() method
    // returns this.myName

    // write .getGold() method
    // returns this.myGold

    // write .getSilver() method
    // returns this.mySilver

    // write .getBronze() method
    // returns this.myBronze


    // EXECUTION Part 1
    // create class Country
    public class Country {

    // with public instance variables myName, myGold, myBronze, mySilver
        public String myName;
        public int myGold;
        public int mySilver;
        public int myBronze;

    // write constructor where myGold, myBronze, mySilver set to 0 each and myName set to
    // variable passed to constructor
        public Country(String name){
            myName = name;
            myGold = 0;
            mySilver = 0;
            myBronze = 0;
        }

    // write method init() which is called on country name (String) and country counts (arrayList)
        public void init(ArrayList<Integer> counts){
            // inits myName to country name; and myGold,... to counts in arrayList
            this.myGold += counts.get(0);
            this.mySilver += counts.get(1);
            this.myBronze += counts.get(2);
        }

    // write method getString() called on a country object
        public String getString() {
            // returns String this.myName+" "+this.myGold" "+" "+this.mySilver" "+" "+this.myBronze;
            String s = this.myName+" "+Integer.toString(this.myGold)+" "+Integer.toString(this.mySilver)+" "+Integer.toString(this.myBronze);
            return s;
        }

    // write .getName() method
        public String getName() {
            // returns this.myName
            return this.myName;
        }

    // write .getGold() method
        public int getGold() {
            // returns this.myGold
        return this.myGold;
        }


    // write .getSilver() method
        public int getSilver() {
            // returns this.mySilver
            return this.mySilver;
        }


    // write .getBronze() method
        public int getBronze() {
            // returns this.myBronze
            return this.myBronze;
        }

}

    public String[] generate(String[] results) {
        // create HashMap<String, ArrayList<Integer>> "tally"
        HashMap<String, ArrayList<Integer>> tally = new HashMap<>();

        // loop through each element in results
        for(String r : results){
            // split element into array of Strings "split"
            String[] split = r.split(" ");
            // loop through elements in "split" (using index "k" for loop)
            for(int k=0; k< split.length; k++) {
                // put if absent the element as a key in "tally" map with a value equal to empty arrayList
                tally.putIfAbsent(split[k], new ArrayList<Integer>(Collections.nCopies(3, 0)));     // looked up Collections.nCopies
                // set "temp" to value at the key in "tally" (ArrayList)
                ArrayList<Integer> temp = tally.get(split[k]);
                // temp.add(k, temp.get(k) + 1) to update count
                temp.add(k, temp.get(k) + 1);
                // "tally".put(element, temp) to put updated arrayList at element in "tally" map
                tally.put(split[k], temp);
            }
        }
        // initialize empty ArrayList "countryList"
        ArrayList<Country> countryList = new ArrayList<>();

        // loop through key set of "tally"
        for(String key : tally.keySet()){
            // for each country
                // create a Country object
            Country country = new Country(key);
                // call init(myName=key, myGold = map.get(key)[0], mySilver = map.get(key)[1], ...)
            country.init(tally.get(key));
                // add the Country object to "countryList"
            countryList.add(country);
        }

        // sort countryList using countryList.sort(
        // Comparator.comparing(Country::getGold()).reversed().thenComparing(Country::getSilver()).reversed().thenComparing(Country::getBronze).reversed().thenComparing(Country::getName);
        // )
        Collections.sort(countryList, Comparator.comparing(Country::getGold).reversed().thenComparing(Country::getSilver).reversed().thenComparing(Country::getBronze).reversed().thenComparing(Country::getName));


        // init String ArrayList "retList"
        ArrayList<String> retList = new ArrayList<>();
        // loop through each element "countryList"
        for(Country c : countryList) {
            // call .getString() on the element and add to "retList"
            retList.add(c.getString());
        }
        // return retList as an Array
        //System.out.println(retList);
        return retList.toArray(new String[retList.size()]);
    }

    /*public static void main(String[] args) {
        String[] results_ = {"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"};

        generate(results_);
    }*/


}