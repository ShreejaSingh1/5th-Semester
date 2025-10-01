class Solution {
    public int maximalRectangle(char[][] mat) {
        int[] arr=new int[mat[0].length];
        int maxArea=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]=='1'){
                    arr[j]+=1;
                }
                else{
                    arr[j]=0;
                }
            }
            int ar=max(arr);
            maxArea=Math.max(ar,maxArea);
        }
        return maxArea;
    }
    public int max(int[] arr) {
        int area=0;
        int len=arr.length;//taking 0 at the end
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=len;i++){
            int val=(i==len)?0:arr[i];
            while(!st.isEmpty() && val<arr[st.peek()]){
                int nsr=i;//next smaller on right
                int tbs=st.pop();//to be solved
                int nsl=st.isEmpty()?-1:st.peek();//next smaller element on left
                int wdt=nsr-nsl-1;
                area=Math.max(wdt*arr[tbs],area);
            }
            st.push(i);
        }
        return area;
    }
}






