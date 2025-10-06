class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
		List<String> ll=new ArrayList<>();
		palin(s,ll,ans);
		return ans;
        }
	
	public static void palin(String ques,List<String> ll,List<List<String>> ans) {
		if(ques.length()==0) {
			ans.add(new ArrayList(ll));
			return;
		}
		
		for(int cut=1;cut<=ques.length();cut++) {
			String s=ques.substring(0,cut);
			if(palindrome(s)) {
				ll.add(s);
				palin(ques.substring(cut),ll,ans);
				ll.remove(ll.size()-1);
			}
		}
	}
	
	public static boolean palindrome(String s1) {
		int i=0;
		int j=s1.length()-1;
		while(i<=j) {
			if(s1.charAt(i)!=s1.charAt(j)) {
				return false;
				
			}
			i++;
			j--;
		}
		return true;
	}
}

