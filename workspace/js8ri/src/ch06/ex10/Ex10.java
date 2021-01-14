package ch06.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class Ex10 {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://www.google.com/");

		CompletableFuture<String> contents = readPage(url);
		CompletableFuture<List<URL>> links = contents.thenApply(Ex10::getLinks);
		links.thenAccept(list -> {
			list.forEach(System.out::println);
		});

		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
	}

	/**
	 * Webページのテキストから アンカー要素(A)のリンク属性を取得
	 */
	public static List<URL> getLinks(String page) {
		ArrayList<URL> retVal = new ArrayList<>();

		try (StringReader sr = new StringReader(page)){
			new ParserDelegator().parse(sr, new HTMLEditorKit.ParserCallback(){
				@Override
				public void handleStartTag(HTML.Tag tag, MutableAttributeSet attrs, int pos) {
					if(tag == HTML.Tag.A) {
						try {
							Object href = attrs.getAttribute(HTML.Attribute.HREF);
							retVal.add(new URL(href.toString()));
						} catch (MalformedURLException e) {

						}
					}
				}
			}, true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return retVal;
	}

	/**
	 * WebページからHTMLテキスト取得
	 */
	public static CompletableFuture<String> readPage(URL url) {
		return CompletableFuture.supplyAsync(() -> blockingReadPage(url));
	}

	/**
	 * WebページからHTMLテキスト取得
	 */
	public static String blockingReadPage(URL url) {
		try (InputStream istream = url.openStream()){
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(istream));
			String line = "";
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
