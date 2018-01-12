public class BinarySearchTree <E extends Comparable<E> >{
	private static class Node<E>{
		private E value;
		private Node<E> left;
		private Node<E> right;
		private Node(E value, Node<E> left, Node<E> right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	Node<E> root;

	public boolean contains(E value){

		return true;
	}

	private boolean contains(E value, Node<E> current){
		if(current == null){
			return false;
		}

		if(value.compareTo(current.value)<0){
			return contains(value, current.left);
		}
		else if(value.compareTo(current.value)>0){
			return true;
		}
		else{
			return contains(value, current.right);
		}
	}
	public boolean add(E value){
		//Node<E> current=root;
		if(root==null){
			root = new Node<E>(value,null,null);
			return true;
		}
		else{
			Node<E> current=root;
			boolean done=false;
			while(!done){
				int test= value.compareTo(current.value);
				if(test==0){
					done=true;
				}
				else if(test<0){
					if(current.left==null){
						current.left=new Node<E>(value,null,null);
						done=true;
					}
					else{
						current=current.left;
					}
				}
				else{
					if(current.right==null){
						current.right=new Node<E>(value,null,null);
						done=true;
					}
					else{
						current=current.right;
					}
				}	
			}
			return false;
		}
		}
	public String toString() {
        return toString( root );
    }

    // Helper method.
  
    private String toString(Node<E> current) {
    
        if (current == null) {
            return "{}";
        }
    
        return "{" + toString(current.left) + "["  + current.value + "]" + toString(current.right) + "}";
    }
    public static void main(String [] args){
    	BinarySearchTree<Integer> b= new BinarySearchTree<Integer>();
    	b.add(5);
    	b.add(3);
    	b.add(2);
    	b.add(1);
    	System.out.println(b);
    }


	
}