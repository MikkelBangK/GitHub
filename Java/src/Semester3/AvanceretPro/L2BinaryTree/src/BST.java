public class BST<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected java.util.Comparator<E> c;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    /** Returns true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                found = true; // Element is found
        }

        return found;
    }
    public TreeNode<E> searchNode(E e) {
        TreeNode<E> current = root; // Start from the root

        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                found = true; // Element is found
        }
        if(found) {
            return current;
        }else {
            return null;
        }
    }

    @Override
    /** Insert element e into the binary tree
     * Return true if the element is inserted successfully */
    public boolean insert(E e) {
        boolean inserted = true;
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null && inserted)
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    inserted = false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return inserted; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }




    @Override
    /** Postorder traversal from the root */
    public String preorder() {
        return preOrderPrint(root);
    }


    public String preOrderPrint(TreeNode<E> node){
        String print = "";
        if(node != null){
            print += " " + node.element;
            print += preOrderPrint(node.left) ;
            print += preOrderPrint(node.right);
        }
        return print;
    }

    @Override
    /** Inorder traversal from the node */
    public String inorder(){
        return inOrderPrint(root);
    }
    public String inOrderPrint(TreeNode<E> node){
        String print = "";
        if(node != null){
            print += inOrderPrint(node.left) ;
            print += node.element;
            print += " " +  inOrderPrint(node.right);
        }
        return print;
    }



    @Override
    /** Preorder traversal from the root */
    public String postorder() {
        return postOrderPrint(root);
    }
    public String postOrderPrint(TreeNode<E> node){
        String print = "";
        if(node != null){
            print += postOrderPrint(node.left) ;
            print += postOrderPrint(node.right);
            print += " " + node.element;
        }
        return print;
    }
    @Override
    public boolean isLeaf(E e){
        TreeNode<E> foundNode = searchNode(e);
        if (foundNode.left == null || foundNode.right == null) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public boolean isInternal(E e) {
        TreeNode<E> foundNode = searchNode(e);
        if (foundNode.left == null || foundNode.right == null) {
            return true;
        } else {
            return false;
        }
    }
    public int treeHeight(TreeNode<E> node){
        if (node == null) {
            return 0;
        }
        int leftHeight = treeHeight(node.left);
        int rightHeight = treeHeight(node.right);

        if (leftHeight < rightHeight){
            return 1 + rightHeight;
        } else {
            return 1 + leftHeight;
        }
    }
    @Override
    public int height() {
     return treeHeight(root) - 1;
    }
    @Override
    public int sum() {
       return beregnSum(root);
    }
    public int beregnSum(TreeNode<E> node){
        if( node == null){
            return 0;
        }
        int leftSum =+ beregnSum(node.left);
        int rightSum =+ beregnSum(node.right);

        return ((int) node.element) + leftSum + rightSum;
    }
    @Override
    public E findMax(){
        if (root == null){
            return null;
        }
        TreeNode<E> current = root;
        while (current.right != null){
            current = current.right;
        }
        return current.element;
    }
    @Override
    public E findMin(){
        if (root == null){
            return null;
        }
        TreeNode<E> current = root;
        while (current.left != null){
            current = current.left;
        }
        return current.element;
    }
    public void removeMin(){
        TreeNode<E> current = null;
        TreeNode<E> temp = root;
        while (temp.left != null){
            if (temp.left == null){
                current = temp;
            } else {
                temp = temp.left;
            }
        }

    }
    public void removeMax(){
        TreeNode<E> current = root;
        while (current.right != null){
            current = current.right;
        }

    }
    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override
    /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }


    @Override
    /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                found = true; // Element is in the tree pointed at by current
        }

        if (found) {
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (c.compare(e, parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }

//
    //-------------------------------------------------------------------



}
