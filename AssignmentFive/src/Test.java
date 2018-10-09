public class Test 
{
    public static void main(String[] args) 
    {

        String slist[] = new String[] 
        		{ 
                // Path of the folders
                "/Users/jonathanboyd/Desktop/A/B/D",
                "/Users/jonathanboyd/Desktop/A/C",
                
        };
        		// Creates tree
        Tree tree = new Tree(new Node("root", "root"));
        for (String data : slist) {
            tree.addElement(data);
        }
        		// Prints Tree
        tree.printTree();
    }

}