package Wtree;


import sikware.com.gladitor.Weapon;

public class WNode {
	private WNode Left,Right,Parent;
	private Weapon data;
	private boolean red;
	private int frequency;
	private int depth;
	
	public WNode(Weapon s,WNode p, int i){
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
	
	public void setLeft(WNode n){this.Left=n;}
	
	public void setRight(WNode n){this.Right=n;}
	
	public void setParent(WNode n){this.Parent=n;}
	
	public void setData(Weapon s){this.data=s;}

	public void incFreq(){this.frequency++;}
	
	public void decFreq(){this.frequency--;}

	public void setDepth(int d){this.depth=d;}
	
	public WNode getLeft(){return this.Left;}
	
	public WNode getRight(){return this.Right;}
	
	public WNode getParent(){return this.Parent;}
	
	public Weapon getData(){return this.data;}
	
	public int getFreq(){return this.frequency;}
	
	public int getDepth(){return this.depth;}
	
	public String getLorR() {
		if(this.Parent.Left!=null&&this.data==this.Parent.Left.data){return "L";}
		else {return "R";}
	}
}