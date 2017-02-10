package com.cdc.jsoup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * 采集http://guoxue.lishichunqiu.com/shibu/shiji/
 * 史记
 * http://guoxue.lishichunqiu.com/shibu/hanshu/
 * 汉书
 * http://guoxue.lishichunqiu.com/shibu/houhanshu/
 * 后汉书
 * http://guoxue.lishichunqiu.com/shibu/jinshu/
 * 晋书
 * @author cdc
 *
 */
public class JSOUP4 {
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
	
	@SuppressWarnings("resource")
	public  String  getTable(String htmlUrl,String floderName){
		PrintStream ps=null;
		File file=new File("c://"+floderName);
		if(!file.exists() || !file.isDirectory()){
			
				file.mkdirs();
			
		}
		File tFile=new File(file.getAbsolutePath()+"/"+floderName+".md");
		if(!tFile.exists() || !tFile.isFile()){
			try {
				tFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Floder  floder=null;
		Document doc=getDoc(htmlUrl);
		String str="";
		Elements pps=doc.select("div.jj960>p");
		try {
			ps = new PrintStream(new FileOutputStream(tFile));
			ps.append("# "+floderName);
			//添加一行空行
			ps.append("\n\n");
			ps.append("## 简介");
			ps.append("\n\n");
			for (int i = 0; i < pps.size(); i++) {
				String ss=pps.get(i).text();
				ps.append(ss);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//900917068090
		Elements titles=doc.select("a[style=font:14px/24px '宋体';]");
		floder=new Floder();
		for (int i = 0; i < titles.size(); i++) {
			String titleName=titles.get(i).text();
			String titleHref=titles.get(i).absUrl("href");
			System.out.println(titleName+" "+titleHref);
			File ttFile=floder.createFile(file, titleName);
			ps.append("\n\n");
			ps.append("["+ttFile.getName().replaceAll(".md", "")+"___]("+ttFile.getName()+")");
			getText(titleHref, ttFile);
		}
		
		return str; 
	}
	
	
	
	public void getText(String htmlUrl,File file){
		PrintStream ps=null;
		try {
			ps = new PrintStream(new FileOutputStream(file));
			ps.append("# "+file.getName().replaceAll(".md", ""));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc=getDoc(htmlUrl);
		Element element=doc.getElementById("content");
		element.select("span").remove();
		element.select("table").remove();
		element.select("div[class=prenext]").remove();
		String tempHtml=element.html();
		tempHtml=tempHtml.replaceAll("<br>", "</p><p>");
		Document doc2 = Jsoup.parseBodyFragment(tempHtml);
		Elements pps = doc2.getElementsByTag("p");
		for (int i = 0; i < pps.size(); i++) {
			//添加一行空行
			ps.append("\n\n");
			String sss=pps.get(i).text();
			ps.append(sss);
		}
	}


}
