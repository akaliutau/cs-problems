package org.problems.regex;

/**
 * 	https://leetcode.com/problems/html-entity-parser/
 * 
 */
public class HtmlEntityParser {
	
	public static String entityParser(String text) {
		String[] replace = {"&quot;","&apos;","&gt;","&lt;","&frasl;","&amp;"};
		String[] replaceTo = {"\"","'",">","<","/","&"};
		for (int i = 0; i < 6; i++) {
			text = text.replace(replace[i], replaceTo[i]);
		}
		
		return text;
	}

	public static void main(String[] arg) {

		System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
		System.out.println(entityParser("and I quote: &quot;...&quot;"));
		System.out.println(entityParser("Stay home! Practice on Leetcode :)"));
		System.out.println(entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
		System.out.println(entityParser("leetcode.com&frasl;problemset&frasl;all"));
	}

}

