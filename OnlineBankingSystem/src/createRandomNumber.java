import java.util.Random;

public class createRandomNumber {
	public int Random()
	{
		Random r = new Random();
		int n;
		n = 10000000 + r.nextInt(99999999);
		return n;
	}
	public int RandomPin()
	{
		Random r = new Random();
		int n;
		n= 1000 + r.nextInt(9999);
		return n;
	}
}
