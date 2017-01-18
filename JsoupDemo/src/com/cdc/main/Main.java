package com.cdc.main;

import com.cdc.jsoup.JSOUP2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSOUP2 jsoup=new JSOUP2();
		jsoup.getTable("http://www.kanunu8.com/book/3674/","龙应台","人在欧洲");

	}

}
