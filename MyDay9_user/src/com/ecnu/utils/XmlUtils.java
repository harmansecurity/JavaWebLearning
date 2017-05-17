package com.ecnu.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	private static String filepath;
	static{
		//不能直接用filepath,这里我直接自己给出来了
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
	}
	public static Document getDocument() throws DocumentException{
        SAXReader reader = new SAXReader();
        //System.out.println(filepath);
        Document document = reader.read(new File("F:\\MyEclipse 8.5 M1\\workspace\\MyDay9_user\\WebRoot\\WEB-INF\\classes\\users.xml"));
        return document;
	}
	public static void write2Xml(Document document) throws IOException{
        // Pretty print the document to System.out
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter( new FileOutputStream("F:\\MyEclipse 8.5 M1\\workspace\\MyDay9_user\\WebRoot\\WEB-INF\\classes\\users.xml"), format );
        writer.write( document );
        writer.close();
	}
}
