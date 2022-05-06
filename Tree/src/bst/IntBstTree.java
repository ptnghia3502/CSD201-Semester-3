/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author Nghia
 */
public class IntBstTree {

    IntBstNode root;
    protected int numOfNodes = 0;

    public IntBstTree() {
        root = null;
    }

    public int size() {
        return numOfNodes;
    }

    public boolean empty() {
        return root == null;
    }

    public boolean add(int x) {
        IntBstNode newNode = new IntBstNode(x);
        if (root == null) {
            root = newNode;
        } else {
            IntBstNode pFather = null, pBefore = root;
            while (pBefore != null && pBefore.key != x) {
                pFather = pBefore;
                if (x < pBefore.key) {
                    pBefore = pBefore.left;
                } else {
                    pBefore = pBefore.right;
                }
            }
            if (pBefore != null) {
                return false;
            }
            if (x < pFather.key) {
                pFather.left = newNode;
            } else {
                pFather.right = newNode;
            }
            newNode.father = pFather;
        }
        numOfNodes++;
        return true;
    }

    public void add(int... a) {
        for (int x : a) {
            this.add(x);
        }
    }

    public IntBstNode search(int x) {
        IntBstNode result = root;
        while (result != null) {
            if (x == result.key) {
                return result;
            } else if (x < result.key) {
                result = result.left;
            } else {
                result = result.right;
            }
        }
        return null;
    }

    public int getMin() {
        if (root == null) {
            throw new RuntimeException("Empty tree!");
        }
        IntBstNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.key;
    }

    public int getMax() {
        if (root == null) {
            throw new RuntimeException("Empty tree!");
        }
        IntBstNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p.key;
    }

    public int getHeight() {
        class Node_Level {

            IntBstNode node;
            int level;

            Node_Level(IntBstNode p, int L) {
                node = p;
                level = L;
            }
        }
        if (root == null) {
            return 0;
        }
        LinkedList<Node_Level> q = new LinkedList();
        Node_Level v;
        int maxLevel = 0;
        q.add(new Node_Level(root, 1));
        while (!q.isEmpty()) {
            v = q.removeFirst();
            int curL = v.level;
            if (maxLevel < curL) {
                maxLevel = curL;
            }
            IntBstNode left = v.node.left;
            IntBstNode right = v.node.right;
            if (left != null) {
                q.add(new Node_Level(left, curL + 1));
            }
            if (right != null) {
                q.add(new Node_Level(right, curL + 1));
            }
        }
        return maxLevel;
    }

    public int sum() {
        int sum = 0;
        if (this.empty()) {
            return 0;
        } else {
            LinkedList<IntBstNode> queue = new LinkedList();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                IntBstNode node = queue.removeFirst();
                sum += node.key;
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return sum;
    }

    public void printBreadthFirst() {
        if (root == null) {
            System.out.println("\nEmpty tree.\n");
        } else {
            LinkedList<IntBstNode> queue = new LinkedList();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                IntBstNode node = queue.removeFirst();
                System.out.print(node + ", ");
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
    }

    public void printAlign(IntBstNode p, int nSpace) {
        if (p != null) {
            for (int i = 0; i < nSpace; i++) {
                System.out.print(" ");
            }
            System.out.println(p);
            printAlign(p.left, nSpace + 3);
            printAlign(p.right, nSpace + 3);
        }
    }

    public void printAlign() {
        if (root == null) {
            System.out.println("\nEmpty tree.\n");
        } else {
            printAlign(root, 0);
        }
    }

    final static int NLR = 1, LNR = 2, RNL = 3, LRN = 4;

    private LinkedList traverse(IntBstNode p, LinkedList<IntBstNode> list, int mode) {
        if (p != null) {
            switch (mode) {
                case NLR:
                    list.add(p);
                    traverse(p.left, list, mode);
                    traverse(p.right, list, mode);
                    break;
                case LNR:
                    traverse(p.left, list, mode);
                    list.add(p);
                    traverse(p.right, list, mode);
                    break;
                case RNL:
                    traverse(p.right, list, mode);
                    list.add(p);
                    traverse(p.left, list, mode);
                    break;
                case LRN:
                    traverse(p.left, list, mode);
                    list.add(p);
                    traverse(p.right, list, mode);
            }
        }
        return list;
    }

    public Iterator<IntBstNode> NLR_iterator() {
        if (root == null) {
            return null;
        }
        LinkedList<IntBstNode> list = new LinkedList();
        traverse(root, list, NLR);
        return list.iterator();
    }

    public Iterator<IntBstNode> LNR_iterator() {
        if (root == null) {
            return null;
        }
        LinkedList<IntBstNode> list = new LinkedList();
        traverse(root, list, LNR);
        return list.iterator();
    }

    public Iterator<IntBstNode> RNL_iterator() {
        if (root == null) {
            return null;
        }
        LinkedList<IntBstNode> list = new LinkedList();
        traverse(root, list, RNL);
        return list.iterator();
    }

    public Iterator<IntBstNode> LRN_iterator() {
        if (root == null) {
            return null;
        }
        LinkedList<IntBstNode> list = new LinkedList();
        traverse(root, list, LRN);
        return list.iterator();
    }

    public void printNLR() {
        if (root == null) {
            System.out.print("\nEmpty tree.\n");
        } else {
            Iterator<IntBstNode> it = this.NLR_iterator();
            while (it.hasNext()) {
                System.out.print(it.next().key + ", ");
            }
        }
    }

    public void printLNR() {
        if (root == null) {
            System.out.print("\nEmpty tree.\n");
        } else {
            Iterator<IntBstNode> it = this.LNR_iterator();
            while (it.hasNext()) {
                System.out.print(it.next().key + ", ");
            }
        }
    }

    public void printRNL() {
        if (root == null) {
            System.out.print("\nEmpty tree.\n");
        } else {
            Iterator<IntBstNode> it = this.RNL_iterator();
            while (it.hasNext()) {
                System.out.print(it.next().key + ", ");
            }
        }
    }

    public void printLRN() {
        if (root == null) {
            System.out.print("\nEmpty tree.\n");
        } else {
            Iterator<IntBstNode> it = this.LRN_iterator();
            while (it.hasNext()) {
                System.out.print(it.next().key + ", ");
            }
        }
    }

    private boolean removeLeaf(IntBstNode delNode) {
        if (!delNode.isLeaf()) {
            return false;
        }
        if (delNode == root) {
            root = null;
        } else {
            IntBstNode father = delNode.father;
            if (father.left == delNode) {
                father.left = null;
            } else {
                father.right = null;
            }
        }
        return true;
    }

    private boolean removeOneChildNode(IntBstNode delNode) {
        if (!delNode.havingOneChild()) return false;
        if (delNode==root) {
            if (root.left==null) root=root.right;
            else root=root.left;
            root.father = null;
        }
        else {
            IntBstNode grandFather = delNode.father;
            IntBstNode grandChild;
            if (delNode.left == null) grandChild=delNode.right;
            else grandChild=delNode.left;
            if (delNode==grandFather.left)grandFather.left=grandChild;
            else grandFather.right= grandChild;
            grandChild.father = grandFather;
        }
        return true;
    }
    
    private boolean deleteByMergin(IntBstNode delNode) {
        if (!delNode.having2Children())
            return false;
        IntBstNode grandFather = delNode.father;
        IntBstNode leftGrandChild = delNode.left;
        IntBstNode rightGrandChild = delNode.right;
        IntBstNode rightMost = leftGrandChild;
        while (rightMost.right!=null) rightMost=rightMost.right;
        rightMost.right = rightGrandChild;
        rightGrandChild.father=rightMost;
        if (delNode==root) {
            root = leftGrandChild;
            root.father=null;
        }
        else {
            if (grandFather.left==delNode)grandFather.left= leftGrandChild;
            else grandFather.right = leftGrandChild;
            leftGrandChild.father = grandFather;
        }
        return true;
    }
    
    public boolean deleteByMerging (int x) {
        IntBstNode delNode = search(x);
        if (delNode==null) return false;
        boolean succeeded;
        if (delNode.isLeaf())succeeded = removeLeaf(delNode);
        else if (delNode.havingOneChild())
                succeeded = removeOneChildNode(delNode);
             else succeeded = deleteByMergin(delNode);
        if (succeeded) numOfNodes--;
        return succeeded;
    }
    
    private boolean deleteByCopying(IntBstNode delNode) {
        if (!delNode.having2Children()) return false;
        IntBstNode rightMost = delNode.left;
        while(rightMost.right != null) rightMost=rightMost.right;
        delNode.key = rightMost.key;
        if (rightMost.isLeaf())removeLeaf(rightMost);
        if (rightMost.havingOneChild())removeOneChildNode(rightMost);
        return true;
    }
    
    public boolean deleteByCopying(int x) {
        IntBstNode delNode = search(x);
        if(delNode==null) return false;
        boolean succeeded;
        if (delNode.isLeaf())succeeded = removeLeaf(delNode);
        else if (delNode.havingOneChild())
            succeeded = removeOneChildNode(delNode);
        else succeeded = deleteByCopying(delNode);
        if (succeeded) numOfNodes--;
        return succeeded;
    }
}
