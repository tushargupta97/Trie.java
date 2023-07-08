public class CountUniqueSubstring {
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

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int count =0;
        for(int i=0; i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        String str="ababa"; //ans=10

        for(int i=0; i<str.length();i++){
            String suffix=str.substring(i);
            insert(suffix);
        }
        System.out.println(countNodes(root));
        
    }
}
