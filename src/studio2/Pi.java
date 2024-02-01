package studio2;

public class Pi {

	public static void main(String[] args) {
		int counter = 0;
		int total = 0;
		for(int i = 0; i<100000000; i++)
		{
			double x = Math.random();
			double y = Math.random();
			if(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))<=1)
			{
				counter++;
			}
			total++;
		}
		System.out.println((double)counter/total*4);
	}

}
