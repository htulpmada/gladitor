package Atree;

public class AQueue {
	private AQNode head,tail;
	private int size;
	
	public AQueue(){
		size=0;
		tail=head=null;
	}

	public AQNode getfront(){return head;}
	public AQNode getnext(){return head.next();}
	public int getsize(){return size;}
	
	public void insert(ANode n){
		AQNode temp = new AQNode();
		temp.setItem(n);
		temp.setNext(null);
		if(size==0)head=tail=temp;
		else {tail.setNext(temp);tail=temp;}
		size++;
		}
	
	public ANode gethead(){
		ANode temp =null;
		if(size>0){
			temp=head.get();
			head=head.next();
			size--;
			if(size==0){tail=head=null;}
		}
		return temp;
	}	
}
