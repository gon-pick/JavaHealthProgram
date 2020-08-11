import java.util.*;

public class TotalManager {
	List<User> userlist = new ArrayList<>();
	Calendar cal = Calendar.getInstance();
	PtManager pm = new PtManager();
	private User current;
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int daynum = cal.getActualMaximum(Calendar.DATE);
	int ptnum;
	int buypt;
	String ManagerName="pt123";
	String Managerphone="12345";
	Scanner sc = new Scanner(System.in);
	
	public void InitSchedule() {
		pm.ScheduleInit();
	}

	public void join(){
		int plag=-1;
		System.out.println("1.PTȸ��   "+"\t"+ "2.������ [�����ڵ� ��� �� ��밡��]: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		
		if(n==1){
			System.out.print("PT Member's Name: ");
			String name = sc.nextLine();
			System.out.print("PT Member's PhoneNumber [Except -]: ");
			String phone = sc.nextLine();
			
			for(int i=0;i<userlist.size();i++) {
				if(userlist.get(i).getPhoneNo().contentEquals(phone)) {
					plag=1;
				}
			}
			if(plag==1 || Managerphone.equals(phone)) {
				System.out.println("�޴��� ��ȣ�� �̹� ��ϵǾ� �ֽ��ϴ�.");
			}else {
				userlist.add(new Customer(name,phone,0));
			}
		}else if(n==2) {
			
			if(new Manager().getNum()>0) {
				System.out.println("������ ������ ��ω���ϴ�.");
				plag=1;
			}
			if(plag==-1) {
				System.out.print("Manager's Name [���� ����]: ");
				String name = sc.nextLine();
				System.out.print("Manager's PhoneNumber [���� ����]: ");
				String phone = sc.nextLine();
				
				if(ManagerName.equals(name)) {
					userlist.add(new Manager(name,phone));	
				}else {
					System.out.println("������ �̸��� ��Ȯ�� �Է��ϼ���!");
				}	
			}
		}else {
			System.out.println("1 or 2 �� �Է��ؾ� �մϴ�.");
		}
	}
	
	public int login() {
		System.out.println("Phonenum: ");
		String phone = sc.nextLine();
		int plag=-1;
		
		for(int i=0; i<userlist.size();i++) {
			if(userlist.get(i).getPhoneNo().contentEquals(phone)) {
				plag=i;
			}
		}
		
		if(plag==-1) {
			System.out.println("�ش� ��ȣ�� Ʋ�Ƚ��ϴ�!");
		}
		else {
			current = userlist.get(plag);
		}
		
		return plag;
	}
	
	public int showPT() {
		int key = current.showPT();
		return key;
	}
	
	public void buy() {
		if(current instanceof Customer) {
			System.out.println("PT �� ȸ�� �����Ͻðھ��? ");
			int n= sc.nextInt();
			sc.nextLine();
			buypt+=n;
			ptnum = ((Customer) current).ptBuy(n);
			
		}
	}
	
	public void Information() {
		if(current instanceof Customer) {
			System.out.println(current.toString());
		}
	}
	
	public void printProfit() {
		if(current instanceof Manager) {
			((Manager) current).profit(buypt);
		}
	}
	
	public void Infomodify() {
		if(current instanceof Customer) {
			System.out.println("1.�̸�����  2.��ȭ��ȣ ����");
			int n = sc.nextInt();
			String postName;
			sc.nextLine();
			
			if(n==1) {
				System.out.println("�̸� ���� �ϼ���: ");
				postName= current.getName();
				current.setName(sc.nextLine());
				
				//������ ���� ������ pt�� �̸��� ���� �ǵ��� ����.
				for(int i=day;i<daynum;i++) {
					for(int j=0;j<4;j++) {
						if(pm.ptlist.get(i).getPt()[j].contentEquals(postName)) {
							PT pt = pm.ptlist.get(i);
							pt.setptindex(j, ((Customer) current).getName());
							pm.modify(i, pt);
						}
					}
				}
			}else if(n==2) {
				System.out.println("�� ��ȣ ���� �ϼ���: ");
				((Customer) current).setPhoneNo(sc.nextLine());
			}
		}
	}
	
	//�ش� pt�� ����
	public void CustomerPtRegister() {
		int month = cal.get(Calendar.MONTH)+1;
		System.out.println(month+"�� "+day+"���� " +month+"�� " +daynum +"���� ������ �����մϴ�.");
		System.out.println("pt�ް� ���� �� �Է��ϼ��� : ");
		int cusday = sc.nextInt();
		int plag=-1;
		int plag2=-1;
		
		System.out.println(cusday+ " �Ͽ� pt ��û�Ͻðڽ��ϱ�? [1.�� 2.�ƴϿ�]");
		int answer = sc.nextInt();
		sc.nextLine();
		
		if(cusday<day) {
			answer=3;
		}
		
		if(answer==1) {
			if(current instanceof Customer) {
				if(((Customer) current).getptMod()==0) {
					System.out.println("PT�� �����ϰ� ������.");
					plag2=1;
				}
				if(plag2==-1) {
					for(int i=0;i<4;i++) {
						if(pm.ptlist.get(cusday).getPt()[i].contentEquals(" ")) {
							ptnum=((Customer) current).ptUse(cusday);
							PT pt = pm.ptlist.get(cusday);
							pt.setptindex(i, ((Customer) current).getName()); 
							pm.modify(cusday, pt);
							System.out.println("�ش� ���� PT����� �Ǿ����ϴ�.");
							plag=1;
							break;
						}
					}
					if(plag==-1) {
						System.out.println("�ش� ���� �ο��� �� ã���ϴ�.");
					}
					
				}	
			}		
		}else if(answer==3) {
			System.out.println("���� ���� ������ �Ұ��� �մϴ�." + day+"���� " +daynum +"���� ������ �����մϴ�.");
		}
	}
	
	//��ü pt�� ����
	public void printAll() {
		try {
			pm.printAll();
		} catch(Exception e) {
			System.out.println("��û�� PT�� 0���Դϴ�.");
		}
	}
	
	public void ManagerPtModify() {
		int plag=-1;
		System.out.println("��� ���� �����Ͻðڽ��ϱ�?");
		int cusday = sc.nextInt();
		sc.nextLine();
		System.out.println("��� ȸ���� �����Ͻðڽ��ϱ�? [�߰��� ���Ͻø� spaceBar + Enter]");
		String name = sc.nextLine();
		System.out.println("� ȸ���� �߰��ϰڽ��ϱ�? [������ ���Ͻø� spaceBar + Enter �Է�]");
		String changeName = sc.nextLine() ;
		
		if(current instanceof Manager) {
			for(int i=0;i<4;i++) {
				if(pm.ptlist.get(cusday).getPt()[i].contentEquals(name)) {
					PT pt = pm.ptlist.get(cusday);
					pt.setptindex(i, changeName);
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					plag=1;
					break;
				}
			}
			if(plag==-1) {
				System.out.println("�ش� ȸ���� �������� �ʽ��ϴ�.");
			}
		}
	}
	
	public User getCureent() {
		return current;
	}
	
	public void setCurrent(User current) {
		this.current=current;
	}
	

}
