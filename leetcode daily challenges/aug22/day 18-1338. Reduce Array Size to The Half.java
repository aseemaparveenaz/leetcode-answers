/*You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

 

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.*/

class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int num:arr)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        /*getOrDefault() Return Value
returns the value to which the specified key is associated
returns the specified defaultValue if the mapping for specified key is not found
Example: Java HashMap getOrDefault()
        HashMap<Integer, String> numbers = new HashMap<>();

        // insert entries to the HashMap
        numbers.put(1, "Java");
        numbers.put(2, "Python");
        numbers.put(3, "JavaScript");
        System.out.println("HashMap: " + numbers);

        // mapping for the key is present in HashMap
        String value1 = numbers.getOrDefault(1, "Not Found");
        System.out.println("Value for key 1:  " + value1);// java

        // mapping for the key is not present in HashMap
        String value2 = numbers.getOrDefault(4, "Not Found");
        System.out.println("Value for key 4: " + value2);//notfounf*/

        List<Integer> freq=new ArrayList<>(map.values());
        Collections.sort(freq,Collections.reverseOrder());// 4 3 2 1 indesc order
        
        int totalelement=arr.length;
        int arrfixedsize=totalelement;
        int i=0,anscount=0;
        while(totalelement>arrfixedsize/2) //till it gets decreses
        {
            totalelement=totalelement-freq.get(i);
            i++;
            anscount++; // ereturn the no of times it has got deleted action made
        }
        return anscount;
    }
}
