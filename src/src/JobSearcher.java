package src;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class JobSearcher extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private static final String JOBS_DIR = "jobs";
	private JPanel contentPane;
	private JTextField titleInputField;
	private JTextField locationInputField;
	private JTextField industryInputField;
	private JTextField salaryInputField;
	private JTextField experienceInputField;
	private JComboBox workScheduleCombo;
	private DefaultComboBoxModel<JobWorkTime> workScheduleComboModel;
	private JButton btnSearch;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem quitFileMenuItem;
	
	private ArrayList<Job> jobs;
	
	/**
	 * Create the frame.
	 */
	public JobSearcher() 
	{
		setResizable(false);
		setTitle("Job Portal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setFocusable(false);
		lblTitle.setBounds(62, 28, 67, 24);
		contentPane.add(lblTitle);
		
		titleInputField = new JTextField();
		titleInputField.setColumns(10);
		titleInputField.setBounds(157, 32, 447, 20);
		contentPane.add(titleInputField);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLocation.setFocusable(false);
		lblLocation.setBounds(62, 85, 67, 24);
		contentPane.add(lblLocation);
		
		locationInputField = new JTextField();
		locationInputField.setColumns(10);
		locationInputField.setBounds(157, 89, 447, 20);
		contentPane.add(locationInputField);
		
		JLabel lblIndustry = new JLabel("Industry:");
		lblIndustry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIndustry.setFocusable(false);
		lblIndustry.setBounds(62, 145, 67, 24);
		contentPane.add(lblIndustry);
		
		industryInputField = new JTextField();
		industryInputField.setColumns(10);
		industryInputField.setBounds(157, 149, 447, 20);
		contentPane.add(industryInputField);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalary.setFocusable(false);
		lblSalary.setBounds(62, 206, 67, 24);
		contentPane.add(lblSalary);
		
		salaryInputField = new JTextField();
		salaryInputField.setColumns(10);
		salaryInputField.setBounds(157, 210, 447, 20);
		contentPane.add(salaryInputField);
		
		JLabel lblExperience = new JLabel("Experience:");
		lblExperience.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExperience.setFocusable(false);
		lblExperience.setBounds(62, 262, 87, 24);
		contentPane.add(lblExperience);
		
		experienceInputField = new JTextField();
		experienceInputField.setColumns(10);
		experienceInputField.setBounds(157, 266, 447, 20);
		contentPane.add(experienceInputField);
		
		JLabel lblWorkSchedule = new JLabel("Work Schedule:");
		lblWorkSchedule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWorkSchedule.setFocusable(false);
		lblWorkSchedule.setBounds(62, 316, 111, 24);
		contentPane.add(lblWorkSchedule);

		//String[] workSchedules = {"Full-Time", "Part-Time", "Temporary", "Contract", "Shift Work", "Flexible Schedule", "Remote", "Compressed Workweek", "Seasonal"};
		workScheduleComboModel = new DefaultComboBoxModel<>(JobWorkTime.values());
		
		workScheduleCombo = new JComboBox();
		workScheduleCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		workScheduleCombo.setBounds(183, 319, 171, 22);
		workScheduleCombo.setModel(workScheduleComboModel);
		contentPane.add(workScheduleCombo);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(537, 394, 111, 36);
		btnSearch.addActionListener(this);
		contentPane.add(btnSearch);
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		quitFileMenuItem = new JMenuItem("Quit");
		quitFileMenuItem.addActionListener(this);
		fileMenu.add(quitFileMenuItem);
		
		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);
		
		jobs = new ArrayList<Job>(); // Should be before LoadJobs()
		LoadJobs();
		
		// This must be last
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == btnSearch)
			//PrintJobs();
			new JobResults();
		if (e.getSource() == quitFileMenuItem)
			System.exit(0);
	}
	
	private void LoadJobs()
	{
		// Not sure if it should contain /
		File dir = new File(JOBS_DIR);
		
		if (!dir.isDirectory())
			return;
			
		File[] files = dir.listFiles();
		
		if (files == null)
			return;
			
		for (File file : files)
		{
			Job job = new Job();
			job.readFromFile(file.getPath());
			jobs.add(job);
		}
	}
	
	private void PrintJobs()
	{
		for (int i = 0; i < 10; i++) // Testing acts as clearing the screen since the console in eclipse doesnt want to clear
			System.out.println();
		for(Job job : jobs)
		{
			System.out.printf("Title: %s\n", job.title);
			System.out.printf("Description: %s\n", job.description);
			System.out.printf("Location: %s\n", job.location);
			System.out.printf("Industry: %s\n", job.industry);
			System.out.printf("Salary: %s\n", job.salary);
			System.out.printf("Experience: %s\n", job.experience);
			System.out.printf("Work Time: %s\n", job.workTime.toString());
			System.out.printf("Contact Number: %s\n", job.contactNumber);
			System.out.println("-----------------------------------");
		}
	}

	public ArrayList<Job> GetJobs()
	{
		return jobs;
	}
}
