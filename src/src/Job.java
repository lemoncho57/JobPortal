package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public final class Job
{
	public String title;
	public String description;
	public String location;
	public String industry;
	public String salary;
	public String experience;
	public JobWorkTime workTime;
	public String contactNumber;
	
	public void readFromFile(String path)
	{
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path)))
		{
			List<String> lines = reader.lines().collect(Collectors.toList());
			title = lines.get(0);
			description = lines.get(1);
			location = lines.get(2);
			industry = lines.get(3);
			salary = lines.get(4);
			experience = lines.get(5);
			workTime = JobWorkTime.valueOf(lines.get(6).toUpperCase());
			contactNumber = lines.get(7);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}