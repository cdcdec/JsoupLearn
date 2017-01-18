package com.cdc.jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class Floder {
	
	/**创建根目录:作者/根目录**/
	public File createRootDir(String authorName,String floderName){
		floderName=StringTools.clearNotChinese(floderName);
		String base="c:/"+authorName+"/"+floderName;
		File dir=new File(base);
		if(!dir.isDirectory() || !dir.exists()){
			 dir.mkdirs();
		}
		return dir;
	}
	
	public File createFloder(String name,String floderName){
		name=StringTools.clearNotChinese(name);
		System.out.println("改变后="+name);
		File file=null;
		boolean bl=false;
		PrintStream ps=null;
		String base="c:/"+floderName;
		File dir=new File(base);
		if(!dir.isDirectory() || !dir.exists()){
			 bl=dir.mkdirs();
		}
		if(dir.exists() || bl){
			//文件名字中含有特殊符号的会报错
			file=new File(dir.getAbsoluteFile()+"/"+name+".md");
			if(!file.exists()){
				try {
					boolean b=file.createNewFile();
					if(b){
						ps = new PrintStream(new FileOutputStream(file)); 
						ps.println("# "+name);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					ps.flush();
					ps.close();
				}
			}
		}
		return file;
		
		
	}

}
