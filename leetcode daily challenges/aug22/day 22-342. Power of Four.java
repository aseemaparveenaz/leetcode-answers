/* Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true */

class Solution {
    /* 1st approach--------------
    1) (num&(num-1))==0  to check the number is 2 power k ex:16 2 power 4
    2&2-1 is 0 while we do in bits
     2) 1,4, 16 are %3==1 so both condition should satisfy*/
    public boolean isPowerOfFour(int num) {
     /*1st spprach
     if(num>0)
     {
        if((num&(num-1))==0 && (num%3==1))
            return true;
         else
             return false;
     }
    else
        return false;*/
        
     //2nd apprach------------------
     // 16/4----4/4--1 until it comes 1 divide if one comes true else not
     if(num>0){
        while(num>=4)
        {
             if(num%4!=0)
                return false;
             num=num/4;
        }
         return num==1?true:false;
        }
        return false;
     
     
    }
}
