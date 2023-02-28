package introduction;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		
		int a = 3;
		int b = 5;
		
		if(a == b) {
			System.out.println("Jesu jednaki");
		}else {
			System.out.println("Nisu jednaki");
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		
		int j = 0;
		while(j<10) {
			System.out.println(j);
			j +=  1;
		}
		
		//5 = 5*4*3*2*1
		int broj = 5;
		int factoriel = 1;
		
		while(broj > 1) {
			factoriel *= broj;
			broj -= 1;
		}
		
		System.out.println(factoriel);
		
	}

}
