package seminar.sample.C3.guava;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

public class StringSample {

	public static void main(String[] args) {
		// Joinerのサンプル
		joinerSample();

		// Splitterのサンプル
		splitterSample();

		// CharMatcherのサンプル
		charMatcherSample();

		// CaseFormatのサンプル
		caseFormatSample();

		// Stringsのサンプル
		stringsSample();
	}

	private static void joinerSample() {
		List<String> items = Arrays.asList("Apple", "Banana", "Orange", null, "Grape");
		String result = Joiner.on(", ").skipNulls().join(items);
		System.out.println("Joiner Result: " + result);
	}

	private static void splitterSample() {
		String input = "Apple, Banana, , Orange, Grape,";
		// 空白無視、結果をtrimして分割
		List<String> result = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(input);
		System.out.println("Splitter Result: " + result);
	}

	private static void charMatcherSample() {
		String input = "a1b2c3d4";
		String digits = CharMatcher.inRange('0', '9').retainFrom(input);
		System.out.println("Digits extracted: " + digits);
	}

	private static void caseFormatSample() {
		String input = "testCaseFormatSample";
		String output = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, input);
		System.out.println("CaseFormat Result: " + output);
	}

	private static void stringsSample() {
		String input = "pad";
		//指定文字数までXで埋める
		String output = Strings.padEnd(input, 6, 'X');
		System.out.println("Strings Result: " + output);
	}
}
