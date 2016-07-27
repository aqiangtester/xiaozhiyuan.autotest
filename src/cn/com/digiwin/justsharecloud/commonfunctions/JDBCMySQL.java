package cn.com.digiwin.justsharecloud.commonfunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import cn.com.digiwin.justsharecloud.constants.Constants;

public class JDBCMySQL {

	private static Logger logger = Logger.getLogger(JDBCMySQL.class);
	private static String url = Constants.LOCAL_TEST_MYSQL_URL;
	private static String user = Constants.LOCAL_TEST_MYSQL_USERNAME;
	private static String pwd = Constants.LOCAL_TEST_MYSQL_PASSWORD;
	private static Connection conn = null;
	private static Statement stat = null;

	private static void connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, pwd);
		stat = conn.createStatement();
	}

	public static void delete(String sql) {

		try {
			connect();
			int rs = stat.executeUpdate(sql);
			if (!(rs > 0)) {
				logger.info("删除成功! sql : " + sql);
			} else {
				logger.info("库表没有此记录! sql : " + sql);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				stat = null;
			}
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	public static int query(String sql) {
		int business_type = 0;
		try {
			connect();
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				business_type = rs.getInt("business_type");
				logger.info("business_type 为 " + business_type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				stat = null;
			}
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				conn = null;
			}
		}
		return business_type;
	}
}
