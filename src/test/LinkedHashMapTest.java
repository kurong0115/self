package test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LinkedHashMapTest
 * @Description LinkedHashMap测试
 * @Author Administrator
 * @Date 2019/11/22 14:47
 * @Version 1.0
 */
public class LinkedHashMapTest {

	public static void main(String[] args) {
		Map<String, Object> map = new LinkedHashMap<>(16, 0.75f, true);
		map.put("4", "r");
		map.put("1", "q");
		map.put("2", "w");
		map.put("3", "e");
		traverse(map);
		map.get("1");
		traverse(map);
	}

	public static void traverse(Map<String, Object> map){
		Set<Map.Entry<String, Object>> entries = map.entrySet();
		for (Map.Entry<String, Object> entry: entries){
			System.out.println(entry.getKey() + "--->" + entry.getValue());
		}
	}
}
