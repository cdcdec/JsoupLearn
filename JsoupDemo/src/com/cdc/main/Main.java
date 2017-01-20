package com.cdc.main;

import com.cdc.example.ListLinks;
import com.cdc.jsoup.JSOUP2;

public class Main {
	
	private static int a=0;

	public static void main(String[] args) {
		
		switch (a) {
		
		case 0:
			ListLinks  links=new ListLinks();
			links.test("https://my.oschina.net/flashsword/blog?catalog=390084");
			
			break;
		case 1:
			
			break;
			
		case 2:
			JSOUP2 jsoup=new JSOUP2();
			jsoup.getTable("http://www.kanunu8.com/book/3674/","龙应台","人在欧洲");
			break;

		default:
			break;
		}
		
		

	}

}
