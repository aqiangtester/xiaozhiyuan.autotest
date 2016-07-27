package cn.com.digiwin.justsharecloud.commonfunctions;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReadExcel {
	public static void prmap(Map<String, String> arr) {
		Set<String> set = arr.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			it.next();
		}
	}
}
