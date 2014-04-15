/**
 * 
 */
package com.sivalabs.core.breadcrumb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author skatam
 *
 */
public class BreadCrumb
{
	private static final BreadCrumb INSTANCE = build();
	
	private Tree tree;
	private BreadCrumb(Tree tree)
	{
		this.tree = tree;
	}
	
	public static BreadCrumb getInstance(){
		return INSTANCE;
	}
	
	private static BreadCrumb build() {
		Tree tree = buildTree();
		BreadCrumb bc = new BreadCrumb(tree);
		return bc;
	}
	
	private static Tree buildTree()
	{
		Tree tree = new Tree();
		Node A = new Node("a","A");
		Node B = new Node("b","B");
		tree.addChild(A);
		tree.addChild(B);
		
		Node A1 = new Node("a1","A1");
		tree.addChild(A1, A);
		
		Node A2 = new Node("a2","A2");
		tree.addChild(A2, A);
				
		Node B1 = new Node("b1","B1");
		tree.addChild(B1, B);
		Node B2 = new Node("b2","B2");
		tree.addChild(B2, B);
		Node B3 = new Node("b3","B3");
		tree.addChild(B3, B);
		
		return tree;
	}
	
	public void printBreadCrumb(String id)
	{
		Node node = tree.getNodeById(id);
		if(node==null){
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		Node parent = node.getParent();
		while(parent != null && parent.getId() != null){
			stack.push(parent);
			parent = parent.getParent();
		}
		Node temp;
		while(!stack.isEmpty() && (temp = stack.pop()) != null)
		{
			System.out.print(temp.getName()+">> ");
		}
	}
	
}

class Tree
{
	private Node root = new Node(null);
	private Map<String, Node> nodeMap = new HashMap<String, Node>();
	
	public Node getNodeById(String id){
		return nodeMap.get(id);
	}
	
	public void addChild(Node node)
	{
		nodeMap.put(node.getId(), node);		
		node.setParent(root);
		root.getChildren().add(node);
	}
	
	public void addChild(Node node, Node parent)
	{
		nodeMap.put(node.getId(), node);
		//nodeMap.put(parent.getId(), parent);
		node.setParent(parent);
		parent.getChildren().add(node);
	}
	
	
}

class Node
{
	private String id;
	private String name;
	private Node parent;
	private List<Node> children = new ArrayList<Node>();
	public Node(String id)
	{
		this.id = id;
	}
	public Node(String id, String name)
	{
		this.id = id;
		this.name = name;
	}
	public String getId()
	{
		return id;
	}	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Node getParent()
	{
		return parent;
	}
	public void setParent(Node parent)
	{
		this.parent = parent;
	}
	public List<Node> getChildren()
	{
		//return Collections.unmodifiableList(children);
		return children;
	}
	/*
	public void addChild(Node child)
	{
		this.children.add(child);
	}
	*/
}
