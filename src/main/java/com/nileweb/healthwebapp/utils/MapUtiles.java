package com.nileweb.healthwebapp.utils;

import java.util.Map;
import java.util.stream.Stream;

public class MapUtiles {
	public <K, V> Stream<K> keys(Map<K, V> map, V value) {
	    return map
	      .entrySet()
	      .stream()
	      .filter(entry -> value.equals(entry.getValue()))
	      .map(Map.Entry::getKey);
	}
	public <K,V> K key(Map<K,V> map,V value) {
	Stream<K> keyStream1 = keys(map, value);
	K key = keyStream1.findFirst().get();
	return key;
}
	
}
