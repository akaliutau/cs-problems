package org.problems.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * 
 */
public class DessertMachine {
	
	static class MenuOption {
		private String name;
		private String[] components;
		
		public MenuOption(String name, String components) {
			this.name = name;
			this.components = components.split(","); 
			Arrays.parallelSort(this.components);
		}
		
		public String process(String[] order) {
			Set<String> allerg = new HashSet<>();
			for (int i = 1; i < order.length; i++) {
				String input = order[i].trim().toLowerCase();
				if (input.startsWith("-")) {
					allerg.add(input.substring(1));
				}else {
					throw new IllegalArgumentException("Invalid ingredient:" + input); 
				}
			}
			return Arrays.stream(components).filter(c -> !allerg.contains(c)).collect(Collectors.joining(","));
		}
	}
	
	static Map<String, MenuOption> menu = new HashMap<>();
	static {
		menu.put("Classic", new MenuOption("Classic", "strawberry,banana,pineapple,mango,peach,honey"));
		menu.put("Freezie", new MenuOption("Freezie", "blackberry,blueberry,black currant,grape juice,frozen yogurt"));
		menu.put("Greenie", new MenuOption("Greenie", "green apple,lime,avocado,spinach,ice,apple juice"));
		menu.put("Just Desserts", new MenuOption("Just Desserts", "banana,ice cream,chocolate,peanut,cherry"));
	}
	
	
    public static String ingredients(String order) {
    	if (order == null || order.isEmpty()) {
    		throw new IllegalArgumentException("Invalid order:" + order);
    	}
    	String[] or = order.split(",");
    	String smoothie = or[0].trim();
    	if (!menu.containsKey(smoothie)) {
    		throw new IllegalArgumentException("Invalid smoothie:" + smoothie);
    	}
        return menu.get(smoothie).process(or);
    }
	
	public static void main(String[] arg) {
		System.out.println(true);
	}

}
