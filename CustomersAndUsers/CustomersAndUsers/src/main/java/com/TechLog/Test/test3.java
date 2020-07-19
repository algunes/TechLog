package com.TechLog.Test;
import java.util.*;
import java.util.stream.Collectors;

public class test3 {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("aliyargunes@gmail.com");
		list.add("aliyargunes2@gmail.com");
		
		List<String> result = list.stream()
			     .filter(t -> t.equals("aliyargunes@gmail.com"))
			     .collect(Collectors.toList());
		
		for(String s: result) {
			System.out.println(s);
		}
		
		boolean b = list.stream()
			     .filter(t -> t.equals("aliyargunes@gmail.com"))
			     .is;
		
	}

}
