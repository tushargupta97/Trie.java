public class LongestWordWithAllPrefix {
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

    public static String ans="";
    public static void longestWord(Node root,StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0; i<26;i++){//lexicoGraphically smaller, reverse the loop for if we need lexicographically larger
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);//backtrack
            }
        }
    }
    public static void main(String[] args) {
        String words[]={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
