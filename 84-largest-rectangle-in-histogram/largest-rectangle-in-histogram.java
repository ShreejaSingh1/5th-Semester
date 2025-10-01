class Solution {
    public int largestRectangleArea(int[] arr) {
        int area=0;
        int len=arr.length;//taking 0 at the end
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=len;i++){
            int val=(i==len)?0:arr[i];
            while(!st.isEmpty() && val<arr[st.peek()]){
                int nsr=i;
                int tbs=st.pop();
                int nsl=st.isEmpty()?-1:st.peek();
                int wdt=nsr-nsl-1;
                area=Math.max(wdt*arr[tbs],area);
            }
            st.push(i);
        }
        return area;
    }
}































// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         return Largest_Histogram(heights);
//     }
// 	public static int Largest_Histogram(int [] arr) {
// 		Stack<Integer> st=new Stack<>();
// 		int ans=0;
// 		for(int i=0;i<arr.length;i++) {
// 			while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
// 				int h=arr[st.pop()];
// 				int r=i;
// 				if(st.isEmpty()) {
// 					ans=Math.max(h*r, ans);
// 				}
// 				else {
// 					int l=st.peek();
// 					int area=h*(r-l-1);
// 					ans=Math.max(area, ans);
// 				}
// 			}
// 			st.push(i);
// 		}
// 		int r=arr.length;
// 		while(!st.isEmpty()) {
// 			int h=arr[st.pop()];
// 			if(st.isEmpty()) {
// 				ans=Math.max(h*r, ans);
// 			}
// 			else {
// 				int l=st.peek();
// 				int area=h*(r-l-1);
// 				ans=Math.max(area, ans);
// 			}
// 		}
// 		return ans;
// 	}
// }
