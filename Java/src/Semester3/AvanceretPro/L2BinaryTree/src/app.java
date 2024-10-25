public class app {
    public static void main(String[] args) {

        Tree tree = new BST();
        tree.insert(45);
        tree.insert(22);
        tree.insert(11);
        tree.insert(15);
        tree.insert(30);
        tree.insert(25);
        tree.insert(77);
        tree.insert(90);
        tree.insert(88);

        //Opgave 1
        System.out.println("Opgave 1: ");
        System.out.println("\nPreorder: ");
        tree.preorder();
        System.out.println(tree.preorder());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\nInorder: ");
        tree.inorder();
        System.out.println(tree.inorder());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\nPostorder: ");
        tree.postorder();
        System.out.println(tree.postorder());
        System.out.println("\n");
        //Opgave 2
        System.out.println("Opgave 2: ");
        System.out.println(tree.isInternal(11));
        System.out.println(tree.isLeaf(11));
        tree.height();
        System.out.println(tree.height());
        System.out.println("\n");

        //Opgave 3
        System.out.println("Opgave 3: ");
        tree.sum();
        System.out.println(tree.sum());
        System.out.println("\n");

        //Opgave 4
        System.out.println("Opgave 4: ");
        tree.findMax();
        System.out.println(tree.findMax());
        tree.findMin();
        System.out.println(tree.findMin());
    }
}
