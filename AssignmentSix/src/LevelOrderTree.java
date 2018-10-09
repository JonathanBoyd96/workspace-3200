import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTree 			// Contains work for both 4.41 and 4.46
{										// The runtime of the method is O(N)

public void printLevels(Node root, int h)
{
if(root==null) return;
if(h==1) System.out.print(" " + root.data);
else{
 		printLevels(root.left,h-1);
 		printLevels(root.right,h-1);
 	} 	
}

public int height(Node root)
{
if (root==null) return 0;
return 1 + Math.max(height(root.left),height(root.right));
}

public void levelOrderPrint(Node root)
{
	Queue q = new LinkedList();
	int levelNodes =0; 
	if(root==null) return;
 		q.add(root);
 	while(!q.isEmpty())
 	{
 		levelNodes = q.size();
 		while(levelNodes>0)
 			{
 				Node n = (Node)q.remove();
 				System.out.print(" " + n.data);
 				if(n.left!=null) q.add(n.left);
 				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
 		System.out.println("");
 	}
}

static class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
  
public static class BTree 
{
    Node root, root2;

    boolean similarTrees(Node a, Node b) 
    {
        if (a == null && b == null)
            return true;
             
        if (a != null && b != null) 
            return (a.data == b.data
                    && similarTrees(a.left, b.left)
                    && similarTrees(a.right, b.right));
  
        return false;
    }
}

public static void main (String[] args) throws java.lang.Exception
	{
	LevelOrderTree i  = new LevelOrderTree();
	BTree tree = new BTree();
	
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(" Level order outprint : ");
		i.levelOrderPrint(root);						// Print by level-order depth
		System.out.println();
		
		
		// Creates another tree to test and see if they are similar
        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);
        tree.root2.right.left = new Node(6);
        //tree.root2.right.right = new Node(7); 		// Remove comment lines to make trees similar
        i.levelOrderPrint(tree.root2);
        System.out.println();
  
        if (tree.similarTrees(root, tree.root2))
            System.out.println("Trees are similar");
        else
            System.out.println("Trees are not similar");
	}
}