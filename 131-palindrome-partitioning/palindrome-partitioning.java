// class Solution {
//     public List<List<String>> partition(String s) {
//         List<List<String>> ans=new ArrayList<>();
// 		List<String> ll=new ArrayList<>();
// 		palin(s,ll,ans);
// 		return ans;
//         }
	
// 	public static void palin(String ques,List<String> ll,List<List<String>> ans) {
// 		if(ques.length()==0) {
// 			ans.add(new ArrayList(ll));
// 			return;
// 		}
		
// 		for(int cut=1;cut<=ques.length();cut++) {
// 			String s=ques.substring(0,cut);
// 			if(palindrome(s)) {
// 				ll.add(s);
// 				palin(ques.substring(cut),ll,ans);
// 				ll.remove(ll.size()-1);
// 			}
// 		}
// 	}
	
// 	public static boolean palindrome(String s1) {
// 		int i=0;
// 		int j=s1.length()-1;
// 		while(i<=j) {
// 			if(s1.charAt(i)!=s1.charAt(j)) {
// 				return false;
				
// 			}
// 			i++;
// 			j--;
// 		}
// 		return true;
// 	}
// }




public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        // If we've reached the end of the string, add the current partition to the result list
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Explore all possible partitions
        for (int end = start + 1; end <= s.length(); end++) {
            // If the current substring is a palindrome, add it to the current path
            if (isPalindrome(s, start, end - 1)) {
                path.add(s.substring(start, end));
                // Recur to find other partitions
                backtrack(s, end, path, result);
                // Backtrack to explore other partitions
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        // Check if the substring s[left:right+1] is a palindrome
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}