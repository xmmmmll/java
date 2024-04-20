package 失晨超市系统;

public class kh {
	double ye;
	int jf;

	public kh(double ye, int jf) {
		super();
		this.ye = ye;
		this.jf = jf;
	}

	public int hyh(int hyh) {

		return jf;
	}

	public double ye(double ye, double je) {
		this.ye -= je;
		return ye;
	}

	public int jf(double je) {
		this.jf += (int) je;
		System.out.println("当前积分：" + jf);
		return jf;
	}

	public double cz(double ye, double cje) {
		ye += cje;
		System.out.println("充值成功，当前余额" + ye);
		return ye;
	}

	public void cx(double ye, int jf) {
		System.out.println("余额：" + ye);
		System.out.println("积分：" + jf);
	}
}
