import java.util.*;

public class Customer extends User {
	private int ptMod;
	Scanner sc = new Scanner(System.in);
	
	public Customer() {};
	
	public Customer(String name,String phoneNo,int ptMod) {
		super(name,phoneNo);
		this.ptMod=ptMod;
	}
	
	@Override
	public int showPT() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("* �ｺ Ŭ���� ���Ű��� ȯ���մϴ�. "+super.getName() +"���� ���� PT Ƚ����: "  + ptMod + "�Դϴ�. *");
		System.out.println("1.PT����   2.PT���   3.PT��ȸ   4.ȸ�� ���� ��ȸ   5.ȸ�� ���� ����   6.�α׾ƿ�   : ");
		int pt = sc.nextInt();
		sc.nextLine();
		if(pt<1 && pt>6) {
			pt=0;
		}
		return pt;
	}
	
	@Override
	public String toString() {
		return "Customer *Name: " + super.getName() + "     *PhoneNumber: " + super.getPhoneNo();
	}
	
	public int ptBuy(int n) {
		System.out.println("PT �̿���� " + n + "���� �����Ͽ����ϴ�.");
		System.out.println("���� PTȽ���� " + (getptMod()+n) + "�� �Դϴ�");
		setptMod(ptMod+n);
		return ptMod;
	}

	public int ptUse(int cusday) {
		// TODO Auto-generated method stub
		if(ptMod>0) {
			System.out.println(cusday+"�Ͽ� "+"PT �̿���� ����Ͽ����ϴ�.");
			System.out.println("���� PTȽ���� " + (getptMod()-1) + "�� �Դϴ�");
			setptMod(ptMod-1);	
		}else {
			System.out.println("PT ���� 0�� �Դϴ�. PT�� �����ϼ���.");
		}
		
		return ptMod;
	}

	public void setptMod(int ptMod) {
		this.ptMod=ptMod;
	}
	
	public int getptMod() {
		return this.ptMod;
	}
}
