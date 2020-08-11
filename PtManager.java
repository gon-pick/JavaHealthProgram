import java.util.*;

public class PtManager {
	List<PT> ptlist = new ArrayList<>();
	Calendar cal = Calendar.getInstance();
	int daynum = cal.getActualMaximum(Calendar.DATE);
	
	public void ScheduleInit() {
			for(int i=0; i<=40; i++) {
				ptlist.add(new PT(" "," "," "," "));
			}
	}
	
	public void modify(int day,PT pt) {
		ptlist.remove(day);
		ptlist.add(day, pt);
	}
	
	
	public void printAll() throws Exception {
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int week = cal.get(Calendar.WEEK_OF_MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayof = cal.get(Calendar.DAY_OF_WEEK);
		int endofweek = 0;
		
		for(int i=0; i<7; i++) {
			if((dayof+i)%7 == 0) {
				endofweek=(day+i);
				break;
			}
		}
		
		System.out.println("PT Schdule 2��");
		System.out.println(year + "�⵵ " + month + "�� " + week + "�� PT "  );
		System.out.println("��" + "\t" + "��"+ "\t"+ "ȭ"+ "\t"+"��"+ "\t"+"��"+ "\t"+"��"+ "\t"+"��");
		
		for(int i=1;i<dayof;i++) { //���� ��¥
			System.out.print("\t");
		}
		
		for(int i=day; i<=endofweek; i++) { //�̹��� ��¥ �Է�
			int n = i%daynum;
			if(n==0) n=daynum;
			System.out.print("*" + n + "*" + "\t");
		}
		System.out.println();
		
		//�̹��� ��Ƽ �Է�
		for(int i=0;i<4;i++) { 
			for(int j=1; j<dayof; j++) {
				System.out.print("\t");
			}
			for(int j=day;j<=endofweek; j++) {
				int n= j%daynum;
				System.out.print(ptlist.get(n).getPt()[i] + "\t");
			}
			System.out.println();
		}
		
		//������ ��¥ �Է�
		for(int i=(endofweek+1);i<=(endofweek+7);i++ ) {
			int n = i%daynum;
			if(n==0) n=daynum;
			System.out.print("*" + n + "*" + "\t");
		}
		System.out.println();
		
		//������ ��Ƽ �Է�
		for(int i=0;i<4;i++) {
			for(int j= (endofweek+1); j<=(endofweek+7); j++) {
				int n = j%daynum;
				if(n==0) n=daynum;
				System.out.print(ptlist.get(n).getPt()[i] + "\t");
			}
			System.out.println();
		}
	}
	
	public List<PT> getPtlist(){
		return ptlist;
	}
	
	public void setptlist(List<PT> ptlist) {
		this.ptlist=ptlist;
	}

}
