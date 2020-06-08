/**************************************************************
 Purpose/Description: This program contains a binary search tree with
                        several methods, according to Problem 3's
                        problem statement.
 Author’s Panther ID: 6131735
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/

/* PART E
    Considering a leaf l, a path p of l, the sets A, B, and C, given any element a in A, b in B,
    c in C, a <= b <= c. At any node b in B, a subtree can be created where the left branch can
    include a subset of A, and a right branch which will include a subset of C (any node in the
    branch, if in B, is not part of the subset). The union of all of the left subsets is equal to
    the set A, while the union of all of the right subsets is equal to set C. Take any node in
    path p (excluding the root), that node will either be in a right or left branch of the preceding
    node, meaning that it inherits one of the branches of the previous node (excluding itself), and
    inherits the same inequality to the opposite branch of the previous node (ie if the parent node
    has a left branch (everything in it being less than the parent node), and the current node is part
    of the right branch of that parent node, than the current node is also more than anything in the
    parent node's left branch). This rule can be applied all the way down path p, proving that the above
    statement that a <= b <= c stands true.
 */
package assignment2;

class BinarySearchTreeNode {
    public int key;
    public BinarySearchTreeNode parent;
    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;

    public BinarySearchTreeNode(int key, BinarySearchTreeNode parent) {
        this.key = key;
        this.parent = parent;
    }
}

class BinarySearchTree {
    public BinarySearchTreeNode root;

    public  BinarySearchTree(BinarySearchTreeNode root) {
        this.root = root;
    }

    public void insert(int key) {
        BinarySearchTreeNode node = root;
        while(node.key!=key) {
            if(node.key>key) {
                if(node.left==null) {
                    node.left = new BinarySearchTreeNode(key, node);
                    break;
                } else node = node.left;
            } else {
                if(node.right==null) {
                    node.right = new BinarySearchTreeNode(key, node);
                    break;
                } else node = node.right;
            }
        }
    }

    public void delete(int key) {
        BinarySearchTreeNode node = root;
        boolean left = true;

        while(true) {
            if(node.key==key) {
                // no children
                if(node.left==null && node.right == null) {
                    if(left) node.parent.left = null;
                    else node.parent.right = null;
                }

                // only one child
                else if(node.left!=null ^ node.right!=null) {
                    BinarySearchTreeNode temp;

                    if(node.left!=null) temp = node.left;
                    else temp = node.right;

                    if(left) node.parent.left = temp;
                    else node.parent.right = temp;

                    temp.parent = node.parent;
                }

                // two children
                else {
                    //find the max in left branch
                    BinarySearchTreeNode temp = node.left;
                    while(true) {
                        if(temp.right!=null) temp = temp.right;
                        else if(temp.left!=null) temp = temp.left;
                        else break;
                    }

                    int tempKey = temp.key;
                    delete(tempKey);

                    node.key = tempKey;
                } break;

            } else if(node.key>key) {
                if(node.left==null) {
                    System.out.println("Couldn't Find");
                    break;
                } else {
                    node = node.left;
                    left = true;
                }
            } else {
                if(node.right==null) {
                    System.out.println("Couldn't Find");
                    break;
                } else {
                    node = node.right;
                    left = false;
                }
            }
        }
        System.out.println("Deleted");
    }

    public boolean find(int key) {
        BinarySearchTreeNode node = root;
        while(node.key!=key) {
            if(node.key<key) {
                if(node.left==null) return false;
                else node = node.left;
            } else {
                if(node.right==null) return false;
                else node = node.right;
            }
        }
        return true;
    }

    public int keySum(BinarySearchTreeNode node) {
        if(node == null)
            return 0;

        return keySum(node.left) + keySum(node.right) + node.key;
    }

    public void deleteMin() {
        BinarySearchTreeNode node = root;
        while(node.left!=null) {
            node = node.left;
        }

        if(node==root) {
            root = node.right;
            root.parent = null;
        }

        else node.parent.left = null;
    }

    public void printTree(BinarySearchTreeNode node) {
        if(node == null)
            return;

        printTree(node.left);
        System.out.print(node.key + " ");
        printTree(node.right);
    }

    public void printPostOrder(BinarySearchTreeNode node) {
        if(node == null)
            return;

        printTree(node.left);
        printTree(node.right);
        System.out.print(node.key + " ");
    }
}

public class Problem3 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(new BinarySearchTreeNode(10, null));

        tree.insert(10);
        tree.insert(99);
        tree.insert(11);
        tree.insert(100);

        //tree.printPostOrder(tree.root);
        System.out.println(tree.keySum(tree.root));

    }
}