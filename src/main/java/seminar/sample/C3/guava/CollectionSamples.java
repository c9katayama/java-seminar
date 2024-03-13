package seminar.sample.C3.guava;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;

@SuppressWarnings("unused")
public class CollectionSamples {

	public static void main(String[] args) {
		CollectionSamples samples = new CollectionSamples();
		samples.immutableCollectionSample();
		samples.tableSample();
		samples.multiSetSample();
		samples.multiMapSample();
	}

	public void immutableCollectionSample() {

		List<String> immutableList = ImmutableList.of("a", "b", "c");

		Set<String> immutableSet = ImmutableSet.of("a", "b", "c");

		Map<String, Integer> immutableMap = ImmutableMap.of("key1", 1, "key2", 2);
	}

	public void tableSample() {
		Table<String, String, Integer> table = HashBasedTable.create();
		// 要素の追加
		table.put("Row1", "Col1", 1);
		table.put("Row1", "Col2", 2);
		table.put("Row2", "Col1", 3);

		// 特定の要素へのアクセス
		Integer value = table.get("Row1", "Col1"); // 1を返す

		// 特定の行や列のすべての要素へのアクセス
		Map<String, Integer> row = table.row("Row1"); // "Row1"のすべての列と値
		Map<String, Integer> column = table.column("Col1"); // "Col1"のすべての行と値

		// 特定の要素の削除
		table.remove("Row1", "Col1");
	}

	public void multiSetSample() {
		Multiset<String> multiset = HashMultiset.create();
		// 要素の追加
		multiset.add("apple");
		multiset.add("apple");
		multiset.add("banana");

		int appleCount = multiset.count("apple"); // 2を返す
		int bananaCount = multiset.count("banana"); // 1を返す
	}

	public void multiMapSample() {
		Multimap<String, BigDecimal> multimap = ArrayListMultimap.create();
		// 要素の追加
		multimap.put("Stock", new BigDecimal("100"));
		multimap.put("Stock", new BigDecimal("200"));
		multimap.put("Stock", new BigDecimal("200"));
		multimap.put("Bond", new BigDecimal("300"));

		// 特定の要素でputされた値の要素のCollection
		Collection<BigDecimal> collection = multimap.get("Stock");// 100,200,200

		// 要素の合計
		BigDecimal total = multimap.get("Stock").stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(total.toPlainString());// 500

	}
}
