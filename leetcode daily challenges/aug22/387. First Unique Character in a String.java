/*Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1**/

class Solution {
    public int firstUniqChar(String s) {
        //Iterates over the alphabet checking if the indexOf == lastIndexOf, which if true means there is only one.
       /* int ans=s.length();
        for(int i=0;i<ans;i++)
        {
            int findex=s.indexOf(s.charAt(i));
            if(findex!=-1 && findex==s.lastIndexOf(s.charAt(i)))
            {
                ans=Math.min(ans,findex);
            }
        }
        return ans == s.length() ? -1 : ans;  */
        
        //create arrayofalpha with0
        int[] arralpha=new int[26];
        
        for(char character:s.toCharArray())
        {
            arralpha[character-'a']+=1;
        }
        
        for(int i=0;i<s.length();i++)
        {
            if(arralpha[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
