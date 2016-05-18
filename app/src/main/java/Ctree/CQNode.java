package Ctree;

public class CQNode {
	private CNode index;
	private CQNode next;
	
	public CQNode(){}
	
	public CNode get(){return index;}
	public CQNode next(){return next;}
	
	public void setItem(CNode n){index=n;}
	public void setNext(CQNode q){next=q;}
	
}
