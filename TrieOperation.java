public class TrieOperation{
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
    public static void main(String[] args) {
        String word[]={"the","a", "there", "their","any", "thee"};
        for(int i=0; i<word.length;i++){
            insert(word[i]);
        }
        System.out.println(search("thee"));
        System.out.println(search("thor"));
    }
}