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
 * 获取历史春秋  史部目录
 * http://guoxue.lishichunqiu.com/shibu/
 * 
 * @author cdc
 *
 */
public class JSOUP6 {
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
		
		Document doc=getDoc(htmlUrl);
		String str="";
		//<td style="line-height: 22px; font-size: 16px; text-align: center;" height="32" width="34%">
		Elements pps=doc.select("td[style=line-height: 22px; font-size: 16px; text-align: center;]");
		try {
			ps = new PrintStream(new FileOutputStream(tFile));
			ps.append("# "+floderName);
			//添加一行空行
			ps.append("\n\n");
			ps.append("## 中国古代史目录");
			ps.append("\n\n");
			for (int i = 0; i < pps.size(); i++) {
				String ss=pps.get(i).text();
				ss=ss.replaceAll("《", "");
				ss=ss.replaceAll("》", "");
				ps.append("\n\n");
				ps.append("["+ss+"]("+ss+"/"+ss+".md)___");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str; 
	}
	
	



}
