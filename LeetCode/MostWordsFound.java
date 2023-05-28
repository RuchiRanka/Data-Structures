//2114. Maximum Number of Words Found in Sentences

class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(int i=0; i<sentences.length; i++) {
            int count = 0;
            for(int j=0; j<sentences[i].length(); j++) {
                if(sentences[i].charAt(j)==' ') {
                    count++;
                }
                if(j==sentences[i].length()-1) {
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
}