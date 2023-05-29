//2396. Strictly Palindromic Number

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2; i<=n-2; i++) {
            int num = n;
            int val1 = 0;
            while(num>0) {
                int rem = num%i;
                val1=val1*10+rem;
                num/=i;
            }
            int val2 = 0;
            int counter = 0;
            while(val1>0) {
                int rem = val1%10;
                val2 += rem*Math.pow(i,counter);
                counter++;
                val1/=10;
            }

            if(val2!=n) {
                return false;
            }
        }
        return true;
    }
}