package tree;

public class Queue {
	private QNode head,tail;
	private int size;
	
	public Queue(){
		size=0;
		tail=head=null;
	}

	public QNode getfront(){return head;}
	public QNode getnext(){return head.next();}
	public int getsize(){return size;}
	
	public void insert(Node n){
		QNode temp = new QNode();
		temp.setItem(n);
		temp.setNext(null);
		if(size==0)head=tail=temp;
		else {tail.setNext(temp);tail=temp;}
		size++;
		}
	
	public Node gethead(){
		Node temp =null;
		if(size>0){
			temp=head.get();
			head=head.next();
			size--;
			if(size==0){tail=head=null;}
		}
		return temp;
	}	
}
