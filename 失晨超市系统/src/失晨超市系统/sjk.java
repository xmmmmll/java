package ʧ������ϵͳ;

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
			// ��ȡ���ݿ�����
			con = DriverManager.getConnection(url, username, password);
			// �������ݿ�
			sta = con.createStatement();
			if (t == 0) {
				System.out.println("��ѡ����Ҫ���еĲ���:1.��½  2.ע��");
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
		System.out.println("�����������˺�");
		sr = sc.nextInt();
		sc.nextLine();
		String sql = "select * from a where �˺�=";
		sql = sql + sr;
		try {
			res = sta.executeQuery(sql);
			while (res.next()) {
				zh = res.getString("�˺�");
				mm = res.getString("����");
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (zh != null) {
			System.out.println("��������������:");
			sr2 = sc.nextLine();
			if (sr2.equals(mm)) {
				System.out.println("������ȷ����½�ɹ�");
				return 'y';
			} else {
				System.out.println("��������½ʧ��");
				return 'n';
			}
		} else {
			System.out.println("�˺Ų����ڣ�����������");
			return 'n';
		}
	}

	public static char zc() {
		System.out.println("��������Ҫע����˺�");
		sr = sc.nextInt();
		sc.nextLine();
		String sql = "select * from a where �˺�=";
		sql = sql + sr;
		try {
			res = sta.executeQuery(sql);
			while (res.next()) {
				zh = res.getString("�˺�");
				mm = res.getString("����");
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (zh == null) {
			System.out.println("�˺ſ��ã����������룺");
			sr2 = sc.nextLine();
			String sql2 = "insert into a(�˺�,����,���,����)values (";
			sql2 = sql2 + sr + "," + sr2 + ",0,0)";
			try {
				sta.executeUpdate(sql2);
				res = sta.executeQuery(sql);
				while (res.next()) {
					zh = res.getString("�˺�");
					mm = res.getString("����");
				}

				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 'y';
		} else {
			zh = null;
			System.out.println("�˺Ų����ã�������ע��");
			return 'n';
		}
	}

	public static double ye() {
		ye = 0.0;
		String sql = "select ���  from a where �˺�=";
		sql = sql + sr;
		try {
			res = sta.executeQuery(sql);
			while (res.next()) {
				ye = res.getDouble("���");
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ye;
	}

	public static int jf() {
		jf = 0;
		String sql = "select ���� from a where �˺�=";
		sql = sql + sr;
		try {
			res = sta.executeQuery(sql);
			while (res.next()) {
				jf = res.getInt("����");
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jf;
	}

	public static void fh(double ye, int jf) {
		String sql = "update a set ���=";
		sql = sql + ye + ",����=" + jf + " where �˺�=" + zh;
		try {
			sta.executeUpdate(sql);
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void sjk2() {

		try {
			// ��ȡ���ݿ�����
			con = DriverManager.getConnection(url, username, password);
			// �������ݿ�
			sta = con.createStatement();
			String cxhj = "select * from b";
			res = sta.executeQuery(cxhj);
			while (res.next()) {
				String xh = res.getString("���");
				String mc = res.getString("����");
				String xg = res.getString("�۸�");
				sl = res.getInt("����");

				// �������
				System.out.print("��ţ�" + xh + "|");
				System.out.print("���ƣ�" + mc + "|");
				System.out.print("�۸�" + xg + "|");
				System.out.print("��棺" + sl + "|");
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
			// ��ȡ���ݿ�����
			con = DriverManager.getConnection(url, username, password);
			// �������ݿ�
			sta = con.createStatement();
			String cxhj = "select ���,����  from b";
			res = sta.executeQuery(cxhj);
			while (res.next()) {
				int xh = res.getInt("����");
				sl = res.getInt("����");
				sl -= a;
				System.out.print("��棺" + sl + "|");
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
			// ��ȡ���ݿ�����
			con = DriverManager.getConnection(url, username, password);
			// �������ݿ�
			sta = con.createStatement();
			String sql = "update c set ����=";
			sql = sql + b + " where ���=" + a;
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
			// ��ȡ���ݿ�����
			con = DriverManager.getConnection(url, username, password);
			// �������ݿ�
			sta = con.createStatement();
			String sql = "update c set ����=0";
			sta.executeUpdate(sql);
			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
