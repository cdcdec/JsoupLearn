package com.cdc.jsoup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSOUP1{
	
	private Document  getDoc(String htmlUrl){
		Document doc=null;
		 try {
			// 从 URL 直接加载 HTML 文档
				doc = Jsoup.connect(htmlUrl).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return doc;
	}
	
	public  String  getTable(String htmlUrl,String floderName){
		Floder  floder=null;
		Document doc=getDoc(htmlUrl);
		String str="";
		Elements links = doc.select("tr[bgcolor=#ffffff]");
		Elements as=links.select("td>a");
		Elements as2=as.select("a");
		for (int i = 0; i < as2.size(); i++) {
			String text=as2.get(i).text();
			floder=new Floder();
			System.out.println("改变前="+text);
			File tempFile=floder.createFloder(text,floderName);
			String str2=as2.get(i).attr("href");//获取href的值
			String newUrl=StringTools.getPath(htmlUrl)+str2;
			getText(newUrl, tempFile,text);
			
			
		}
		return str; 
	}
	
	
	public void getText(String htmlUrl,File file,String firstLine){
		PrintStream ps=null;
		Document doc=getDoc(htmlUrl);
		Elements links = doc.select("table[width=880]");
		Elements links2=links.select("p");
		for (int i = 0; i < links2.size(); i++) {
			try {
				//尽管网页源码里面使用的是:<br /><br />,这里不能使用replaceAll("<br /><br />", "\n\n");也不能使用:replaceAll("<br ><br >", "\n\n");
				//只能使用:replaceAll("<br> <br> ", "\n\n")
				String text=links2.get(i).html().replace("&nbsp;","").replaceAll("<br> <br> ", "\n\n");
				ps = new PrintStream(new FileOutputStream(file));
				ps.append("# "+firstLine);
				//添加一行空行
				ps.append("\n\n");
				ps.append(text);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}

	

}
