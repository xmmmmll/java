package ʧ������ϵͳ;

import java.util.Random;
import java.util.Scanner;

public class Cs {
	int pg = 0, xj = 0, li = 0;
	Scanner sc = new Scanner(System.in);
	sjk sjk = new sjk();

	public Cs() {
	}

	public void show() {
		System.out.println("��ӭ��������");
		System.out.println("1.��ѡ��Ʒ");
		System.out.println("2.���˽���");
		System.out.println("3.���˴�");
		System.out.println("4.��ֵ���");
		System.out.println("5.��ѯ�ʲ�");
		System.out.println("��ѡ����Ҫִ�еĲ��������������������˳�����δ������Ʒ�޷��˳�Ŷ����");
	}

	public void sp() {
		sjk.sjk2();
		System.out.println("��ѡ����Ҫ�������Ʒ�����������������˳�����");

	}

	public double tx(int a, int pg, int xj, int li) {
		int b = 0;
		switch (a) {
		case 1:
			System.out.println("ѡ����һ��ƻ��");
			b = 1;
			break;
		case 2:
			System.out.println("ѡ����һ���㽶");
			b = 2;
			break;
		case 3:
			System.out.println("ѡ����һ����");
			b = 3;
			break;
		}
		if (pg > 0 | xj > 0 | li > 0) {
			System.out.println("��ǰ���ﳵ�У�");
			if (pg > 0) {
				System.out.println(pg + "��ƻ��");
			}
			if (xj > 0) {
				System.out.println(xj + "���㽶");
			}
			if (li > 0) {
				System.out.println(li + "����");
			}
		}
		return b;
	}

	public double je(double je, double b) {
		je = je + b;
		System.out.println("��ǰ��Ʒ��" + je + "Ԫ");
		return je;
	}

	public double ttx(int a, int pg, int xj, int li) {
		int b = 0;
		switch (a) {
		case 1:
			System.out.println("ȥ����һ��ƻ��");
			b = 1;
			break;
		case 2:
			System.out.println("ȥ����һ���㽶");
			b = 2;
			break;
		case 3:
			System.out.println("ȥ����һ����");
			b = 3;
			break;
		}
		if (pg > 0 | xj > 0 | li > 0) {
			System.out.println("��ǰ���ﳵ�У�");
			if (pg > 0) {
				System.out.println(pg + "��ƻ��");
			}
			if (xj > 0) {
				System.out.println(xj + "���㽶");
			}
			if (li > 0) {
				System.out.println(li + "����");
			}
		}
		return -b;
	}

	public double zf(double ye, double je) {
		ye -= je;
		System.out.println("֧���ɹ���ʣ�����" + ye);
		System.out.println("��û��֣�" + je);
		pg = 0;
		xj = 0;
		li = 0;
		return ye;
	}

	public int dj(int jf, double ye) {
		Random random = new Random();
		System.out.println("��ǰ����" + jf);
		System.out.println("����Ϊ100Ԫ���н�����Ϊ5%");
		System.out.println("�齱��Ҫ����10���֣���1ȷ�ϳ齱�����������˳�");
		int a = sc.nextInt();
		if (a == 1) {
			if (jf >= 10) {
				jf -= 10;
				int num1 = random.nextInt(20) + 1;
				int num2 = random.nextInt(20) + 1;
				if (num1 == num2) {
					ye += 100;
					System.out.println("��ϲ���н�����100Ԫ����ֵ�ɹ�����ǰ���" + ye);
				} else {
					System.out.println("���ź�û���н���");
				}
			} else {
				System.out.println("���ֲ��㣬������Ѱ�");
			}
		}
		return jf;
	}

	public double gw(int c, double d, double je, double ye) {
		sp();
		c = sc.nextInt();

		while (c >= 1 & c <= 3) {
			switch (c) {
			case 1:
				pg++;
				d = tx(c, pg, xj, li);
				je = je(je, d);
				sjk.gwc(c, pg);
				for (; je > ye;) {
					System.out.println("��ܰ��ʾ���������㣬��ȥ��������Ʒ");
					c = sc.nextInt();
					switch (c) {
					case 1:
						if (pg > 0) {
							pg--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("��ǰ���ﳵû��ƻ����������ѡ��Ҫȥ������Ʒ");
						}
						break;
					case 2:
						if (xj > 0) {
							xj--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("��ǰ���ﳵû���㽶��������ѡ��Ҫȥ������Ʒ");
						}
						break;
					case 3:
						if (li > 0) {
							li--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("��ǰ���ﳵû���棬������ѡ��Ҫȥ������Ʒ");
						}
						break;
					}
				}
				System.out.println("������ѡ��1.ƻ�� ��1  2.�㽶  ��2 3.��  ��3�������ַ��˳�����");
				c = sc.nextInt();
				break;
			case 2:
				xj++;
				d = tx(c, pg, xj, li);
				je = je(je, d);
				sjk.gwc(c, xj);
				for (; je > ye;) {
					System.out.println("��ܰ��ʾ���������㣬��ȥ��������Ʒ");
					c = sc.nextInt();
					switch (c) {
					case 1:
						if (pg > 0) {
							pg--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);

						} else {
							System.out.println("��ǰ���ﳵû��ƻ����������ѡ��Ҫȥ������Ʒ");
						}
						break;
					case 2:
						if (xj > 0) {
							xj--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("��ǰ���ﳵû���㽶��������ѡ��Ҫȥ������Ʒ");
						}
						break;
					case 3:
						if (li > 0) {
							li--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("��ǰ���ﳵû���棬������ѡ��Ҫȥ������Ʒ");
						}
						break;
					}
				}
				System.out.println("������ѡ��1.ƻ�� ��1  2.�㽶  ��2 3.��  ��3�������ַ��˳�����");
				c = sc.nextInt();
				break;
			case 3:
				li++;
				d = tx(c, pg, xj, li);
				je = je(je, d);
				sjk.gwc(c, li);
				for (; je > ye;) {
					System.out.println("��ܰ��ʾ���������㣬��ȥ��������Ʒ");
					c = sc.nextInt();

					switch (c) {
					case 1:
						if (pg > 0) {
							pg--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("��ǰ���ﳵû��ƻ����������ѡ��Ҫȥ������Ʒ");
						}
						break;
					case 2:
						if (xj > 0) {
							xj--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("��ǰ���ﳵû���㽶��������ѡ��Ҫȥ������Ʒ");
						}
						break;
					case 3:
						if (li > 0) {
							li--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("��ǰ���ﳵû���棬������ѡ��Ҫȥ������Ʒ");
						}
						break;
					}
				}
				System.out.println("������ѡ��1.ƻ�� ��1  2.�㽶  ��2 3.��  ��3�������ַ��˳�����");
				c = sc.nextInt();
				break;
			}
		}
		return je;
	}
}
