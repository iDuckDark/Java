public class OrderedList implements OrderedStructure{

	private static class Node{

		private Comparable value; 
		private Node previous;
		private Node next;

		private Node(Comparable value, Node previous,Node next ){
			this.value=value; this.previous=previous; this.next=next;} }

	private Node head;	//private Node<T> tail;  
	//private int size;

	public OrderedList(){
		// circle list contructor
		head = new Node(null,null,null);
		head.next=head;  					System.out.println(head.next);
		head.previous=head; 				System.out.println(head.previous);
	}

	public int size(){
		if (head == null){
			throw new UnsupportedOperationException("not implemented yet!");
		}
		else{
			Node dummyNode = head; 
			int counter=0;
			while ( (dummyNode.next) != null) {
				dummyNode= dummyNode.next;
				counter++;
			}
			int size=counter;
			return size;
		}
	}

	public void add(Comparable element) throws IllegalArgumentException{
		if(element==null){
			throw new IllegalArgumentException("IllegalArgumentException");
		}

		if(size()==0){
			head.next =head.previous= new Node(element,head, head.next);
		}

		Node dummyNode = head; 

		while (dummyNode.next!=null && dummyNode.value.compareTo(element)<0){
			dummyNode=dummyNode.next;
		}
		Node dummyNode2 = dummyNode.next;
		dummyNode.next=new Node(element,dummyNode,dummyNode2);
		dummyNode2.previous=dummyNode.next;
		//new Node (head,null,null);
		//while ( (dummyNode.next) != null) {
		//	dummyNode= dummyNode.next;
			//Node dummyNode= new Node (head,null,null);
		//}

		//if  ( (dummyNode.value).compareTo(element) == 1){
			//return true;
		//}
		//else{
		//	return false;
		
		
	}

	public void add_OR_not(Comparable element) throws IllegalArgumentException{

		if(element==null){
			throw new IllegalArgumentException("IllegalArgumentException");
		}

		if(size()==0){
			head.next =head.previous= new Node(element,head, head.next);
		}

		Node dummyNode = head; 

		//new Node (head,null,null);
		while ( (dummyNode.next) != null) {
			dummyNode= dummyNode.next;
			//Node dummyNode = new Node (dummyNode,null,null);
		}

		if  ( (dummyNode.value).compareTo(element) == 1){
			//return true;
		}
		else{
			//sreturn false;
		
		
		}
	}

	public Object get(int pos) throws IndexOutOfBoundsException{

		if (pos>=size()){
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		}

		Node dummyNode = head; 
		int counter=0;
		while ( (dummyNode.next) != null) {
			
			if(pos==counter){
				break;
				
			}
			dummyNode= dummyNode.next;
			counter++;
		}
		return dummyNode.value;

	}

	public void remove(int pos) throws IndexOutOfBoundsException{
		if (pos>=size()){
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		}

		Node dummyNode = head;
		int counter =0;
		while ((dummyNode.next)!=null){

			if(pos==counter){
				Node a = dummyNode.previous;
				Node b = dummyNode.next;
				a.next = b;
				b.previous=a;
				break;	
			}

			dummyNode=dummyNode.next;
			counter++;
		}

	}

	public void merge (OrderedList other){
		Node dummyNode=head;
		for(int i =0 ; i<other.size(); i++){
			other.get(i);
			add(i);
		}
	}

	public String toString(){
        String result="[";
        Node current = head;

        while (current != null){
            result += current.value; //+", ";
            current = current.next;
			
            if(current == null)
                break;
            else
                result += ",";
        }

        result += "]";
        return result;
    }
}







	// public void addLast(T elem){

	//  	Node<T> newNode= new Node<T>(elem,null);
	//  	size++;

	//  	if (head==null){
	//  		head=newNode;
	//  		tail=head;
	//  	}
	//  	else{ 
	//  		tail.next=newNode;
	//  		tail=newNode;
		
	
		
 // 			}
 // 	}

	// public T removeLast(){
	// 	if (isEmpty()){
	// 		throw new IllegalStateException("Empty list!");
	// 	}
	// 	T savedValue = tail.value;
	// 	size--;

	// 	if (head.next==null){
	// 		savedValue=head.value;
	// 		head=null;
	// 		tail=null;
	// 	}
	// 	else{
	// 		Node<T> p=head;
	// 		while (p.next!=tail){
	// 			p=p.next;
	// 		}
	// 		tail =p;
	// 		p.next =null;
			

	// 	}
	// 	return savedValue;
		
	


	
	// public void addFirst(T other){
	// 	if (isEmpty()){
	// 		head=new Node<T>(newvalue,null,null);
	// 		tail=head;
	// 	}
	// 	else{
	// 		head.previous=new Node<T>(newvalue,null,head);
	// 		head=head.previous;
	// 	}
	// 	size++;
	// }

	// public void add(int pos,T o){
	// 	if (pos<0 || pos>= size){
	// 		throw new IndexOutOfBoundsException("out of bound");
	// 	}
	// 	if(pos==0){
	// 		addFirst(o);

	// 	}
	// 	else if(pos==size-1){
	// 		addLast(o);

	// 	}
	// 	else{
	// 		Node<T> p=head;
	// 		for (int i=0; i<pos -1; i++){
	// 			p=p.next;
	// 		}
	// 		Node<T> q=new Node<T>(o,p,p.next);
	// 	}
	//}

	// public T removeFirst(){
	// 	if (isEmpty()){
	// 		throw new IllegalStateException("empty list");
	// 	}

	// 	T savedValue=head.value;
	// 	if(head.next==null){
	// 		head=null;
	// 		tail=null;
	// 	}
	// 	else{
	// 		head=head.next;
	// 	}
	// 	size--;
	// 	return savedValue;
	// }
	
	// public int size(){ return size;}
	// public boolean isEmpty(){ return size==0;}

	// public boolean remove(T o){
	// 	//if empty
	// 	if (size==0 ){
	// 		return false;
	// 	}
	// 	Node<T> p= head; 
	// 	while(p!=null && !p.value.equals(o) ){
	// 		p=p.next;
	// 	}
	// 	if(p==null){
	// 		return false;
	// 	}
	// 	if(p==head){
	// 		head=head.next;
	// 		if(head==null){
	// 			tail=null;
	// 		}
	// 		else{
	// 		head.previous=null;
	// 		}
	// 	}
	// 	else if (p==tail){
	// 		tail = tail.previous;
	// 		tail.next=null;

	// 	}
	// 	else{
	// 		p.next.previous=p.previous;
	// 		p.previous=p.next;
	// 	}
	// 	size--;
	// 	return true;
	// }






