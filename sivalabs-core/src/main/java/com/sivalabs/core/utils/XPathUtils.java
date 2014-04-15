/**
 * 
 */
package com.sivalabs.core.utils;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Siva
 *
 */
public class XPathUtils
{
	static DocumentBuilder builder = null;
	static XPath xPath = XPathFactory.newInstance().newXPath();
	
	public static void main(String[] args) throws Exception
	{
		//DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputStream is = XPathUtils.class.getResourceAsStream("/cache-config.xml");
		Document document = builder.parse(is);
		
		XPathExpression expression = xPath.compile("//cache");
		NodeList nodelist = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
		int length = nodelist.getLength();
		System.out.println(length);
		for (int i = 0; i < length; i++)
		{
			Node node = nodelist.item(i);
			printCacheConfig(node);		
		}
		
	}
	
	protected static void printCacheConfig(Node node)throws Exception
	{
		NamedNodeMap attributes = node.getAttributes();
		System.out.println("id="+attributes.getNamedItem("id").getNodeValue());
		System.out.println("cacheLoaderClassName="+attributes.getNamedItem("cacheLoaderClassName").getNodeValue());
		System.out.println("refreshInterval="+attributes.getNamedItem("refreshInterval").getNodeValue());
		System.out.println("lazy="+attributes.getNamedItem("lazy").getNodeValue());
		
		if(node.hasChildNodes())
		{
			XPathExpression descExpr = xPath.compile("description/text()");
			String descrNode = (String) descExpr.evaluate(node, XPathConstants.STRING);
			System.out.println("Description="+descrNode);
			
		}
	}

}
