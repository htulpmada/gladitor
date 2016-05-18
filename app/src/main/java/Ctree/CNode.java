package Ctree;


import sikware.com.gladitor.Charm;

public class CNode {
	private CNode Left, Right, Parent;
	private Charm data;
	private boolean red;
	private int frequency;
	private int depth;

	public CNode(Charm s, CNode p, int i) {
		Left = Right = null;
		data = s;
		red = true;
		frequency = 1;
		depth = i;
		Parent = p;
	}

	public boolean isRed() {
		if (red) {
			return true;
		} else {
			return false;
		}
	}

	public void setLeft(CNode n) {
		this.Left = n;
	}

	public void setRight(CNode n) {
		this.Right = n;
	}

	public void setParent(CNode n) {
		this.Parent = n;
	}

	public void setData(Charm s) {
		this.data = s;
	}

	public void makeRed() {
		this.red = true;
	}

	public void makeBlack() {
		this.red = false;
	}

	public void incFreq() {
		this.frequency++;
	}

	public void decFreq() {
		this.frequency--;
	}

	public void setDepth(int d) {
		this.depth = d;
	}

	public CNode getLeft() {
		return this.Left;
	}

	public CNode getRight() {
		return this.Right;
	}

	public CNode getParent() {
		return this.Parent;
	}

	public Charm getData() {
		return this.data;
	}

	public int getFreq() {
		return this.frequency;
	}

	public int getDepth() {
		return this.depth;
	}

	public String getLorR() {
		if (this.Parent.Left != null && this.data == this.Parent.Left.data) {
			return "L";
		} else {
			return "R";
		}
	}

}