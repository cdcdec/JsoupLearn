package com.cdc.jsoup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSOUP2{
	
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
		//获取:<h1><strong><font color="#dc143c">人在欧洲</font></strong></h1>中的"人在欧洲"
		Elements arTitle = doc.select("h1>strong>font[color=#dc143c]");
		floder=new Floder();
		floder.createRootDir("", arTitle.get(0).text());
		//<td class="p10-24"><strong>内容简介：</strong><br />　　《人在欧洲》是龙应台旅瑞一年多的心路...</td>
		Elements arDesc = doc.select("td.p10-24");//只能获取"内容简介："
		
		System.out.println(arDesc.get(0).html());
		
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
