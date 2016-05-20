package tree;

import java.util.ArrayList;

import sikware.com.gladitor.Item;

public class Bst {
	protected static Node root;
	protected static long count=0;
	protected static int minDep=100000;
	protected static int maxDep=0; 
	
	public Bst(){}
	public Bst(ArrayList<Item> words){
		for(Item word :words){
			root=ins(word);
		}
	}	
	
	//////////////getter/setter f(x)
	public static Node getRoot(){return root;}
	public void setRoot(Node n){root=n;}
	protected long getCount(){return count;}
 	protected int minDepth(){return minDep;}
 	protected int maxDepth(){return maxDep;}
 
	
	/////////////level order print f(x)'s
	protected static void print(boolean rb){print(root,rb);}//no args prints root of tree
	protected static void print(Node n,boolean rb){////prints all subtrees of n
		Queue nodes=new Queue();
		nodes.insert(n);
		if(root==null){System.out.println("!Empty Tree!");return;}
		int nxtLv=root.getDepth();
		int level=0;
		while(nodes.getfront()!=null){
			Node t=nodes.gethead();
			if(t==null){continue;}
			if(nxtLv==t.getDepth()){
				System.out.print("\n"+ ++level+": ");
				nxtLv++;
				if(nodes.getfront()==null){
					if(t.getLeft()==null&&t.getRight()==null){System.out.print("=");}
					if(rb){System.out.print(""+t.getData()+t.isRedPrint()+"("+t.getParent().getData()+t.getParent().isRedPrint()+")"+t.getFreq()+isRoot(t)+" ");}
					else{System.out.print(""+t.getData()+"("+t.getParent().getData()+")"+t.getFreq()+isRoot(t)+" ");}
					nodes.insert(t.getLeft());
					nodes.insert(t.getRight());
					continue;
					}
			}
			if(t.getLeft()==null&&t.getRight()==null){System.out.print("=");}
			if(rb){System.out.print(""+t.getData()+t.isRedPrint()+"("+t.getParent().getData()+t.getParent().isRedPrint()+")"+t.getFreq()+isRoot(t)+" ");}
			else{System.out.print(""+t.getData()+"("+t.getParent().getData()+")"+t.getFreq()+isRoot(t)+" ");}
			nodes.insert(t.getLeft());
			nodes.insert(t.getRight());
		}
		System.out.print("\n");
	}	
	
	/////////////insert f(x)'s
	public Node ins(Item word) {//initial call
		root=ins(root,root,word,1);
		return root;
	}
	private Node ins(Node n,Node p,Item word, int lvl){//overloaded to recurse
		if(n==null){
			count++;
			n=new Node(word,p,lvl);
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
	protected Node del(Item word) {//initial call
		root=del(root,word);
		return root;
	}
	protected Node del(Node n,Item word) {//overloaded to recurse
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
					Node temp = n;
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
	private Node delMin(Node n){
		if(n.getLeft()==null){return n.getRight();}
		n.setLeft(delMin(n.getLeft()));
		return n;
	}
	
	
	/////////////////frequency f(x)'s
	protected int getFreq(Item word) {//initial call
		return getFreq(root,word);
	}
	protected int getFreq(Node n,Item word) {//overload to recurse
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
	private Node min(Node n){
		if(n.getLeft()==null){return n;}
		else{return min(n.getLeft());}
	}
	
	protected static String isRoot(Node n){
		if(n.getParent()==null||n.getData()==root.getData()){return "X";}
		else{return n.getLorR();}
		}
	
 	protected int compare(String word, String data) {//lexographic comparison
		if(word.compareTo(data)>0){return 1;}
		else if(word.compareTo(data)<0){return -1;}
		else {return 0;}
	}

 	public static void findMinMax(Node n){////recursively finds min/max depths
		Queue nodes=new Queue();
		nodes.insert(n);
		minDep=(int) count;
		maxDep=0;
		while(nodes.getfront()!=null){
			Node t=nodes.gethead();
			if(t==null){continue;}
			if(t.getLeft()==null&&t.getRight()==null){
				if(t.getDepth()<minDep){minDep=t.getDepth();}
				if(t.getDepth()>maxDep){maxDep=t.getDepth();}
			}
			nodes.insert(t.getLeft());
			nodes.insert(t.getRight());
		}
	}
	
 	public static void setParents(Node n){////sets parent nodes after tree manipulation
		Queue nodes=new Queue();
		nodes.insert(n);
		while(nodes.getfront()!=null){
			Node t=nodes.gethead();
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
