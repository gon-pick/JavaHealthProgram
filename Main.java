import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TotalManager totmanager = new TotalManager();
		Scanner sc = new Scanner(System.in);
		totmanager.InitSchedule();
		
		while(true) {
			System.out.println("1.ȸ������   "+"\t"+"2.�α���   "+"\t"+ "3.����: ");
			int n = sc.nextInt();
			sc.nextLine();
			
			switch(n) {
			case 1:
				try {
					totmanager.join();
					break;
				} catch(Exception e) {
					System.out.println("�̹� ��ϵ� ��ȣ�� ������ �ٲ��ּ���.");
				}
				break;
				
			case 2:
				int plag=totmanager.login();		
				if(plag==-1) break;
				int Managerplag=-1;
				for(;;) {
					int key = totmanager.showPT();
					//Customer: 1.PT���� 2.PT��� 3.PT��ȸ  4.ȸ�� ���� ��ȸ 5.ȸ�� ���� ���� 6.�α׾ƿ�  
					//Manager: 1.���� ���� ��� 2.PT����  3.PT��ȸ 4.�α׾ƿ�  
					
					switch(key) {
					case 1:
						if(totmanager.getCureent() instanceof Customer) {
							totmanager.buy();
						}else {
							totmanager.printProfit();
						}
						break;
					case 2:
						if(totmanager.getCureent() instanceof Customer) {
							totmanager.CustomerPtRegister();
						}else {
							totmanager.ManagerPtModify();
						}
						break;
					case 3:
						totmanager.printAll();
						break;
					case 4:
						if(totmanager.getCureent() instanceof Customer) {
							totmanager.Information();
						}else {
							System.out.println("Log out");
							Managerplag=1;
						}
						break;
					case 5:
						totmanager.Infomodify();
						break;
					case 6:
						System.out.println("Log out");
						break;
					default:
						break;
					}
					
					if(key<1 || key>5 || Managerplag==1) {
						break;
					}
				}
				break;
				
			case 3: System.exit(0);
			default:
				System.out.println("1,2,3�� ��������.");
			}
		}
	}
}
	


