public class WordBreak {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false; //end of word
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root=new Node();

    public static void insert(String word){ //fuction to insert //O(L){L=length of largest word}
        Node curr= root;
        for(int lvl=0; lvl<word.length();lvl++){
            int idx=word.charAt(lvl)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static boolean search(String key){
        Node curr= root;
        for(int lvl=0; lvl<key.length();lvl++){
            int idx=key.charAt(lvl)-'a';
            if(curr.children[idx]==null){
               return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }

    public static boolean wordBreak(String key){ //looped recursive function
        if(key.length()==0){
            return true;
        }
        for(int i=1; i<=key.length();i++){
            if(search(key.substring(0,i))&& wordBreak(key.substring(i))){//substring(i)=starting letter(i) and ending letter last index
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String words[]={"i","like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<words.length;i++){
            insert(words[i]);
        }

        String key="ilikemobile";
        System.out.println(wordBreak(key));
    }
}
/*
Here's how the code works:

1.The function 'wordBreak' takes a 'String' parameter called 'key', which represents the string to be checked if it can be broken down into valid words.

2.The first conditional statement checks if the length of key is zero. If it is, it means that the string has been completely broken down into valid words, so the function returns true.

3.If the length of key is not zero, the code proceeds to a for loop that iterates from i = 1 to i <= key.length(). This loop represents the possible positions where the key string can be split.

4.Inside the loop, the code checks two conditions. First, it calls a search function, passing a substring of key from index 0 to i (exclusive). This search function is expected to check if the substring is a valid word. If the substring is a valid word, the code proceeds to the second condition.

5.The second condition is a recursive call to the wordBreak function, passing a substring of key from index i to the end of the string. This recursive call checks if the remaining part of the string can be broken down into valid words.

6.If both conditions are true, it means that the current split position at index i results in a valid word combination. In this case, the function returns true to indicate that the key string can be broken down into valid words.

7.If the loop finishes without finding a valid word combination, the function reaches the end and returns false to indicate that the key string cannot be broken down into valid words.
 */