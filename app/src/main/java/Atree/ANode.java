package Atree;


import sikware.com.gladitor.Armor;

public class ANode {
	private ANode Left,Right,Parent;
	private Armor data;
	private boolean red;
	private int frequency;
	private int depth;
	
	public ANode(Armor s,ANode p, int i){
		Left=Right=null;
		data=s;
		red=true;
		frequency=1;
		depth=i;
		Parent=p;
	}
	
	public void setLeft(ANode n){this.Left=n;}
	
	public void setRight(ANode n){this.Right=n;}
	
	public void setParent(ANode n){this.Parent=n;}
	
	public void setData(Armor s){this.data=s;}
	
	public void makeRed(){this.red=true;}
	
	public void makeBlack(){this.red=false;}
	
	public void incFreq(){this.frequency++;}
	
	public void decFreq(){this.frequency--;}

	public void setDepth(int d){this.depth=d;}
	
	public ANode getLeft(){return this.Left;}
	
	public ANode getRight(){return this.Right;}
	
	public ANode getParent(){return this.Parent;}
	
	public Armor getData(){return this.data;}
	
	public int getFreq(){return this.frequency;}
	
	public int getDepth(){return this.depth;}
	
	public String getLorR() {
		if(this.Parent.Left!=null&&this.data==this.Parent.Left.data){return "L";}
		else {return "R";}
	}

	public ANode getUncle() {//might be wrong
		if(this.Parent.getLorR()=="L"){return this.Parent.Parent.Right;}
		else{return this.Parent.Parent.Left;}
	}

	public boolean linear() {
		if(this.getLorR()=="L"&&this.Parent.getLorR()=="L"||this.getLorR()=="R"&&this.Parent.getLorR()=="R"){return true;}
		else{return false;}
	}

	public ANode getSib() {
		if(this.getLorR()=="L"){return this.Parent.Right;}
		else if(this.getLorR()=="R"){return this.Parent.Left;}
		else return null;
	}

	public ANode getNeph() {
		if(this.getLorR()=="L"){return this.Parent.Right.Right;}
		else if(this.getLorR()=="R"){return this.Parent.Left.Left;}
		else return null;
	}

	public ANode getNeice() {
		if(this.getLorR()=="L"){return this.Parent.Right.Left;}
		else if(this.getLorR()=="R"){return this.Parent.Left.Right;}
		else return null;
	}

	public String isRedPrint() {
		if(red){return "*";}
		else{return "";}
	}

}