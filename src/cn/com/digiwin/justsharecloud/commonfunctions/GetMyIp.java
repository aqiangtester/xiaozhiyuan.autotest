package cn.com.digiwin.justsharecloud.commonfunctions;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @date 2016年8月15日下午6:04:33
 * @author 田亚强
 * @description 获取本机的ip
 */
public class GetMyIp {

	public static String getMyIp() {
		String myIp = null;
		try {
			myIp = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myIp;
	}
}
