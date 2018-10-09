
public class SingletonPatternDemo 
{

	public static void main(String[] args) 
	{
		SingleObject singleton1 = SingleObject.getInstance();
		singleton1.showMessage();
		
		SingleObject singleton2 = SingleObject.getInstance();
		singleton2.showMessage();

	}

}
