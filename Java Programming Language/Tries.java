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
                curr.children[ch-'a'].freq++;
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

    public static void prefix(String arr[], String ans[]) {
        for(int i=0; i<arr.length; i++) {
            Node curr = root;
            ans[i]="";
            for(int j=0; j<arr[i].length(); j++) {
                int idx = arr[i].charAt(j) - 'a';
                ans[i] += arr[i].charAt(j);
                if(curr.children[idx].freq == 1) {
                    break;
                }
                curr = curr.children[idx];
            }
        }
    }

    public static void getPrefix(Node root, String ans) {
        if(root==null) {
            return;
        }

        if(root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for(int i=0; i<root.children.length; i++) {
            if(root.children[i] != null) {
                getPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx]==null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countNodes(Node root, int count) {
        for(int i=0; i<root.children.length; i++) {
            if(root.children[i] != null) {
                count = countNodes(root.children[i], count+1);
            }
        }
        return count;
    }

    public static int uniqueSubstr(String str) {
        for(int i=0; i<str.length(); i++) {
            String substr = str.substring(i, str.length());
            insert(substr);
        }
        
        return countNodes(root, 0)+1;
    }

    static String longestString = "";
    public static String longestPrefix(Node root, String str) {
        if(longestString.length() < str.length()) {
            longestString = str;
        }
        for(int i=0; i<root.children.length; i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                longestPrefix(root.children[i], str+(char)(i+'a'));                
            }
        }
        return longestString;
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

        // String arr[] = {"zebra","dog","duck","dove"};
        // for(int i=0; i<arr.length; i++) {
        //     insert(arr[i]);
        // }
        // String ans[] = new String[arr.length];
        // prefix(arr, ans);
        // for(int i=0; i<ans.length; i++) {
        //     System.out.println(ans[i]);
        // }

        // root.freq = -1;
        // getPrefix(root, "");

        // String words[] = {"apple","app","mango","man","woman"};
        // for(int i=0; i<words.length; i++) {
        //     insert(words[i]);
        // }
        // String prefix = "app";
        // System.out.println(startsWith(prefix));

        // String str = "apple";
        // System.out.println(uniqueSubstr(str));

        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        System.out.println(longestPrefix(root,""));
    }
}
