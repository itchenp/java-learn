package com.ithub.source.learn;

public class BSTreeTest {
    public static BSTree<Integer> newTree() {
        int[] array = new int[]{50, 30, 80};
        BSTree<Integer> tree = new BSTree<>();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        return tree;
    }

    public static void main(String[] args) {
        BSTree<Integer> tree = newTree();
        System.out.println("----------初始--------");
        print(tree);
//        tree.preOrder();
//        System.out.println();
//        tree.inOrder();
//        System.out.println();
//        tree.postOrder();
//        System.out.println();



        tree.delete(20);
        System.out.println("----------删除 20--------");
        print(tree);
//        tree = newTree();
//        tree.delete(70);
//        System.out.println("----------删除 70--------");
//        print(tree);
//        tree = newTree();
//        tree.delete(30);
//        System.out.println("----------删除 30--------");
//        print(tree);
    }


    //------------下面代码是用于输出树的工具代码------------------------

    public static final String  PREFIX_BRANCH = "├";//树枝
    public static final String  PREFIX_TRUNK  = "│ ";//树干
    public static final String  PREFIX_LEAF   = "└";//叶子
    public static final String  PREFIX_EMP    = "  ";//空
    public static final String  PREFIX_LEFT   = "─L─";//左
    public static final String  PREFIX_RIGTH  = "─R─";//右

    private static boolean hasChild(BSTree.BSTNode node){
        return node.left != null || node.right != null;
    }

    public static void print(BSTree tree){
        if(tree != null && tree.mRoot != null){
            System.out.println(tree.mRoot.key);
            print(tree.mRoot, "");
        }
    }

    public static void print(BSTree.BSTNode node, String prefix){
        if(prefix == null){
            prefix = "";
        } else {
            prefix = prefix.replace(PREFIX_BRANCH, PREFIX_TRUNK);
            prefix = prefix.replace(PREFIX_LEAF, PREFIX_EMP);
        }
        if(hasChild(node)){
            if(node.right != null){
                System.out.println(prefix + PREFIX_BRANCH + PREFIX_RIGTH + node.right.key);
                if(hasChild(node.right)){
                    print(node.right, prefix + PREFIX_BRANCH);
                }
            } else {
                System.out.println(prefix + PREFIX_BRANCH + PREFIX_RIGTH);
            }

            if(node.left != null){
                System.out.println(prefix + PREFIX_LEAF + PREFIX_LEFT + node.left.key);
                if(hasChild(node.left)){
                    print(node.left, prefix + PREFIX_LEAF);
                }
            } else {
                System.out.println(prefix + PREFIX_LEAF + PREFIX_LEFT);
            }
        }
    }
}
