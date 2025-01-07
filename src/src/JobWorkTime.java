package src;

public enum JobWorkTime 
{
	FULL_TIME("Full-Time"),
	PART_TIME("Part-Time"),
	TEMPORARY("Temporary"),
	CONTRACT("Contract"),
	SHIFT_WORK("Shift Work"),
	FLEXIBLE_SCHEDULE("Flexible Schedule"),
	REMOTE("Remote"),
	COMPRESSED_WORKWEEK("Compressed Workweek"),
	SEASONAL("Seasonal");
	
	private final String name;
	JobWorkTime(String name) 
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
