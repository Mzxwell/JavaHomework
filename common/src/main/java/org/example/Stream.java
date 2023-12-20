package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Stream {
	public static String getNamesStringImperatively(List<String> nameList) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String name :nameList)
			if(name.length()>1)
				stringBuilder.append(name.substring(0,1).toUpperCase()).append(name.substring(1)).append(",");
		return stringBuilder.isEmpty() ?stringBuilder.toString():stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(
				",")).toString();
	}
	public static String getNamesStringFunctionally(List<String> nameList) {
		return nameList.stream()
				.filter(x->x.length()!=1)
				.map(x->Character.toUpperCase(x.charAt(0))+x.substring(1))
				.collect(Collectors.joining(","));
	}
}
