package Wtree;

public class WQueue {
	private WQNode head,tail;
	private int size;
	
	public WQueue(){
		size=0;
		tail=head=null;
	}

	public WQNode getfront(){return head;}
	public WQNode getnext(){return head.next();}
	public int getsize(){return size;}
	
	public void insert(WNode n){
		WQNode temp = new WQNode();
		temp.setItem(n);
		temp.setNext(null);
		if(size==0)head=tail=temp;
		else {tail.setNext(temp);tail=temp;}
		size++;
		}
	
	public WNode gethead(){
		WNode temp =null;
		if(size>0){
			temp=head.get();
			head=head.next();
			size--;
			if(size==0){tail=head=null;}
		}
		return temp;
	}	
}
