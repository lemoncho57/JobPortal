package src;

public class Main 
{
	private static JobSearcher searcher;
	
	public static void main(String[] args)
	{
		searcher = new JobSearcher();
		//searcher.setVisible(true);
	}
	
	public static JobSearcher GetSearcher()
	{
		return searcher;
	}
}
