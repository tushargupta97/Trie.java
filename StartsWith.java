public class StartsWith {
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

    public static boolean startsWith(String prefix){
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr =curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        String words[]={"apple", "app", "mango", "man", "woman"};
        String prefix1="wo";
        String prefix2="moon";
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(startsWith(prefix1));
        System.out.println(startsWith(prefix2));
    }
}
