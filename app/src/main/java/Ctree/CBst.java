package Ctree;

import java.util.ArrayList;

import sikware.com.gladitor.Charm;

public class CBst {
	protected static CNode root;
	protected static long count=0;
	protected static int minDep=100000;
	protected static int maxDep=0; 
	
	public CBst(){}
	public CBst(ArrayList<Charm> words){
		for(Charm word :words){
			root=ins(word);
		}
	}	
	
	//////////////getter/setter f(x)
	public static CNode getRoot(){return root;}
	public void setRoot(CNode n){root=n;}
	protected long getCount(){return count;}
 	protected int minDepth(){return minDep;}
 	protected int maxDepth(){return maxDep;}
 
	
	/////////////level order print f(x)'s
	protected static void print(boolean rb){print(root,rb);}//no args prints root of tree
	protected static void print(CNode n,boolean rb){////prints all subtrees of n
		CQueue nodes=new CQueue();
		nodes.insert(n);
		if(root==null){System.out.println("!Empty Tree!");return;}
		int nxtLv=root.getDepth();
		int level=0;
		while(nodes.getfront()!=null){
			CNode t=nodes.gethead();
			if(t==null){continue;}
			if(nxtLv==t.getDepth()){
				System.out.print("\n"+ ++level+": ");
				nxtLv++;
				if(nodes.getfront()==null){
					if(t.getLeft()==null&&t.getRight()==null){System.out.print("=");}
					if(rb){System.out.print(""+t.getData()+"("+t.getParent().getData()+")"+t.getFreq()+isRoot(t)+" ");}
					else{System.out.print(""+t.getData()+"("+t.getParent().getData()+")"+t.getFreq()+isRoot(t)+" ");}
					nodes.insert(t.getLeft());
					nodes.insert(t.getRight());
					continue;
					}
			}
			if(t.getLeft()==null&&t.getRight()==null){System.out.print("=");}
			if(rb){System.out.print(""+t.getData()+"("+t.getParent().getData()+")"+t.getFreq()+isRoot(t)+" ");}
			else{System.out.print(""+t.getData()+"("+t.getParent().getData()+")"+t.getFreq()+isRoot(t)+" ");}
			nodes.insert(t.getLeft());
			nodes.insert(t.getRight());
		}
		System.out.print("\n");
	}	
	
	/////////////insert f(x)'s
	public CNode ins(Charm word) {//initial call
		root=ins(root,root,word,1);
		return root;
	}
	private CNode ins(CNode n,CNode p,Charm word, int lvl){//overloaded to recurse
		if(n==null){
			count++;
			n=new CNode(word,p,lvl);
			if(root==null){n.setParent(n);}
			return n;
			}
		switch(compare(word.name,n.getData().name)){
			case(-1)://less than
				n.setLeft(ins(n.getLeft(),n,word,++lvl));
				break;
			case(1)://greater than
				n.setRight(ins(n.getRight(),n,word,++lvl));
				break;
			default://equals
				n.incFreq();
			}
		return n;
		}
	
	
	//////////////////////delete f(x)'s	
	protected CNode del(Charm word) {//initial call
		root=del(root,word);
		return root;
	}
	protected CNode del(CNode n,Charm word) {//overloaded to recurse
		if(n==null){
			System.out.println(word +" not in Tree");
			return null;
		}
		switch(compare(word.name,n.getData().name)){
			case(-1)://less than
				n.setLeft(del(n.getLeft(),word));
				break;
			case(1)://greater than
				n.setRight(del(n.getRight(),word));
				break;
			case(0):
				if(n.getFreq()>1){n.decFreq();break;}//if frequency > 1
				else{//frequency = 1
					if(n.getRight()==null){return n.getLeft();}
					if(n.getLeft()==null){return n.getRight();}
					CNode temp = n;
					n = min(temp.getRight());
					n.setRight(delMin(temp.getRight()));
					n.setLeft(temp.getLeft());
					count--;
					break;
				}
			default:
				System.out.println("item not in Tree");
			}
		return n;
	}
	private CNode delMin(CNode n){
		if(n.getLeft()==null){return n.getRight();}
		n.setLeft(delMin(n.getLeft()));
		return n;
	}
	
	
	/////////////////frequency f(x)'s
	protected int getFreq(Charm word) {//initial call
		return getFreq(root,word);
	}
	protected int getFreq(CNode n,Charm word) {//overload to recurse
		if(n==null){
			System.out.println(word +" not in Tree");
			return 0;
		}
		switch(compare(word.name,n.getData().name)){
			case(-1)://less than
				return getFreq(n.getLeft(),word);
			case(1)://greater than
				return getFreq(n.getRight(),word);
			case(0)://equals
				return n.getFreq();
			default:
				System.out.print("Item not in tree ");
				return 0;
		}
	}
	
	/////////////////report f(x)'s
	public void report(){
		findMinMax(root);
		System.out.println("report:\n\tno. of nodes: "+getCount()+"\n\tmin depth: "+minDepth()+"\n\tmax depth: "+maxDepth());
	}

	//////////helper f(x)
	private CNode min(CNode n){
		if(n.getLeft()==null){return n;}
		else{return min(n.getLeft());}
	}
	
	protected static String isRoot(CNode n){
		if(n.getParent()==null||n.getData()==root.getData()){return "X";}
		else{return n.getLorR();}
		}
	
 	protected int compare(String word, String data) {//lexographic comparison
		if(word.compareTo(data)>0){return 1;}
		else if(word.compareTo(data)<0){return -1;}
		else {return 0;}
	}

 	public static void findMinMax(CNode n){////recursively finds min/max depths
		CQueue nodes=new CQueue();
		nodes.insert(n);
		minDep=(int) count;
		maxDep=0;
		while(nodes.getfront()!=null){
			CNode t=nodes.gethead();
			if(t==null){continue;}
			if(t.getLeft()==null&&t.getRight()==null){
				if(t.getDepth()<minDep){minDep=t.getDepth();}
				if(t.getDepth()>maxDep){maxDep=t.getDepth();}
			}
			nodes.insert(t.getLeft());
			nodes.insert(t.getRight());
		}
	}
	
 	public static void setParents(CNode n){////sets parent nodes after tree manipulation
		CQueue nodes=new CQueue();
		nodes.insert(n);
		while(nodes.getfront()!=null){
			CNode t=nodes.gethead();
			if(t==null){continue;}
			if(t.getData()==root.getData()){
				t.setParent(t);
				t.setDepth(1);
				}
			if(t.getLeft()!=null){
				t.getLeft().setParent(t);
				t.getLeft().setDepth(t.getDepth()+1);
				}
			if(t.getRight()!=null){
				t.getRight().setParent(t);
				t.getRight().setDepth(t.getDepth()+1);
				}
			if(t.getLeft()!=null){nodes.insert(t.getLeft());}
			if(t.getRight()!=null){nodes.insert(t.getRight());}
		}
	}
	
	 	
}
