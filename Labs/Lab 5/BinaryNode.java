// BinaryNode class; stores a node in a tree.
//
// CONSTRUCTION: with (a) no parameters, or (b) an Object,
//     or (c) an Object, left child, and right child.
//
// *******************PUBLIC OPERATIONS**********************
// int size( )            --> Return size of subtree at node
// int height( )          --> Return height of subtree at node
// void printPostOrder( ) --> Print a postorder tree traversal
// void printInOrder( )   --> Print an inorder tree traversal
// void printPreOrder( )  --> Print a preorder tree traversal
// BinaryNode duplicate( )--> Return a duplicate tree

/**
 * Binary node class with recursive routines to
 * compute size and height.
 */
class BinaryNode<AnyType>
{
    private AnyType             element;
    private BinaryNode<AnyType> left;
    private BinaryNode<AnyType> right;
    
    public BinaryNode( ) {
        this( null, null, null );
    }
    
    public BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt ){
        element = theElement;
        left    = lt;
        right   = rt;
    }

    // access to fields
    public AnyType getElement( ) { return element; }
    public BinaryNode<AnyType> getLeft( ) { return left; }
    public BinaryNode<AnyType> getRight( ) { return right; }
    
    // change fields
    public void setElement( AnyType x ) { element = x; }
    public void setLeft( BinaryNode<AnyType> t ) { left = t; }
    public void setRight( BinaryNode<AnyType> t ) { right = t; }

    /**
     * Return the size of the binary tree rooted at t.
     * Note that the method is static, so we can call 
     * even before any object created.
     */
    public static <AnyType> int size( BinaryNode<AnyType> t )
    {
        if( t == null )
            return 0;
        else
            return 1 + size( t.left ) + size( t.right );
    }

    /**
     * Return the height of the binary tree rooted at t.
     */
    public static <AnyType> int height( BinaryNode<AnyType> t )
    {
    	//To be implemented
    	return 0;
    }

    // Print tree rooted at current node using preorder traversal.
    public void printPreOrder( )
    {
    	//To be implemented
    }


    // Print tree rooted at current node using postorder traversal.
    public void printPostOrder( )
    {
    	//To be implemented
    }

    // Print tree rooted at current node using inorder traversal.
    public void printInOrder( )
    {
        if( left != null )
            left.printInOrder( );            // Left
        System.out.println( element );       // Node
        if( right != null )
            right.printInOrder( );           // Right
    }


    /**
     * Return a reference to a node that is the root of a
     * duplicate of the binary tree rooted at the current node.
     * In other words, create a copy of the tree rooted at
     * the current node.
     */
    public BinaryNode<AnyType> duplicate( )
    {
        BinaryNode<AnyType> root = new BinaryNode<AnyType>( element, null, null );

        if( left != null )            // If there's a left subtree
            root.left = left.duplicate( );    // Duplicate; attach
        if( right != null )          // If there's a right subtree
            root.right = right.duplicate( );  // Duplicate; attach
        return root;                      // Return resulting tree
    }

}
