# JsoupDemo

>http://www.kanunu8.com/,采集"努努书坊"中的某一部小说

## 先获取要采集的小说的章节信息(从类似html1.txt中获得),并建立文件,文件的名称是:章节名+.md;

## 从类似html2.txt的文件中,将这一章节的内容写到上面一步所建立的文件中.


### 调用方法

```txt
//采集"血玲珑"这部小说,将采集到的内容保存在c盘的"血玲珑"文件夹下,且将每一章的内容以md文件的形式保存。
JSOUP1 jsoup=new JSOUP1();
jsoup.getTable("http://www.kanunu8.com/book/4333/","血玲珑");


```

>1.https://my.oschina.net/flashsword/blog?catalog=390084



## 采集历史春秋上面的史书
```txt

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



```



