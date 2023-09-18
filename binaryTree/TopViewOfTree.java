import java.util.*;

public class TopViewOfTree{
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    static class Info{
        Node node;
        int hd;//horizontal distance

        public Info(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    static int idx=-1;

    public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode=new Node(nodes[idx]);
        newNode.left=buildTree(nodes);
        newNode.right=buildTree(nodes);
        

        return newNode;
    }

    public static void topView(Node root){
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();

        int min=0,max=0;
        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }

                if(curr.node.left !=null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }

                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }

            }
        }

        while(min <= max){
            System.out.print(map.get(min).data+" ");
            min++;
        }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        // int nodes[]={1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};
        Node root=buildTree(nodes);

        topView(root);
    }
}