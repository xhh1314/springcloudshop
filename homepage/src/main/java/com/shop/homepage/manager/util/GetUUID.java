package com.shop.homepage.manager.util;

public class GetUUID {
	
	private static final SnowflakeIdWorker sfid=new SnowflakeIdWorker(1,1);
	
	public static String  getUuid(){
		
		return Double.toString(sfid.nextId());
		//return UUID.randomUUID().toString();
		
	}
	

}
