# JsoupDemo

>http://www.kanunu8.com/,采集"努努书坊"中的某一部小说

## 先获取要采集的小说的章节信息(从类似html1.txt中获得),并建立文件,文件的名称是:章节名+.md;

## 从类似html2.txt的文件中,将这一章节的内容写到上面一步所建立的文件中.


### 调用方法

```txt
//采集"血玲珑"这部小说,将采集到的内容保存在c盘的"血玲珑"文件夹下,且将每一章的内容以md文件的形式保存。
JSOUP jsoup=new JSOUP();
jsoup.getTable("http://www.kanunu8.com/book/4333/","血玲珑");


```



