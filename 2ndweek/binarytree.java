import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree {
  private Node root;
  public BinaryTree(Node root) {
     this.root = root;
   }
   public Node getRoot() {
     return root;
   }
   public void BFS(Node root){
     Queue<Node> que = new LinkedList<>();
     que.offer(root);
     while(!que.isEmpty()) {
       Node node = que.poll();
        System.out.print(node.getValue()+" ");
        if(node.getLeft() != null)
        que.offer(node.getLeft());
        if(node.getRight() != null)
        que.offer(node.getRight());
      }
      System.out.println();
    }
    public void DFS(Node root) {
       if(root == null) return;
        DFS(root.getLeft());
        System.out.print(root.getValue()+" ");
        DFS(root.getRight()); }
      }
