package Wtree;

public class WQNode {
	private WNode index;
	private WQNode next;
	
	public WQNode(){}
	
	public WNode get(){return index;}
	public WQNode next(){return next;}
	
	public void setItem(WNode n){index=n;}
	public void setNext(WQNode q){next=q;}
	
}
