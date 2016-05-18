package Ttree;


import sikware.com.gladitor.Transport;

public class TNode {
	private TNode Left,Right,Parent;
	private Transport data;
	private boolean red;
	private int frequency;
	private int depth;
	
	public TNode(Transport s,TNode p, int i){
		Left=Right=null;
		data=s;
		red=true;
		frequency=1;
		depth=i;
		Parent=p;
	}

	public boolean isRed(){
		if(red){return true;}
		else{return false;}
		}
	
	public void setLeft(TNode n){this.Left=n;}
	
	public void setRight(TNode n){this.Right=n;}
	
	public void setParent(TNode n){this.Parent=n;}
	
	public void setData(Transport s){this.data=s;}
	
	public void makeRed(){this.red=true;}
	
	public void makeBlack(){this.red=false;}
	
	public void incFreq(){this.frequency++;}
	
	public void decFreq(){this.frequency--;}

	public void setDepth(int d){this.depth=d;}
	
	public TNode getLeft(){return this.Left;}
	
	public TNode getRight(){return this.Right;}
	
	public TNode getParent(){return this.Parent;}
	
	public Transport getData(){return this.data;}
	
	public int getFreq(){return this.frequency;}
	
	public int getDepth(){return this.depth;}
	
	public String getLorR() {
		if(this.Parent.Left!=null&&this.data==this.Parent.Left.data){return "L";}
		else {return "R";}
	}
}