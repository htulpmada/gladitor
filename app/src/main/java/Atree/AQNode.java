package Atree;

public class AQNode {
	private ANode index;
	private AQNode next;
	
	public AQNode(){}
	
	public ANode get(){return index;}
	public AQNode next(){return next;}
	
	public void setItem(ANode n){index=n;}
	public void setNext(AQNode q){next=q;}
	
}
