class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return constructTreeFromArray(nums,0,nums.length-1);
    }
    public TreeNode constructTreeFromArray(int[] nums,int l,int r)
    {
        if(l>r) return null;
        int midpoint =l+(r-l)/2;
        TreeNode newnode=new TreeNode(nums[midpoint]);
        newnode.left=constructTreeFromArray(nums,l,midpoint-1);
         newnode.right=constructTreeFromArray(nums,midpoint+1,r);
        return newnode;
    }
}
