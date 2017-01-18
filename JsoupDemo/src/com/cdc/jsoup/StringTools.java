package com.cdc.jsoup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StringTools {
	/**
	 * 获取文件路径
	 * 
	 * @param path
	 *            http://www.kanunu8.com/book3/7109/index.html
	 * @return http://www.kanunu8.com/book3/7109/
	 */
	public static String getPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		} else {
			int endPosition = path.lastIndexOf("/");
			return path.substring(0, endPosition + 1);
		}
	}

	/**
	 * 获取文件名
	 * 
	 * @param path
	 *            index.html
	 * @return index
	 */
	public static String getFileName(String path) {
		if (path == null || path.length() == 0) {
			return "";
		} else {
			int endPosition = path.lastIndexOf(".");
			return path.substring(0, endPosition);
		}
	}
	/**去掉字符串里面所有的非汉字内容**/
	public static String clearNotChinese(String buff) {
		String tmpString = buff.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");// 去掉所有中英文符号
		char[] carr = tmpString.toCharArray();
		for (int i = 0; i < tmpString.length(); i++) {
			if (carr[i] < 0xFF) {
				carr[i] = ' ';// 过滤掉非汉字内容
			}
		}
		return String.copyValueOf(carr).trim();
	}
	
	
	public static File writeFile(File file,String str){
		PrintStream ps=null;
		try {
			ps = new PrintStream(new FileOutputStream(file));
			ps.append("# "+file.getName());
			//添加一行空行
			ps.append("\n\n");
			ps.append(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
	}
	
	

}
