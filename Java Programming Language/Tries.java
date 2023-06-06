public class Tries {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq = 1;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i]=null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null) {
                curr.children[ch-'a'] = new Node();
            }
            else {
                curr.freq++;
            }
            curr = curr.children[ch-'a'];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for(int i=0; i<key.length(); i++) {
            int idx = key.charAt(i)-'a';
            if(curr.children[idx]==null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public static boolean wordBreak(String key) {
        if(key.length()==0) {
            return true;
        }
        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void prefix(String ans[]) {

    }

    public static void main(String[] args) {
        // String words[] = {"the","a","there","any","their","thee"};
        // for(int i=0; i<words.length; i++) {
        //     insert(words[i]);
        // }
        // System.out.println(search("thee"));
        // System.out.println(search("thor"));
        // System.out.println(search("th"));

        // String words[] = {"i","like","sam","samsung","mobile","ice"};
        // for(int i=0; i<words.length; i++) {
        //     insert(words[i]);
        // }
        // String key = "icelikesamsung";
        // System.out.println(wordBreak(key));

        String arr[] = {"zebra","dog","duck","dove"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }
        String ans[] = new String[arr.length];
        prefix(ans);

    }
}
