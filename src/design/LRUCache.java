package design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class Node {
	public int key;
	public int value;
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
public class LRUCache {
	private int capacity;
	private Set<Node> cache = new LinkedHashSet();
	private Map<Integer, Node> keyToNode = new HashMap<>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if(!keyToNode.containsKey(key)) 
			return -1;
		
		Node node = keyToNode.get(key);
		cache.remove(node);
		cache.add(node);
		return node.value;
	}
	
	public void put(int key, int value) {
		if(keyToNode.containsKey(key)) {
			Node node = keyToNode.get(key);
			node.value = value;
			get(key);
		}
		
		if(keyToNode.size() == capacity) {
			
		}
		
		
	}
	
}
