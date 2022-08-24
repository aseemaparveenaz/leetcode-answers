/*Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

 

Example 1:

Input: n = 27
Output: true
Example 2:

Input: n = 0
Output: false
Example 3:

Input: n = 9
Output: true */

//27/3-----9/3-------3/3--------1 //n becomes 1 when end reaches
//10/3-----1 //n%3!=0 there becomes false
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n>0){
        while(n>=3)
        {
             if(n%3!=0)
                return false;
             n=n/3;
        }
         return n==1?true:false;
        }
        return false;
    }
}
