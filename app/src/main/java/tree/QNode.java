package tree;

public class QNode {
	private Node index;
	private QNode next;
	
	public QNode(){}
	
	public Node get(){return index;}
	public QNode next(){return next;}
	
	public void setItem(Node n){index=n;}
	public void setNext(QNode q){next=q;}
	
}
