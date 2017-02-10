package com.cdc.main;

import com.cdc.example.ListLinks;
import com.cdc.jsoup.JSOUP1;
import com.cdc.jsoup.JSOUP2;
import com.cdc.jsoup.JSOUP3;
import com.cdc.jsoup.JSOUP4;
import com.cdc.jsoup.JSOUP5;
import com.cdc.jsoup.JSOUP6;

public class Main {

	private static int a = 5;

	public static void main(String[] args) {

		switch (a) {

		case 0:
			ListLinks links = new ListLinks();
			links.test("https://my.oschina.net/flashsword/blog?catalog=390084");

			break;
		case 1:
			JSOUP1 jsoup1 = new JSOUP1();
			jsoup1.getTable("http://www.kanunu8.com/book/4347/", "中国之旅");

			break;

		case 2:
			JSOUP2 jsoup = new JSOUP2();
			jsoup.getTable("http://www.kanunu8.com/book/3674/", "龙应台", "人在欧洲");
			break;
		case 3:
			JSOUP3 jsoup3 = new JSOUP3();
			jsoup3.getTable("http://guoxue.lishichunqiu.com/shibu/qingshigao/",
					"清史稿");
			break;

		case 4:
			JSOUP4 jsoup4 = new JSOUP4();
			jsoup4.getTable("http://guoxue.lishichunqiu.com/shibu/shiji/", "史记");
			jsoup4.getTable("http://guoxue.lishichunqiu.com/shibu/hanshu/",
					"汉书");
			jsoup4.getTable("http://guoxue.lishichunqiu.com/jingbu/lunyu/",
					"论语");
			jsoup4.getTable("http://guoxue.lishichunqiu.com/shibu/suishu/",
					"隋书");
			jsoup4.getTable("http://guoxue.lishichunqiu.com/shibu/xintangshu/",
					"新唐书");

			break;
		case 5:
			JSOUP5 jsoup5 = new JSOUP5();
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/houhanshu/",
					"后汉书");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/sanguozhi/",
					"三国志");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/songshu/",
					"宋书");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/nanqishu/",
					"南齐书");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/liangshu/",
					"梁书");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/chenshu/",
					"陈书");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/weishu/",
					"魏书");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/beiqishu/",
					"北齐书");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/zhoushu/",
					"周书");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/nanshi/",
					"南史");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/beishi/",
					"北史");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/jiutangshu/",
					"旧唐书");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/jwds/",
					"旧五代史");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/xwds/",
					"新五代史");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/songshi/",
					"宋史");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/liaoshi/",
					"辽史");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/jinshi/",
					"金史");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/yuanshi/",
					"元史");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/mingshi/",
					"明史");
			jsoup5.getTable("http://guoxue.lishichunqiu.com/shibu/xinyuanshi/",
					"新元史");
			break;
			
		case 6:
			JSOUP6 jsoup6=new JSOUP6();
			jsoup6.getTable("http://guoxue.lishichunqiu.com/shibu/", "中国古代史");
			break;

		default:
			break;
		}

	}

}
