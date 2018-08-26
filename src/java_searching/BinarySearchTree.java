package java_searching;

/**
 * @Author Zhang
 * @Date 2018/8/15 11:09
 */
public class BinarySearchTree<T extends Comparable<T>> {

    public class BSTNode<T extends Comparable<T>>{
        T key;              //关键字，键值

        BSTNode<T> left ;   //左孩子
        BSTNode<T> righ ;   //右孩子
        BSTNode<T> parent;  //父节点

        public BSTNode(T key,BSTNode<T> parent,BSTNode<T> left,BSTNode<T> righ){
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.righ = righ;
        }
    }

    private BSTNode<T> mRoot; //根节点

    /**
     * 前中后  三种遍历方式
     * @param tree
     */
    private void preOeder(BSTNode<T> tree){
        if(tree!=null){
            System.out.println(tree.key+ "");
            preOeder(tree.left);
            preOeder(tree.righ);
        }
    }
    public void preOeder(){
        System.out.println("前序遍历");
        preOeder(mRoot);
    }
    private void inOrder(BSTNode<T> tree){
        if(tree!=null){
            inOrder(tree.left);
            System.out.println(tree.key+ "");
            inOrder(tree.righ);
        }
    }
    public void inOrder(){
        System.out.println("中序遍历");
        inOrder(mRoot);
    }
    private void postOrder(BSTNode<T> tree){
        if(tree!=null){
            postOrder(tree.left);
            postOrder(tree.righ);
            System.out.println(tree.key+ "");
        }
    }
    public void postOrder(){
        System.out.println("后序遍历");
        postOrder(mRoot);
    }

    /**
     * 递归查找二叉树x中键值为key的节点
     */
    private BSTNode<T> search(BSTNode<T> x, T key){
        if(x == null)
            return x;
        int cmp = key.compareTo(x.key);
        if(cmp< 0){
            return search(x.left,key);
        }else if(cmp>0){
            return search(x.righ,key);
        }else {
            return x;
        }
    }
    public BSTNode<T> search(T key){
        return search(mRoot,key);
    }

    /**
     * 非递归查找算法
     * @param x
     * @param key
     * @return
     */
    private BSTNode<T> iterativeSearch(BSTNode<T> x,T key){
        while (x!= null){
            int cmp = key.compareTo(x.key);
            if(cmp< 0){
                x= x.left;
            }else if(cmp>0){
                x=x.righ;
            }else {
                return x;
            }
        }
        return x;
    }

    public BSTNode<T> iterativeSearch(T key){
        return iterativeSearch(mRoot,key);
    }


    /**
     * 查找最大值与最小值
     */
    private BSTNode<T> maximum(BSTNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.righ != null)
            tree = tree.righ;
        return tree;
    }

    public T maximum() {
        BSTNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    private BSTNode<T> minimum(BSTNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        BSTNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /**
     * 前驱和后继
     * 节点的前驱：是该节点的左子树中的最大值 二叉树中小于该节点的值并且最大的值
     * 节点的后继：是该节点的右子树中的最小值 二叉树中大于该节点的值并且最小的值
     * 举个例子：
     *
     *                         +-----6------+
     *                         1----+       7---+
     *                            +--5       +--9--+
     *                         +--3--+       8    10
     *                         2    4
     * 如图所示：4的前驱节点是3，2的前驱节点是1，6的前驱节点是5
     *           7的后继节点是8，5的后继节点是6，2的后继节点是3
     * 前驱节点
     * 若一个节点有左子树，那么该节点的前驱节点是其左子树中val值最大的节点（也就是左子树中所谓的rightMostNode）
     * 若一个节点没有左子树，那么判断该节点和其父节点的关系
     * 2.1 若该节点是其父节点的右边孩子，那么该节点的前驱结点即为其父节点。
     * 2.2 若该节点是其父节点的左边孩子，那么需要沿着其父亲节点一直向树的顶端寻找，直到找到一个节点P，
     *      P节点是其父节点Q的右边孩子（可参考例子2的前驱结点是1），那么Q就是该节点的后继节点
     *
     * 后继节点
     * 若一个节点有右子树，那么该节点的后继节点是其右子树中val值最小的节点（也就是右子树中所谓的leftMostNode）
     * 若一个节点没有右子树，那么判断该节点和其父节点的关系
     * 2.1 若该节点是其父节点的左边孩子，那么该节点的后继结点即为其父节点
     * 2.2 若该节点是其父节点的右边孩子，那么需要沿着其父亲节点一直向树的顶端寻找，直到找到一个节点P，
     *      P节点是其父节点Q的左边孩子（可参考例子2的前驱结点是1），那么Q就是该节点的后继节点
     *
     */
    public BSTNode<T> predecessor (BSTNode<T> x){
        //如果X存在左子树，则“X的前驱结点”为“以其左子树为根的子树的最大节点”
        if (x.left != null){
            return maximum(x.left);
        }
        /**
         * 如果X没有左孩子。则X有以下两种可能
         * （1）若该节点是其父节点的右边孩子，那么该节点的前驱结点即为其父节点。 （4的前驱节点是3）
         * （2）若该节点是其父节点的左边孩子，（最低指的是所在层数），
         *      那么需要沿着其父亲节点一直向树的顶端寻找，
         *      直到找到一个节点P，P节点是其父节点Q的右边孩子（5是1的右孩子）
         *      那么Q就是该节点的后继节点（1就是我们要找的前驱节点）
         *      (2的前驱节点是1)
         */
        BSTNode<T> y = x.parent;
        while ((y != null)&&(x==y.left)){
            x = y;
            y= y.parent;
        }
        return y;
    }

    public BSTNode<T> successor (BSTNode<T> x){
        if (x.righ != null){
            return minimum(x.righ);
        }
        BSTNode<T> y = x.parent;
        while ((y!=null)&&(x == y.righ)){
            x =y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 插入节点到二叉树
     */
    private void insert(BinarySearchTree<T> bst,BSTNode<T> z){
        int cmp ;
        BSTNode<T> y =null;
        BSTNode<T> x = bst.mRoot;

        //查找z的插入位置
        while (x!=null){
            y =x;
            cmp = z.key.compareTo(x.key);
            if(cmp<0){
                x = x.left;
            }else {
                x= x.righ;
            }
        }
        z.parent = y;
        if(y ==null){
            bst.mRoot = z;
        }else {
            cmp = z.key.compareTo(y.key);
            if(cmp < 0){
                y.left = z;
            }else{
                y.righ = z;
            }
        }
    }

    public void insert(T key) {
        BSTNode<T> z = new BSTNode<T>(key, null, null, null);
        //如果新建节点失败，则返回
        if (z!=null)
            insert(this,z);
    }

    /**
     * 删除节点z，并返回被删除的节点
     */
    private BSTNode<T> remove (BinarySearchTree<T> bst,BSTNode<T> z){
        BSTNode<T> x =null;
        BSTNode<T> y = null;
        if((z.left == null)||(z.righ == null)){
            y= z;
        }else {
            y= successor(z);
        }

        if(y.left != null){
            x= y.left;
        }else {
            x= y.righ;
        }

        if(x != null){
            x.parent = y.parent;
        }

        if (y.parent == null){
            bst.mRoot = x;
        }else if (y == y.parent.left){
            y.parent.left =x;
        }else {
            y.parent.righ = x;
        }

        if (y!= z){
            z.key = y.key;
        }

        return y;
    }

    public void remove(T key){
        BSTNode<T> z, node;

        if ((z = search(mRoot, key)) != null)
            if ( (node = remove(this, z)) != null)
                node = null;
    }

    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(BSTNode<T> tree,T key,int direction){
        if(tree != null) {

            if(direction==0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.righ,tree.key,  1);
        }
    }

    public void print(){
        if(mRoot != null){
            print(mRoot,mRoot.key,0);
        }
    }

    /*
     * 销毁二叉树
     */
    private void destroy(BSTNode<T> tree) {
        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.righ != null)
            destroy(tree.righ);

        tree=null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }
}






















