package com.itheima;

import java.util.ArrayList;
import java.util.List;

public class 排序 {
/**
 * 2.1  用  1,2 , 2 ,3, 4 ,5  这 6 6  个数字,  用  Java  写一个  main  函数,  打印出所有不同的排列,  如:
 512234, 412345  等,  要求: “ “4 4” ” 不能在第三位, “ “3 ” ” 与” ” 5” ” 不能相连
 */
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(2);
		list.add(1);
		int temp = 1;
		ArrayList<ArrayList<Integer>> method = method(list);
		for (ArrayList<Integer> arrayList : method) {
			System.out.print(toArr(arrayList));
			System.out.print("        ");
			if(temp%6==0) {
				System.out.println();
			}
			temp++;
		}
		System.out.println(temp-1);
	}
	
	public static String toArr(ArrayList<Integer> array) {
		StringBuilder sb = new StringBuilder();
		for (Integer integer : array) {
			sb.append(""+integer);
		}
		return sb.toString();
	}
	
	public static ArrayList<ArrayList<Integer>> method(ArrayList<Integer> list){		
		
		ArrayList<ArrayList<Integer>> last = new ArrayList<>(0);
		
		if(list.size()==0) {
			ArrayList<Integer> array1 = new ArrayList<>();
			array1.add(3);
			array1.add(2);
			array1.add(5);
			ArrayList<Integer> array2 = new ArrayList<>();
			array2.add(5);
			array2.add(2);
			array2.add(3);
			ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
			list2.add(array1);
			list2.add(array2);
			last = list2;
		}
		if(list.size()>0) {
			int temp = list.get(0); 
			list.remove(0);		
			for (ArrayList<Integer> arrayList : method(list)) {
				for(int i=0;i<=arrayList.size();i++) {
					if(temp==1) {
						ArrayList<Integer> templist = new ArrayList<>();
						templist.addAll(arrayList);
						templist.add(i, temp);
						last.add(templist);
						}
					if(temp==2) {
						int index = arrayList.indexOf(2);
						if(i==index+1) {
							continue;
						}
						ArrayList<Integer> templist = new ArrayList<>();
						templist.addAll(arrayList);
						templist.add(i, temp);
						last.add(templist);
					}
					if(temp==4) {
						if(i==2) {
							continue;
						}
						ArrayList<Integer> templist = new ArrayList<>();
						templist.addAll(arrayList);
						templist.add(i, temp);
						last.add(templist);
					}
				}
			}
		}			
		return last;
	}
	
}

/*if(temp==1) {
	ArrayList<Integer> templist = new ArrayList<>();
	templist.addAll(arrayList);
	templist.add(i, temp);
//	arrayList.add(i, temp);
//	System.out.println(toArr(arrayList));
	last.add(templist);
//	arrayList.remove(i);
	for (ArrayList<Integer> a : last) {
		System.out.println(toArr(a));
	}*/
