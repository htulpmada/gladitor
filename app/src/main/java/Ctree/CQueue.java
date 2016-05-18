package Ctree;

public class CQueue {
	private CQNode head,tail;
	private int size;
	
	public CQueue(){
		size=0;
		tail=head=null;
	}

	public CQNode getfront(){return head;}
	public CQNode getnext(){return head.next();}
	public int getsize(){return size;}
	
	public void insert(CNode n){
		CQNode temp = new CQNode();
		temp.setItem(n);
		temp.setNext(null);
		if(size==0)head=tail=temp;
		else {tail.setNext(temp);tail=temp;}
		size++;
		}
	
	public CNode gethead(){
		CNode temp =null;
		if(size>0){
			temp=head.get();
			head=head.next();
			size--;
			if(size==0){tail=head=null;}
		}
		return temp;
	}	
}
