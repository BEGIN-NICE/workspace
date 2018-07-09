package com.itheima.store.domain;

import com.itheima.store.utils.PaymentUtil;

public class PayBean {
	private final String p0_Cmd = "Buy";
	private final String p1_MerId = "10001126856";
	private String p2_Order;
	//支付金额
	private String p3_Amt;
	private final String p4_Cur = "CNY";
	private final String p8_Url = "http://localhost:8080/store_v2.0/OrderServlet?method=callBack";
	//支付通道编码
	private String pd_FrpId;
	private final String keyValue="69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
	private String hmac;
	public String getP1_MerId() {
		return p1_MerId;
	}

	public String getP2_Order() {
		return p2_Order;
	}
	public void setP2_Order(String p2_Order) {
		this.p2_Order = p2_Order;
	}
	public String getP3_Amt() {
		return p3_Amt;
	}
	public void setP3_Amt(String p3_Amt) {
		this.p3_Amt = p3_Amt;
	}
	public String getP8_Url() {
		return p8_Url;
	}

	public String getHmac() {
		String[] params = {getP0_Cmd(),getP1_MerId(),getP2_Order(),getP3_Amt(),getP4_Cur(),"","","",getP8_Url(),"","",getPd_FrpId(),"",keyValue};
		return PaymentUtil.buildHmac(getP0_Cmd(),getP1_MerId(),getP2_Order(),getP3_Amt(),getP4_Cur(),"","","",getP8_Url(),"","",getPd_FrpId(),"", keyValue);
	}
	
	public String getPd_FrpId() {
		return pd_FrpId;
	}
	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	public String getP0_Cmd() {
		return p0_Cmd;
	}
	public String getP4_Cur() {
		return p4_Cur;
	}

	public String getKeyValue() {
		return keyValue;
	}
	
	

}
