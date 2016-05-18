package Ttree;

public class TQNode {
	private TNode index;
	private TQNode next;
	
	public TQNode(){}
	
	public TNode get(){return index;}
	public TQNode next(){return next;}
	
	public void setItem(TNode n){index=n;}
	public void setNext(TQNode q){next=q;}
	
}
