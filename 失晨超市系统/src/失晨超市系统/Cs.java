package 失晨超市系统;

import java.util.Random;
import java.util.Scanner;

public class Cs {
	int pg = 0, xj = 0, li = 0;
	Scanner sc = new Scanner(System.in);
	sjk sjk = new sjk();

	public Cs() {
	}

	public void show() {
		System.out.println("欢迎来到超市");
		System.out.println("1.挑选商品");
		System.out.println("2.结账界面");
		System.out.println("3.幸运大奖");
		System.out.println("4.充值余额");
		System.out.println("5.查询资产");
		System.out.println("请选择您要执行的操作（按其他任意数字退出，有未付款商品无法退出哦）：");
	}

	public void sp() {
		sjk.sjk2();
		System.out.println("请选择您要购买的商品（按其他任意数字退出）：");

	}

	public double tx(int a, int pg, int xj, int li) {
		int b = 0;
		switch (a) {
		case 1:
			System.out.println("选择了一个苹果");
			b = 1;
			break;
		case 2:
			System.out.println("选择了一个香蕉");
			b = 2;
			break;
		case 3:
			System.out.println("选择了一个梨");
			b = 3;
			break;
		}
		if (pg > 0 | xj > 0 | li > 0) {
			System.out.println("当前购物车有：");
			if (pg > 0) {
				System.out.println(pg + "个苹果");
			}
			if (xj > 0) {
				System.out.println(xj + "个香蕉");
			}
			if (li > 0) {
				System.out.println(li + "个梨");
			}
		}
		return b;
	}

	public double je(double je, double b) {
		je = je + b;
		System.out.println("当前商品共" + je + "元");
		return je;
	}

	public double ttx(int a, int pg, int xj, int li) {
		int b = 0;
		switch (a) {
		case 1:
			System.out.println("去除了一个苹果");
			b = 1;
			break;
		case 2:
			System.out.println("去除了一个香蕉");
			b = 2;
			break;
		case 3:
			System.out.println("去除了一个梨");
			b = 3;
			break;
		}
		if (pg > 0 | xj > 0 | li > 0) {
			System.out.println("当前购物车有：");
			if (pg > 0) {
				System.out.println(pg + "个苹果");
			}
			if (xj > 0) {
				System.out.println(xj + "个香蕉");
			}
			if (li > 0) {
				System.out.println(li + "个梨");
			}
		}
		return -b;
	}

	public double zf(double ye, double je) {
		ye -= je;
		System.out.println("支付成功，剩余余额" + ye);
		System.out.println("获得积分：" + je);
		pg = 0;
		xj = 0;
		li = 0;
		return ye;
	}

	public int dj(int jf, double ye) {
		Random random = new Random();
		System.out.println("当前积分" + jf);
		System.out.println("奖项为100元余额，中奖概率为5%");
		System.out.println("抽奖需要消耗10积分，按1确认抽奖，其他输入退出");
		int a = sc.nextInt();
		if (a == 1) {
			if (jf >= 10) {
				jf -= 10;
				int num1 = random.nextInt(20) + 1;
				int num2 = random.nextInt(20) + 1;
				if (num1 == num2) {
					ye += 100;
					System.out.println("恭喜你中奖啦，100元余额充值成功，当前余额" + ye);
				} else {
					System.out.println("很遗憾没有中奖。");
				}
			} else {
				System.out.println("积分不足，请多消费吧");
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
					System.out.println("温馨提示：您的余额不足，请去掉几件商品");
					c = sc.nextInt();
					switch (c) {
					case 1:
						if (pg > 0) {
							pg--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("当前购物车没有苹果，请重新选择要去除的商品");
						}
						break;
					case 2:
						if (xj > 0) {
							xj--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("当前购物车没有香蕉，请重新选择要去除的商品");
						}
						break;
					case 3:
						if (li > 0) {
							li--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("当前购物车没有梨，请重新选择要去除的商品");
						}
						break;
					}
				}
				System.out.println("继续挑选（1.苹果 ￥1  2.香蕉  ￥2 3.梨  ￥3，其他字符退出）：");
				c = sc.nextInt();
				break;
			case 2:
				xj++;
				d = tx(c, pg, xj, li);
				je = je(je, d);
				sjk.gwc(c, xj);
				for (; je > ye;) {
					System.out.println("温馨提示：您的余额不足，请去掉几件商品");
					c = sc.nextInt();
					switch (c) {
					case 1:
						if (pg > 0) {
							pg--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);

						} else {
							System.out.println("当前购物车没有苹果，请重新选择要去除的商品");
						}
						break;
					case 2:
						if (xj > 0) {
							xj--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("当前购物车没有香蕉，请重新选择要去除的商品");
						}
						break;
					case 3:
						if (li > 0) {
							li--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("当前购物车没有梨，请重新选择要去除的商品");
						}
						break;
					}
				}
				System.out.println("继续挑选（1.苹果 ￥1  2.香蕉  ￥2 3.梨  ￥3，其他字符退出）：");
				c = sc.nextInt();
				break;
			case 3:
				li++;
				d = tx(c, pg, xj, li);
				je = je(je, d);
				sjk.gwc(c, li);
				for (; je > ye;) {
					System.out.println("温馨提示：您的余额不足，请去掉几件商品");
					c = sc.nextInt();

					switch (c) {
					case 1:
						if (pg > 0) {
							pg--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("当前购物车没有苹果，请重新选择要去除的商品");
						}
						break;
					case 2:
						if (xj > 0) {
							xj--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("当前购物车没有香蕉，请重新选择要去除的商品");
						}
						break;
					case 3:
						if (li > 0) {
							li--;
							d = ttx(c, pg, xj, li);
							je = je(je, d);
						} else {
							System.out.println("当前购物车没有梨，请重新选择要去除的商品");
						}
						break;
					}
				}
				System.out.println("继续挑选（1.苹果 ￥1  2.香蕉  ￥2 3.梨  ￥3，其他字符退出）：");
				c = sc.nextInt();
				break;
			}
		}
		return je;
	}
}
