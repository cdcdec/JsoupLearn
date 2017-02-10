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
 * 采集http://guoxue.lishichunqiu.com/shibu/qingshigao/
 * 清史稿
 * @author cdc
 *
 */
public class JSOUP3 {
	
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
			titleName=titleName+getDetailTitle(titleHref);
			System.out.println(titleName+" "+titleHref);
			File ttFile=floder.createFile(file, titleName);
			ps.append("\n\n");
			ps.append("["+ttFile.getName()+"]("+ttFile.getName()+")");
			getText(titleHref, ttFile);
		}
		
		return str; 
	}
	
	public String getDetailTitle(String htmlUrl){
		Document doc=getDoc(htmlUrl);
		String str="";
		Element element=doc.getElementById("content");
		if(element.select("strong").size()>0){
			str=doc.getElementById("content").getElementsByTag("strong").get(0).text();
			if(str.length()>45){
				str=str.substring(0, 45)+"等";
			}
			return str;
		}
		if(element.select("p").size()>0){
			str=doc.getElementById("content").getElementsByTag("p").get(0).text();
			if(str.length()>45){
				str=str.substring(0, 45)+"等";
			}
			return str;
		}
		return "";
	}
	
	
	public void getText(String htmlUrl,File file){
		PrintStream ps=null;
		try {
			ps = new PrintStream(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc=getDoc(htmlUrl);
		Element element=doc.getElementById("content");
		element.select("h2").remove();
		element.select("p").remove();
		element.select("div[style=border-bottom: 1px solid rgb(221, 221, 221); text-align: center;]").remove();
		element.select("table").remove();
		element.select("div[class=prenext]").remove();
		Elements divs=element.getElementsByTag("div");
		for (int i = 0; i < divs.size(); i++) {
			String sss=divs.get(i).text();
			//添加一行空行
			ps.append("\n\n");
			ps.append(sss);
		}
	}


}
