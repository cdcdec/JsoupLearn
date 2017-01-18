package com.cdc.main;

import com.cdc.jsoup.JSOUP;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSOUP jsoup=new JSOUP();
		jsoup.getTable("http://www.kanunu8.com/book/3676/","龙应台/孩子你慢慢来");

	}

}
