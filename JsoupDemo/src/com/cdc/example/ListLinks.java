package com.cdc.example;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class ListLinks {

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	public void test(String url) {
		try {
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[href]");
			Elements media = doc.select("[src]");
			Elements imports = doc.select("link[href]");

			print("\nMedia: (%d)", media.size());
			for (Element src : media) {
				if (src.tagName().equals("img"))
					print(" * %s: <%s> %sx%s (%s)", src.tagName(),
							src.attr("abs:src"), src.attr("width"),
							src.attr("height"), trim(src.attr("alt"), 20));
				else
					print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
			}

			print("\nImports: (%d)", imports.size());
			for (Element link : imports) {
				print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"),
						link.attr("rel"));
			}

			print("\nLinks: (%d)", links.size());
			for (Element link : links) {
				print(" * a: <%s>  (%s)", link.attr("abs:href"),
						trim(link.text(), 35));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
