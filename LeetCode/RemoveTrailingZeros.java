//2710. Remove Trailing Zeros From a String

class Solution {
    public String removeTrailingZeros(String num) {
        StringBuilder str = new StringBuilder(num);
        for(int i=0; i<str.length(); i++) {
            int j = i;
            while(i<str.length() && str.charAt(i)=='0') {
                if(i==str.length()-1) {
                    str.delete(j,i+1);
                    return str.toString();
                }
                i++;
            }
        }
        return str.toString();
    }
}