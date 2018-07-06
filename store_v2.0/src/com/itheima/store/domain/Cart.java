package com.itheima.store.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private double total = 0d;
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	
	public double getTotal() {
		return total;
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	//��ӹ��ﳵ
	public void addCart(CartItem cartItem) {
		String pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)) {
			map.get(pid).setCount(map.get(pid).getCount()+cartItem.getCount());  
		}else {
			map.put(pid, cartItem);
		}
		total+=cartItem.getSubTotal();	
	}
	
	//�ӹ��ﳵ���Ƴ�ĳ����Ʒ
	public void removeCart(String pid) {
		CartItem cartItem = map.remove(pid);
		total-=cartItem.getSubTotal();
	}	
	
	//��չ��ﳵ
	public void clearCart() {
		map.clear();
		total = 0d;
	}
}
