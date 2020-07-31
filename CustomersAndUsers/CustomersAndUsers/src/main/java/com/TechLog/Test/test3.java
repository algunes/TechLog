package com.TechLog.Test;
import java.util.*;
import java.util.stream.Collectors;

public class test3 {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("aliyargunes@gmail.com");
		list.add("aliyargunes2@gmail.com");
		
		List<String> result = list.stream()
			     .filter(t -> t.equals("aliyargunes2@gmail.com"))
			     .collect(Collectors.toList());
		
		if(list.contains("aliyargunes2@gmail.com")) {
		for(String s: list) {
			System.out.println(s);
		}
		}
		else {
			System.out.println("Nothing found!");
		}
	
		
	}

}
