package tree;


import sikware.com.gladitor.Item;

public class Node {
	private Node Left,Right,Parent;
	private Item data;
	private boolean red;
	private int frequency;
	private int depth;
	
	public Node(Item s,Node p, int i){
		Left=Right=null;
		data=s;
		red=true;
		frequency=1;
		depth=i;
		Parent=p;
	}
	
	public void setLeft(Node n){this.Left=n;}
	
	public void setRight(Node n){this.Right=n;}
	
	public void setParent(Node n){this.Parent=n;}
	
	public void setData(Item s){this.data=s;}
	
	public void makeRed(){this.red=true;}
	
	public void makeBlack(){this.red=false;}
	
	public void incFreq(){this.frequency++;}
	
	public void decFreq(){this.frequency--;}

	public void setDepth(int d){this.depth=d;}
	
	public Node getLeft(){return this.Left;}
	
	public Node getRight(){return this.Right;}
	
	public Node getParent(){return this.Parent;}
	
	public Item getData(){return this.data;}
	
	public int getFreq(){return this.frequency;}
	
	public int getDepth(){return this.depth;}
	
	public String getLorR() {
		if(this.Parent.Left!=null&&this.data==this.Parent.Left.data){return "L";}
		else {return "R";}
	}

	public Node getUncle() {//might be wrong
		if(this.Parent.getLorR()=="L"){return this.Parent.Parent.Right;}
		else{return this.Parent.Parent.Left;}
	}

	public boolean linear() {
		if(this.getLorR()=="L"&&this.Parent.getLorR()=="L"||this.getLorR()=="R"&&this.Parent.getLorR()=="R"){return true;}
		else{return false;}
	}

	public Node getSib() {
		if(this.getLorR()=="L"){return this.Parent.Right;}
		else if(this.getLorR()=="R"){return this.Parent.Left;}
		else return null;
	}

	public Node getNeph() {
		if(this.getLorR()=="L"){return this.Parent.Right.Right;}
		else if(this.getLorR()=="R"){return this.Parent.Left.Left;}
		else return null;
	}

	public Node getNeice() {
		if(this.getLorR()=="L"){return this.Parent.Right.Left;}
		else if(this.getLorR()=="R"){return this.Parent.Left.Right;}
		else return null;
	}

	public String isRedPrint() {
		if(red){return "*";}
		else{return "";}
	}

}