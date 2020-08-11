import java.util.*;

public class Manager extends User {
	private int profit;
	private static int num;
	Scanner sc = new Scanner(System.in);
	
	public Manager() {};
	
	public Manager(String name,String phoneNo) {
		super(name,phoneNo);
		setNum(getNum() + 1);
	}

	@Override
	public int showPT() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("*�Ŵ����� ������ �����Ͻðڽ��ϱ�?");
		System.out.println("1.���� ���� ��� 2.PT����  3.PT��ȸ 4.�α׾ƿ�  ");
		int pt = sc.nextInt();
		sc.nextLine();
		if(pt<1 && pt>6) {
			pt=0;
		}
		return pt;
	}
	
	public void profit(int pt) {
		System.out.println("���� ������� " + (pt*50000) + "�� �Դϴ�.");
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Manager.num = num;
	}
}
