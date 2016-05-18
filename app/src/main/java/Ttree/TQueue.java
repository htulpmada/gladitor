package Ttree;

public class TQueue {
	private TQNode head,tail;
	private int size;
	
	public TQueue(){
		size=0;
		tail=head=null;
	}

	public TQNode getfront(){return head;}
	public TQNode getnext(){return head.next();}
	public int getsize(){return size;}
	
	public void insert(TNode n){
		TQNode temp = new TQNode();
		temp.setItem(n);
		temp.setNext(null);
		if(size==0)head=tail=temp;
		else {tail.setNext(temp);tail=temp;}
		size++;
		}
	
	public TNode gethead(){
		TNode temp =null;
		if(size>0){
			temp=head.get();
			head=head.next();
			size--;
			if(size==0){tail=head=null;}
		}
		return temp;
	}	
}
