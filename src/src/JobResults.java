package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobResults extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLeft;
	private JButton btnRight;
	private JTextArea txtrJobInfo;
	private int jobIndex;
	private JobSearcher searcher;
	
	/**
	 * Create the frame.
	 */
	public JobResults()
	{
		setResizable(false);
		setTitle("Job Portal(Results)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLeft = new JButton("<");
		btnLeft.setBounds(10, 209, 48, 23);
		btnLeft.addActionListener(this);
		contentPane.add(btnLeft);
		
		btnRight = new JButton(">");
		btnRight.setBounds(578, 209, 48, 23);
		btnRight.addActionListener(this);
		contentPane.add(btnRight);
		
		txtrJobInfo = new JTextArea();
		txtrJobInfo.setEditable(false);
		txtrJobInfo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtrJobInfo.setBounds(68, 11, 500, 416);
		contentPane.add(txtrJobInfo);
		
		jobIndex = 0;
		searcher = Main.GetSearcher();
		
		SetTextAreaText(searcher.GetJobs().getFirst());
		
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnLeft && jobIndex > 0)
		{
			jobIndex--;
			SetTextAreaText(searcher.GetJobs().get(jobIndex));
		}
		
		if (e.getSource() == btnRight && jobIndex < searcher.GetJobs().size() - 1)
		{
			jobIndex++;
			SetTextAreaText(searcher.GetJobs().get(jobIndex));
		}
	}
	
	private void SetTextAreaText(Job job)
	{
		txtrJobInfo.setText("");
		txtrJobInfo.append(String.format("Title: %s\n", job.title));
		txtrJobInfo.append(String.format("Description: %s\n", job.description));
		txtrJobInfo.append(String.format("Location: %s\n", job.location));
		txtrJobInfo.append(String.format("Industry: %s\n", job.industry));
		txtrJobInfo.append(String.format("Salary: %s\n", job.salary));
		txtrJobInfo.append(String.format("Experience: %s\n", job.experience));
		txtrJobInfo.append(String.format("Work Time: %s\n", job.workTime));
		txtrJobInfo.append(String.format("Contact Number: %s\n", job.contactNumber));
	}
	
}
