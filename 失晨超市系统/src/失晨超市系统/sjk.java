package 失晨超市系统;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class sjk {
	static Scanner sc = new Scanner(System.in);
	static Connection con;
	static Statement sta;
	static ResultSet res;
	static String mm = null, zh, sr2 = null;
	static int sl, sr;
	static double ye;
	static int jf;
	static String url = "jdbc:mysql://localhost:3306/text1";
	static String username = "root";
	static String password = "123456";

	public static char sjk1(int t, double ye, int jf) {

		char a = 'n';

		try {
			// 获取数据库连接
			con = DriverManager.getConnection(url, username, password);
			// 操作数据库
			sta = con.createStatement();
			if (t == 0) {
				System.out.println("请选择您要进行的操作:1.登陆  2.注册");
				int xz = sc.nextInt();
				if (xz == 1) {
					a = dl();
				} else if (xz == 2) {
					a = zc();
				}
				if (a == 'y') {
					ye = ye();
					jf = jf();
				}
			} else if (t == 1) {
				fh(ye, jf);
			}
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	public static char dl() {
		System.out.println("请输入您的账号");
		sr = sc.nextInt();
		sc.nextLine();
		String sql = "select * from a where 账号=";
		sql = sql + sr;
		try {
			res = sta.executeQuery(sql);
			while (res.next()) {
				zh = res.getString("账号");
				mm = res.getString("密码");
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (zh != null) {
			System.out.println("请输入您的密码:");
			sr2 = sc.nextLine();
			if (sr2.equals(mm)) {
				System.out.println("密码正确，登陆成功");
				return 'y';
			} else {
				System.out.println("密码错误登陆失败");
				return 'n';
			}
		} else {
			System.out.println("账号不存在，请重新输入");
			return 'n';
		}
	}

	public static char zc() {
		System.out.println("请输入您要注册的账号");
		sr = sc.nextInt();
		sc.nextLine();
		String sql = "select * from a where 账号=";
		sql = sql + sr;
		try {
			res = sta.executeQuery(sql);
			while (res.next()) {
				zh = res.getString("账号");
				mm = res.getString("密码");
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (zh == null) {
			System.out.println("账号可用，请输入密码：");
			sr2 = sc.nextLine();
			String sql2 = "insert into a(账号,密码,余额,积分)values (";
			sql2 = sql2 + sr + "," + sr2 + ",0,0)";
			try {
				sta.executeUpdate(sql2);
				res = sta.executeQuery(sql);
				while (res.next()) {
					zh = res.getString("账号");
					mm = res.getString("密码");
				}

				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 'y';
		} else {
			zh = null;
			System.out.println("账号不可用，请重新注册");
			return 'n';
		}
	}

	public static double ye() {
		ye = 0.0;
		String sql = "select 余额  from a where 账号=";
		sql = sql + sr;
		try {
			res = sta.executeQuery(sql);
			while (res.next()) {
				ye = res.getDouble("余额");
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ye;
	}

	public static int jf() {
		jf = 0;
		String sql = "select 积分 from a where 账号=";
		sql = sql + sr;
		try {
			res = sta.executeQuery(sql);
			while (res.next()) {
				jf = res.getInt("积分");
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jf;
	}

	public static void fh(double ye, int jf) {
		String sql = "update a set 余额=";
		sql = sql + ye + ",积分=" + jf + " where 账号=" + zh;
		try {
			sta.executeUpdate(sql);
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void sjk2() {

		try {
			// 获取数据库连接
			con = DriverManager.getConnection(url, username, password);
			// 操作数据库
			sta = con.createStatement();
			String cxhj = "select * from b";
			res = sta.executeQuery(cxhj);
			while (res.next()) {
				String xh = res.getString("序号");
				String mc = res.getString("名称");
				String xg = res.getString("价格");
				sl = res.getInt("数量");

				// 输出数据
				System.out.print("序号：" + xh + "|");
				System.out.print("名称：" + mc + "|");
				System.out.print("价格：" + xg + "|");
				System.out.print("库存：" + sl + "|");
				System.out.println();
			}
			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void qh(int a) {

		try {
			// 获取数据库连接
			con = DriverManager.getConnection(url, username, password);
			// 操作数据库
			sta = con.createStatement();
			String cxhj = "select 序号,数量  from b";
			res = sta.executeQuery(cxhj);
			while (res.next()) {
				int xh = res.getInt("数量");
				sl = res.getInt("数量");
				sl -= a;
				System.out.print("库存：" + sl + "|");
				System.out.println();
			}
			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void gwc(int a, int b) {

		try {
			// 获取数据库连接
			con = DriverManager.getConnection(url, username, password);
			// 操作数据库
			sta = con.createStatement();
			String sql = "update c set 数量=";
			sql = sql + b + " where 序号=" + a;
			sta.executeUpdate(sql);
			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void gwcqk() {

		try {
			// 获取数据库连接
			con = DriverManager.getConnection(url, username, password);
			// 操作数据库
			sta = con.createStatement();
			String sql = "update c set 数量=0";
			sta.executeUpdate(sql);
			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
