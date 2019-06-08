import java.util.HashMap;

public class Factory {


    private static final HashMap TreeMap = new HashMap();

    public static Shape getTree(String color) {
        Tree tree = (Tree) TreeMap.get(color);

        if(tree == null) {
            tree = new Tree(color);
            TreeMap.put(color, tree);
            System.out.println("Creating a Tree of color : " + color);
        }
        return tree;
    }
}