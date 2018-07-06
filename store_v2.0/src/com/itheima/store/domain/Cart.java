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

	//添加购物车
	public void addCart(CartItem cartItem) {
		String pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)) {
			map.get(pid).setCount(map.get(pid).getCount()+cartItem.getCount());  
		}else {
			map.put(pid, cartItem);
		}
		total+=cartItem.getSubTotal();	
	}
	
	//从购物车中移除某个商品
	public void removeCart(String pid) {
		CartItem cartItem = map.remove(pid);
		total-=cartItem.getSubTotal();
	}	
	
	//清空购物车
	public void clearCart() {
		map.clear();
		total = 0d;
	}
}
