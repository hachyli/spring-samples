package com.sivalabs.core.breadcrumb;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BreadCrumbTest
{
	public static void main(String[] args) throws Exception
	{
		BreadCrumb breadCrumb = BreadCrumb.getInstance();
		breadCrumb.printBreadCrumb("b");
		
	}
	
	public static void main() throws Exception
	{
		//BreadCrumb breadCrumb = BreadCrumb.getInstance();
		//breadCrumb.printBreadCrumb("b");
		
		InputStream xmlFile = BreadCrumbTest.class.getResourceAsStream("breadcrumb.xml");
		System.out.println(xmlFile);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
	    
		NodeList nodeList = doc.getChildNodes();
		
		Node rootNode = nodeList.item(0);
		System.out.println(rootNode.getNodeName());
		
		NodeList linkNodes = rootNode.getChildNodes();
		int length = linkNodes.getLength();
		for (int i = 0; i < length; i++) 
		{
			addNode(linkNodes.item(i), rootNode);
		}
		
	}
	
	private static void addNode(Node node, Node parentNode)
	{
		//Node node = linkNodes.item(i);
		if(node.getNodeType() == 1)
		{
			if(node.hasChildNodes()){
				NodeList childNodes = node.getChildNodes();
				int length = childNodes.getLength();
				for (int i = 0; i < length; i++) {
					addNode(childNodes.item(i), node);
				}
				
			}
			NamedNodeMap attributes = node.getAttributes();
			Node namedItem = attributes.getNamedItem("id");
			if(namedItem != null)
			{
				System.out.println(namedItem.getNodeValue()+": parent="+parentNode.getNodeName());
			}
		}
	}

}
