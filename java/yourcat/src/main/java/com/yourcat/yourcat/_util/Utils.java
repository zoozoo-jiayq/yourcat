package com.yourcat.yourcat._util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {

	/*
	 * 将输入MAP，按照key值排序，按照key顺序输出querystring
	 */
	public static String generateQueryStringByOrder(Map<String,String> map){
		StringBuffer sb = new StringBuffer("");
		Set<String> keys = map.keySet();
		List<String> keylist = new ArrayList<String>();
		keylist.addAll(keys);
		Collections.sort(keylist);
		for(Iterator<String> it = keylist.iterator(); it.hasNext();){
			String key = it.next();
			Object value = map.get(key);
			sb.append(key+"="+value);
			if(it.hasNext()){
				sb.append("&");
			}
		}
		return sb.toString();
	}
	
	//将字符串MD5签名，输出16进制字符串
	public static String md5(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
			byte[] bs = messageDigest.digest();
			StringBuffer result = new StringBuffer();
			for(int i=0; i<bs.length; i++) {
				String h = Integer.toHexString(0xFF & bs[i]);
				if(h.length()==1) {
					result.append("0"+h);
				}else {
					result.append(h);
				}
			}
			return result.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
