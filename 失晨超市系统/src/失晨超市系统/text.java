package 失晨超市系统;

import java.util.Scanner;

public class text {
	public static void main(String[] args) {
		System.out.println("学号：202300222，姓名：李文杰");
		System.out.println("欢迎来到失晨超市，请先登陆账号");
		Scanner sc = new Scanner(System.in);
		char a = '1';
		int c = 0, cje = 0, t = 0;
		double d = 0, je = 0, wf = 1;
		sjk sjk = new sjk();
		char dl = 'n';
		Cs cs = new Cs();
		do {
			dl = sjk.sjk1(t, 0, 0);
		} while (dl == 'n');
		t = 1;
		kh kh = new kh(sjk.ye, sjk.jf);
		while (a == '1' | a == '2' | a == '3' | a == '4' | a == '5' | wf != 0) {
			wf = je;
			cs.show();
			kh.ye = kh.ye(kh.ye, d);
			String b = sc.next();
			a = b.charAt(0);
			switch (a) {
			case '1':
				je = cs.gw(c, d, je, kh.ye);
				break;
			case '2':
				kh.ye = cs.zf(kh.ye, je);
				kh.jf = kh.jf(je);
				je = 0;
				sjk.gwcqk();
				sjk.sjk1(t, kh.ye, kh.jf);
				break;
			case '3':
				kh.jf = cs.dj(kh.jf, kh.ye);
				sjk.sjk1(t, kh.ye, kh.jf);
				break;
			case '4':
				System.out.println("请输入您要充值的金额：");
				cje = sc.nextInt();
				kh.ye = kh.cz(kh.ye, cje);
				sjk.sjk1(t, kh.ye, kh.jf);
				break;
			case '5':
				kh.cx(kh.ye, kh.jf);
				break;
			default:
				break;
			}

		}
		System.out.println("成功退出超市，欢迎下次光临");
		System.out.println("您的账号还有余额：" + kh.ye + "积分：" + kh.jf);
	}
}
