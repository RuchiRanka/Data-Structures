//2160. Minimum Sum of Four Digit Number After Splitting Digits

class Solution {
    public int minimumSum(int num) {
        int ans[] = new int[4];
        for(int i=0; i<4; i++) {
            int rem = num%10;
            ans[i] = rem;
            num /= 10;
        }
        Arrays.sort(ans);
        int num1 = ans[0]*10 + ans[2];
        int num2 = ans[1]*10 + ans[3];
        return num1+num2;
    }
}