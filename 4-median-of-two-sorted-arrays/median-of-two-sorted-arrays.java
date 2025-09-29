class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {

        if(a.length>b.length){
            int[] temp=a;
            a=b;
            b=temp;
        }
        int lo=0;
        int hi=a.length;
        int total=(a.length+b.length);
        int hf=(total+1)/2;

        while(lo<=hi){
            int al=(lo+hi)/2;
            int bl=hf-al;
            int alm1=(al==0)?Integer.MIN_VALUE:a[al-1];
            int aleft=(al==a.length)?Integer.MAX_VALUE:a[al];
            int blm1=(bl==0)?Integer.MIN_VALUE:b[bl-1];
            int bleft=(bl==b.length)?Integer.MAX_VALUE:b[bl];


            if(alm1<=bleft && blm1<=aleft){
                double ans;
                if(total%2==0){
                    ans=(Math.max(alm1,blm1)+Math.min(aleft,bleft))/2.0;
                }
                else{
                    ans=Math.max(alm1,blm1)/1.0;
                }
                return ans;
            }
            else if(alm1>bleft){
                hi=al-1;
            }
            else {
                lo=al+1;
            }
        }
        return 0.0;
    }
}