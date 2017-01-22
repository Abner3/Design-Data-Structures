
public class test 
{
	//variables
	public int unchanging;
	
	//constructor
	test()
	{
		unchanging = 1;
	}
	
	//methods
	public void setInt(int x)
	{
		setUnchanging(x);
	}

	private int getUnchanging() {
		return unchanging;
	}

	private void setUnchanging(int unchanging) {
		this.unchanging = unchanging;
	}
}
