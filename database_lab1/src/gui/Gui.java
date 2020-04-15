package gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import mysql.Connect;

public class Gui{
	private static JPanel insertPanel;
	private static JPanel deletePanel;
	private static JPanel queryPanel;
	private static JTextArea textArea_3;
	private static JTextArea textArea_2;
	private static JRadioButton radioButton1;
	private static JRadioButton radioButton2;
	private static JRadioButton radioButton3;
	private static JRadioButton radioButton4;
	private static JComboBox<String> comboBox_1;
	private static JComboBox<String> comboBox_2;
	private static JComboBox<String> comboBox_3;
	private static Connect connect = new Connect("root", "123");
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("\u529F\u80FD\u83DC\u5355");
		frame.setSize(512, 534);
		frame.getContentPane().setLayout(null);
		
		JButton insertPageButton = new JButton("\u5411\u8868\u4E2D\u63D2\u5165\u5143\u7EC4");
		insertPageButton.setBounds(10, 7, 152, 27);
		frame.getContentPane().add(insertPageButton);
		insertPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showInsertPage();
			}
		});
		insertPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton deletePageButton = new JButton("\u4ECE\u8868\u4E2D\u5220\u9664\u5143\u7EC4");
		deletePageButton.setBounds(172, 7, 152, 27);
		frame.getContentPane().add(deletePageButton);
		deletePageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showDeletePage();
			}
		});
		deletePageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton queryPageButton = new JButton("\u5728\u8868\u4E2D\u8FDB\u884C\u67E5\u8BE2");
		queryPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showQueryPage();
			}
		});
		queryPageButton.setBounds(334, 7, 152, 27);
		frame.getContentPane().add(queryPageButton);
		queryPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		
		insertPanel = new JPanel();
		insertPanel.setBounds(10, 44, 476, 443);
		frame.getContentPane().add(insertPanel);
		insertPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u9700\u8981\u6DFB\u52A0\u65B0\u5143\u7EC4\u7684\u8868");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(137, 23, 220, 35);
		insertPanel.add(lblNewLabel);
		
		JButton studentButton = new JButton("\u5B66\u751F\u4FE1\u606F\u8868");
		studentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				studentInsertPage();
			}
		});
		studentButton.setFont(new Font("宋体", Font.PLAIN, 15));
		studentButton.setBounds(62, 80, 145, 46);
		insertPanel.add(studentButton);
		
		JButton teacherButton = new JButton("\u6559\u5E08\u4FE1\u606F\u8868");
		teacherButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				teacherInsertPage();
			}
		});
		teacherButton.setFont(new Font("宋体", Font.PLAIN, 15));
		teacherButton.setBounds(269, 80, 145, 46);
		insertPanel.add(teacherButton);
		
		JButton selectCourseButton = new JButton("\u9009\u8BFE\u4FE1\u606F\u8868");
		selectCourseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectCourseInsertPage();
			}
		});
		selectCourseButton.setFont(new Font("宋体", Font.PLAIN, 15));
		selectCourseButton.setBounds(62, 166, 145, 46);
		insertPanel.add(selectCourseButton);
		
		JButton departmentButton = new JButton("\u9662\u7CFB\u4FE1\u606F\u8868");
		departmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				departmentInsertPage();
			}
		});
		departmentButton.setFont(new Font("宋体", Font.PLAIN, 15));
		departmentButton.setBounds(269, 166, 145, 46);
		insertPanel.add(departmentButton);
		
		JButton apartmentButton = new JButton("\u5B66\u751F\u516C\u5BD3\u8868");
		apartmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				apartmentInsertPage();
			}
		});
		apartmentButton.setFont(new Font("宋体", Font.PLAIN, 15));
		apartmentButton.setBounds(62, 256, 145, 46);
		insertPanel.add(apartmentButton);
		
		JButton healthReportButton = new JButton("\u5065\u5EB7\u7533\u62A5\u4FE1\u606F\u8868");
		healthReportButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                healthReportInsertPage();
			}
		});
		healthReportButton.setFont(new Font("宋体", Font.PLAIN, 15));
		healthReportButton.setBounds(269, 349, 145, 46);
		insertPanel.add(healthReportButton);
		
		JButton courseButton = new JButton("\u8BFE\u7A0B\u4FE1\u606F\u8868");
		courseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				courseInsertPage();
			}
		});
		courseButton.setFont(new Font("宋体", Font.PLAIN, 15));
		courseButton.setBounds(62, 349, 145, 46);
		insertPanel.add(courseButton);
		
		JButton leagueButton = new JButton("\u793E\u56E2\u4FE1\u606F\u8868");
		leagueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leagueInsertPage();
			}
		});
		leagueButton.setFont(new Font("宋体", Font.PLAIN, 15));
		leagueButton.setBounds(269, 256, 145, 46);
		insertPanel.add(leagueButton);
		
		deletePanel = new JPanel();
		deletePanel.setBounds(10, 44, 476, 443);
		frame.getContentPane().add(deletePanel);
		deletePanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u9700\u8981\u5220\u9664\u5143\u7EC4\u7684\u8868\u540D\uFF1A");
		lblNewLabel_1.setBounds(56, 46, 221, 20);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		deletePanel.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(56, 88, 366, 46);
		deletePanel.add(textArea);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u8BF7\u8F93\u5165\u9700\u8981\u5220\u9664\u7684\u5143\u7EC4\u9700\u8981\u6EE1\u8DB3\u7684\u6761\u4EF6\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(56, 161, 336, 20);
		deletePanel.add(lblNewLabel_1_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(56, 200, 366, 96);
		deletePanel.add(textArea_1);
		
		JButton deleteButton = new JButton("\u5220\u9664\u5143\u7EC4");
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(textArea.getText().length() == 0 || textArea_1.getText().length() == 0) {
					JFrame frame = new JFrame();
					frame.setTitle("\u51fa\u9519");
					frame.setSize(220, 150);
					frame.getContentPane().setLayout(null);
					JLabel errorMessage = new JLabel("<html>\u6587\u672c\u6846\u4e0d\u80fd\u4e3a\u7a7a\uff01</html>");
					errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
					errorMessage.setBounds(30, 0, 200, 100);
					frame.getContentPane().add(errorMessage);
					frame.setVisible(true);	
				} else {
    				try {
						connect.insertAndDelete("delete from " + textArea.getText() + " where " + textArea_1.getText());
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						int errorCode = e1.getErrorCode();
						if(errorCode == 1146) {
							JFrame frame = new JFrame();
							frame.setTitle("\u51fa\u9519");
							frame.setSize(220, 150);
							frame.getContentPane().setLayout(null);
							JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>"
									+ "\u8be5\u8868\u4e0d\u5b58\u5728\uff01</body></html>");
							errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
							errorMessage.setBounds(30, 0, 200, 100);
							frame.getContentPane().add(errorMessage);
							frame.setVisible(true);						
						} else if(errorCode == 1054 || errorCode == 1064) {
							JFrame frame = new JFrame();
							frame.setTitle("\u51fa\u9519");
							frame.setSize(220, 150);
							frame.getContentPane().setLayout(null);
							JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>"
									+ "\u6761\u4ef6\u683c\u5f0f\u9519\u8bef\u6216\u5c5e\u6027\u4e0d"
									+ "\u5b58\u5728\uff01</body></html>");
							errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
							errorMessage.setBounds(30, 0, 200, 100);
							frame.getContentPane().add(errorMessage);
							frame.setVisible(true);	
						} else if(errorCode == 1451) {
							JFrame frame = new JFrame();
							frame.setTitle("\u51fa\u9519");
							frame.setSize(220, 150);
							frame.getContentPane().setLayout(null);
							JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>"
									+ "\u5b58\u5728\u5916\u952e\u7ea6\u675f\uff0c\u65e0\u6cd5\u5220"
									+ "\u9664\uff01</body></html>");
							errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
							errorMessage.setBounds(30, 0, 150, 100);
							frame.getContentPane().add(errorMessage);
							frame.setVisible(true);	
						} else {
							JFrame frame = new JFrame();
							frame.setTitle("\u51fa\u9519");
							frame.setSize(220, 150);
							frame.getContentPane().setLayout(null);
							JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u51fa\u73b0\u672a\u77e5"
									+ "\u9519\u8bef\uff01<br>\u5220\u9664\u5931\u8d25\uff01</body></html>");
							errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
							errorMessage.setBounds(30, 0, 200, 100);
							frame.getContentPane().add(errorMessage);
							frame.setVisible(true);	
						}
					}
				}
			}
		});
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 15));
		deleteButton.setBounds(159, 344, 145, 46);
		deletePanel.add(deleteButton);
		
        queryPanel = new JPanel();
		queryPanel.setBounds(10, 44, 476, 443);
		frame.getContentPane().add(queryPanel);
		queryPanel.setLayout(null);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		radioButton1 = new JRadioButton("\u8FDE\u63A5\u67E5\u8BE2\u793A\u4F8B");
		radioButton1.setFont(new Font("宋体", Font.PLAIN, 15));
		radioButton1.setBounds(26, 41, 121, 23);
		queryPanel.add(radioButton1);
		buttonGroup.add(radioButton1);
		
		radioButton2 = new JRadioButton("\u5D4C\u5957\u67E5\u8BE2\u793A\u4F8B");
		radioButton2.setFont(new Font("宋体", Font.PLAIN, 15));
		radioButton2.setBounds(26, 66, 121, 23);
		queryPanel.add(radioButton2);
		buttonGroup.add(radioButton2);
		
		radioButton3 = new JRadioButton("\u5206\u7EC4\u67E5\u8BE2\u793A\u4F8B");
		radioButton3.setFont(new Font("宋体", Font.PLAIN, 15));
		radioButton3.setBounds(26, 91, 121, 23);
		queryPanel.add(radioButton3);
		buttonGroup.add(radioButton3);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u9009\u62E9\u9700\u8981\u8FDB\u884C\u7684\u67E5\u8BE2\u79CD\u7C7B");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(137, 10, 220, 35);
		queryPanel.add(lblNewLabel_2);
		
		radioButton4 = new JRadioButton("\u81EA\u7531\u67E5\u8BE2\uFF08\u9700\u81EA\u884C\u5728\u4E0B"
				+ "\u65B9\u6587\u672C\u6846\u8F93\u5165\u5B8C\u6574sql\u8BED\u53E5\uFF09");
		radioButton4.setFont(new Font("宋体", Font.PLAIN, 15));
		radioButton4.setBounds(26, 117, 365, 23);
		queryPanel.add(radioButton4);
		buttonGroup.add(radioButton4);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {
				"\u67E5\u8BE2\u6559\u5E08\u53CA\u6240\u5C5E\u9662\u7CFB\u540D\u79F0",
				"\u67E5\u8BE2\u793E\u56E2\u53CA\u5176\u793E\u957F\u7684\u540D\u5B57",
				"\u67E5\u8BE2\u5B66\u751F\u53CA\u6240\u5B66\u8BFE\u7A0B\u6210\u7EE9"}));
		comboBox_1.setBounds(147, 41, 233, 23);
		queryPanel.add(comboBox_1);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"\u67E5\u8BE2\u7537\u751F\u8FD1\u671F\u4F53"
				+ "\u6E29\u5927\u4E8E36.5\u5EA6\u7684\u5B66\u751F", "\u67E5\u8BE2\u6708\u85AA\u4E07\u5143\u4EE5\u4E0A"
						+ "\u6559\u5E08\u6240\u6388\u7684\u5168\u90E8\u8BFE\u7A0B"}));
		comboBox_2.setBounds(147, 66, 233, 23);
		queryPanel.add(comboBox_2);
		
		comboBox_3 = new JComboBox<String>();
		comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[] {"\u6C42cs001\u8BFE\u6BCF\u4E2A\u73ED\u7684"
				+ "\u5B66\u751F\u5E73\u5747\u6210\u7EE9", "\u6C42\u6BCF\u4E2A\u516C\u5BD3\u6240\u5C45\u4F4F\u7684\u5B66"
						+ "\u751F\u4EBA\u6570"}));
		comboBox_3.setBounds(147, 91, 233, 23);
		queryPanel.add(comboBox_3);
		
		textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setBounds(26, 142, 427, 54);
		queryPanel.add(textArea_2);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textArea_3.setText("");
				List<String> result;
				try {
					result = query();
					if(result != null) {
						for (int i = 0; i < result.size(); i++) {
							textArea_3.append(result.get(i)+"\n");						
						}					
					} else {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>\u672a\u67e5\u8be2\u5230\u7ed3\u679c\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JFrame frame = new JFrame();
					frame.setTitle("\u51fa\u9519");
					frame.setSize(220, 150);
					frame.getContentPane().setLayout(null);
					JLabel errorMessage = new JLabel("<html><body>\u672a\u67e5\u8be2\u5230\u7ed3\u679c\uff01</body></html>");
					errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
					errorMessage.setBounds(30, 0, 200, 100);
					frame.getContentPane().add(errorMessage);
					frame.setVisible(true);	
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(390, 41, 63, 73);
		queryPanel.add(button);
		
		JLabel lblNewLabel_3 = new JLabel("\u67E5\u8BE2\u7ED3\u679C\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(26, 197, 70, 23);
		queryPanel.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(26, 219, 427, 203);
		queryPanel.add(scrollPane);
		
		textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		scrollPane.setViewportView(textArea_3);
		
		insertPanel.setVisible(false);
		deletePanel.setVisible(false);
		queryPanel.setVisible(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private static void showInsertPage() {
		insertPanel.setVisible(true);
		deletePanel.setVisible(false);
		queryPanel.setVisible(false);
	}
	
	private static void showDeletePage() {
		insertPanel.setVisible(false);
		deletePanel.setVisible(true);
		queryPanel.setVisible(false);
	}
	
	private static void showQueryPage() {
		insertPanel.setVisible(false);
		deletePanel.setVisible(false);
		queryPanel.setVisible(true);
	}
	
	private static void studentInsertPage() {
		JFrame frame = new JFrame();
		frame.setTitle("\u63d2\u5165\u5b66\u751f\u5143\u7ec4");
		frame.setSize(600, 230);
		frame.getContentPane().setLayout(null);
		
		JLabel hintMessage = new JLabel("<html><body>\u8f93\u5165\u683c\u5f0f\uff1a<br>"
				+ "'\u516b\u4f4d\u5b66\u53f7','\u59d3\u540d','\u6027\u522b(\u7537/\u5973)',\u5e74"
				+ "\u9f84,'\u4e24\u4f4d\u7cfb\u53f7','\u516d\u4f4d\u73ed\u53f7','\u4e09\u4f4d"
				+ "\u516c\u5bd3\u697c\u53f7'</body></html>");
		hintMessage.setFont(new Font("宋体", Font.PLAIN, 15));
		hintMessage.setBounds(30, 0, 445, 100);
		frame.getContentPane().add(hintMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 80, 400, 80);
		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JButton insertPageButton = new JButton("\u63d2\u5165");
		insertPageButton.setBounds(470, 40, 80, 120);
		frame.getContentPane().add(insertPageButton);
		insertPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					connect.insertAndDelete("insert into student values (" + textArea.getText() + ")");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					int errorCode = e1.getErrorCode();
					if(errorCode == 1364) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u4e0d\u80fd"
								+ "\u4e3a\u7a7a\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);						
					} else if(errorCode == 1136 || errorCode == 1064) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u683c\u5f0f"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1062) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u4e3b\u952e\u91cd\u590d"
								+ "\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1452) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u5916\u952e\u4e0d\u6ee1"
								+ "\u8db3\u6761\u4ef6\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u51fa\u73b0\u672a\u77e5"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					}
				}
			}
		});
		insertPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.setVisible(true);
	}
	
	private static void teacherInsertPage() {
		JFrame frame = new JFrame();
		frame.setTitle("\u63d2\u5165\u6559\u5e08\u5143\u7ec4");
		frame.setSize(600, 230);
		frame.getContentPane().setLayout(null);
		
		JLabel hintMessage = new JLabel("<html><body>\u8f93\u5165\u683c\u5f0f\uff1a<br>"
				+ "'\u516b\u4f4d\u5de5\u53f7','\u59d3\u540d','\u6027\u522b(\u7537/\u5973)',\u5e74"
				+ "\u9f84,'\u4e24\u4f4d\u7cfb\u53f7',\u85aa\u6c34</body></html>");
		hintMessage.setFont(new Font("宋体", Font.PLAIN, 15));
		hintMessage.setBounds(30, 0, 445, 100);
		frame.getContentPane().add(hintMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 80, 400, 80);
		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JButton insertPageButton = new JButton("\u63d2\u5165");
		insertPageButton.setBounds(470, 40, 80, 120);
		frame.getContentPane().add(insertPageButton);
		insertPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					connect.insertAndDelete("insert into teacher values (" + textArea.getText() + ")");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					int errorCode = e1.getErrorCode();
					if(errorCode == 1364) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u4e0d\u80fd"
								+ "\u4e3a\u7a7a\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);						
					} else if(errorCode == 1136 || errorCode == 1064) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u683c\u5f0f"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1062) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u4e3b\u952e\u91cd\u590d"
								+ "\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1452) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u5916\u952e\u4e0d\u6ee1"
								+ "\u8db3\u6761\u4ef6\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u51fa\u73b0\u672a\u77e5"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					}
				}
			}
		});
		insertPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.setVisible(true);
	}

	private static void selectCourseInsertPage() {
		JFrame frame = new JFrame();
		frame.setTitle("\u63d2\u5165\u9009\u8bfe\u5143\u7ec4");
		frame.setSize(600, 230);
		frame.getContentPane().setLayout(null);
		
		JLabel hintMessage = new JLabel("<html><body>\u8f93\u5165\u683c\u5f0f\uff1a<br>"
				+ "'\u516b\u4f4d\u5b66\u53f7','\u4e94\u4f4d\u8bfe\u7a0b\u53f7',\u6210\u7ee9</body></html>");
		hintMessage.setFont(new Font("宋体", Font.PLAIN, 15));
		hintMessage.setBounds(30, 0, 445, 100);
		frame.getContentPane().add(hintMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 80, 400, 80);
		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JButton insertPageButton = new JButton("\u63d2\u5165");
		insertPageButton.setBounds(470, 40, 80, 120);
		frame.getContentPane().add(insertPageButton);
		insertPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					connect.insertAndDelete("insert into select_course values (" + textArea.getText() + ")");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					int errorCode = e1.getErrorCode();
					if(errorCode == 1364) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u4e0d\u80fd"
								+ "\u4e3a\u7a7a\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);						
					} else if(errorCode == 1136 || errorCode == 1064) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u683c\u5f0f"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1062) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u4e3b\u952e\u91cd\u590d"
								+ "\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1452) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u5916\u952e\u4e0d\u6ee1"
								+ "\u8db3\u6761\u4ef6\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u51fa\u73b0\u672a\u77e5"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					}
				}
			}
		});
		insertPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.setVisible(true);
	}

	private static void departmentInsertPage() {
		JFrame frame = new JFrame();
		frame.setTitle("\u63d2\u5165\u9662\u7cfb\u5143\u7ec4");
		frame.setSize(600, 230);
		frame.getContentPane().setLayout(null);
		
		JLabel hintMessage = new JLabel("<html><body>\u8f93\u5165\u683c\u5f0f\uff1a<br>"
				+ "'\u4e24\u4f4d\u9662\u7cfb\u53f7','\u9662\u7cfb\u540d',"
				+ "'\u9662\u957f\u516b\u4f4d\u5de5\u53f7'</body></html>");
		hintMessage.setFont(new Font("宋体", Font.PLAIN, 15));
		hintMessage.setBounds(30, 0, 445, 100);
		frame.getContentPane().add(hintMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 80, 400, 80);
		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JButton insertPageButton = new JButton("\u63d2\u5165");
		insertPageButton.setBounds(470, 40, 80, 120);
		frame.getContentPane().add(insertPageButton);
		insertPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					connect.insertAndDelete("insert into department values (" + textArea.getText() + ")");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					int errorCode = e1.getErrorCode();
					if(errorCode == 1364) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u4e0d\u80fd"
								+ "\u4e3a\u7a7a\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);						
					} else if(errorCode == 1136 || errorCode == 1064) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u683c\u5f0f"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1062) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u4e3b\u952e\u91cd\u590d"
								+ "\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1452) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u5916\u952e\u4e0d\u6ee1"
								+ "\u8db3\u6761\u4ef6\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u51fa\u73b0\u672a\u77e5"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					}
				}
			}
		});
		insertPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.setVisible(true);
	}

	private static void apartmentInsertPage() {
		JFrame frame = new JFrame();
		frame.setTitle("\u63d2\u5165\u516c\u5bd3\u5143\u7ec4");
		frame.setSize(600, 230);
		frame.getContentPane().setLayout(null);
		
		JLabel hintMessage = new JLabel("<html><body>\u8f93\u5165\u683c\u5f0f\uff1a<br>"
				+ "'\u4e09\u4f4d\u516c\u5bd3\u53f7',\u5efa\u6210\u5e74\u4efd</body></html>");
		hintMessage.setFont(new Font("宋体", Font.PLAIN, 15));
		hintMessage.setBounds(30, 0, 445, 100);
		frame.getContentPane().add(hintMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 80, 400, 80);
		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JButton insertPageButton = new JButton("\u63d2\u5165");
		insertPageButton.setBounds(470, 40, 80, 120);
		frame.getContentPane().add(insertPageButton);
		insertPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					connect.insertAndDelete("insert into apartment values (" + textArea.getText() + ")");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					int errorCode = e1.getErrorCode();
					if(errorCode == 1364) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u4e0d\u80fd"
								+ "\u4e3a\u7a7a\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);						
					} else if(errorCode == 1136 || errorCode == 1064) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u683c\u5f0f"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1062) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u4e3b\u952e\u91cd\u590d"
								+ "\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1452) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u5916\u952e\u4e0d\u6ee1"
								+ "\u8db3\u6761\u4ef6\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u51fa\u73b0\u672a\u77e5"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					}
				}
			}
		});
		insertPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.setVisible(true);
	}
	
	private static void leagueInsertPage() {
		JFrame frame = new JFrame();
		frame.setTitle("\u63d2\u5165\u793e\u56e2\u5143\u7ec4");
		frame.setSize(600, 230);
		frame.getContentPane().setLayout(null);
		
		JLabel hintMessage = new JLabel("<html><body>\u8f93\u5165\u683c\u5f0f\uff1a<br>"
				+ "'\u56db\u4f4d\u793e\u56e2\u53f7','\u793e\u56e2\u540d','\u793e\u957f\u516b\u4f4d\u5b66\u53f7',"
				+ "\u6210\u7acb\u5e74\u4efd</body></html>");
		hintMessage.setFont(new Font("宋体", Font.PLAIN, 15));
		hintMessage.setBounds(30, 0, 445, 100);
		frame.getContentPane().add(hintMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 80, 400, 80);
		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JButton insertPageButton = new JButton("\u63d2\u5165");
		insertPageButton.setBounds(470, 40, 80, 120);
		frame.getContentPane().add(insertPageButton);
		insertPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					connect.insertAndDelete("insert into league values (" + textArea.getText() + ")");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					int errorCode = e1.getErrorCode();
					if(errorCode == 1364) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u4e0d\u80fd"
								+ "\u4e3a\u7a7a\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);						
					} else if(errorCode == 1136 || errorCode == 1064) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u683c\u5f0f"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1062) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u4e3b\u952e\u91cd\u590d"
								+ "\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1452) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u5916\u952e\u4e0d\u6ee1"
								+ "\u8db3\u6761\u4ef6\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u51fa\u73b0\u672a\u77e5"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					}
				}
			}
		});
		insertPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.setVisible(true);
	}
	
	private static void courseInsertPage() {
		JFrame frame = new JFrame();
		frame.setTitle("\u63d2\u5165\u8bfe\u7a0b\u5143\u7ec4");
		frame.setSize(600, 230);
		frame.getContentPane().setLayout(null);
		
		JLabel hintMessage = new JLabel("<html><body>\u8f93\u5165\u683c\u5f0f\uff1a<br>"
				+ "'\u4e94\u4f4d\u8bfe\u7a0b\u53f7','\u8bfe\u7a0b\u540d','\u4e24\u4f4d\u9662\u7cfb\u53f7',"
				+ "'\u6388\u8bfe\u6559\u5e08\u516b\u4f4d\u5de5\u53f7',\u5b66\u5206,"
				+ "\u662f\u5426\u8003\u8bd5\u8bfe(\u662f\u586b1/\u5426\u586b0)</body></html>");
		hintMessage.setFont(new Font("宋体", Font.PLAIN, 15));
		hintMessage.setBounds(30, 0, 445, 100);
		frame.getContentPane().add(hintMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 80, 400, 80);
		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JButton insertPageButton = new JButton("\u63d2\u5165");
		insertPageButton.setBounds(470, 40, 80, 120);
		frame.getContentPane().add(insertPageButton);
		insertPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					connect.insertAndDelete("insert into course values (" + textArea.getText() + ")");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					int errorCode = e1.getErrorCode();
					if(errorCode == 1364) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u4e0d\u80fd"
								+ "\u4e3a\u7a7a\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);						
					} else if(errorCode == 1136 || errorCode == 1064) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u683c\u5f0f"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1062) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u4e3b\u952e\u91cd\u590d"
								+ "\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1452) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u5916\u952e\u4e0d\u6ee1"
								+ "\u8db3\u6761\u4ef6\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u51fa\u73b0\u672a\u77e5"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					}
				}
			}
		});
		insertPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.setVisible(true);
	}
	
	private static void healthReportInsertPage() {
		JFrame frame = new JFrame();
		frame.setTitle("\u63d2\u5165\u5065\u5eb7\u7533\u62a5\u5143\u7ec4");
		frame.setSize(600, 230);
		frame.getContentPane().setLayout(null);
		
		JLabel hintMessage = new JLabel("<html><body>\u8f93\u5165\u683c\u5f0f\uff1a<br>"
				+ "'\u5b66\u751f\u516b\u4f4d\u5b66\u53f7','\u5e74\u6708\u65e5','\u6240\u5728\u5730\u5e02',"
				+ "\u4f53\u6e29,\u662f\u5426\u88ab\u9694\u79bb(\u662f\u586b1/\u5426\u586b0)</body></html>");
		hintMessage.setFont(new Font("宋体", Font.PLAIN, 15));
		hintMessage.setBounds(30, 0, 445, 100);
		frame.getContentPane().add(hintMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 80, 400, 80);
		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JButton insertPageButton = new JButton("\u63d2\u5165");
		insertPageButton.setBounds(470, 40, 80, 120);
		frame.getContentPane().add(insertPageButton);
		insertPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					connect.insertAndDelete("insert into health_report values (" + textArea.getText() + ")");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					int errorCode = e1.getErrorCode();
					if(errorCode == 1364) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u4e0d\u80fd"
								+ "\u4e3a\u7a7a\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);						
					} else if(errorCode == 1136 || errorCode == 1064) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u8f93\u5165\u683c\u5f0f"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1062) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u4e3b\u952e\u91cd\u590d"
								+ "\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else if(errorCode == 1452) {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u5916\u952e\u4e0d\u6ee1"
								+ "\u8db3\u6761\u4ef6\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					} else {
						JFrame frame = new JFrame();
						frame.setTitle("\u51fa\u9519");
						frame.setSize(220, 150);
						frame.getContentPane().setLayout(null);
						JLabel errorMessage = new JLabel("<html><body>Error"+ errorCode +":<br>\u51fa\u73b0\u672a\u77e5"
								+ "\u9519\u8bef\uff01<br>\u63d2\u5165\u5931\u8d25\uff01</body></html>");
						errorMessage.setFont(new Font("宋体", Font.PLAIN, 17));
						errorMessage.setBounds(30, 0, 200, 100);
						frame.getContentPane().add(errorMessage);
						frame.setVisible(true);	
					}
				}
			}
		});
		insertPageButton.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.setVisible(true);
	}

    private static List<String> query() throws ClassNotFoundException, SQLException {
    	if(radioButton1.isSelected()) {
    		if(comboBox_1.getSelectedIndex() == 0) {
    			String sql = "select t.Tid,t.Tname,t.Did,d.Dname from teacher as t,department as d where (t.Did = d.Did)";
    			textArea_2.setText("");
    			textArea_2.setText(sql);
    			return connect.query(sql);
    		} else if(comboBox_1.getSelectedIndex() == 1) {
    			String sql = "select l.Lid,l.Lname,s.Sid,s.Sname,l.Lyear from student as s,league as l where (s.Sid = l.Lmaster)";
    			textArea_2.setText("");
    			textArea_2.setText(sql);
    			return connect.query(sql);
    		} else if(comboBox_1.getSelectedIndex() == 2) {
    			String sql = "select s.Sid,s.Sname,sc.Cid,sc.Score from student as s,select_course as sc where (s.Sid = sc.Sid)";
    			textArea_2.setText("");
    			textArea_2.setText(sql);
    			return connect.query(sql);
    		} else {
    			textArea_2.setText("");
    			return null;
    		}
    	} else if(radioButton2.isSelected()) {
    		if(comboBox_2.getSelectedIndex() == 0) {
    			String sql = "select Sid,Sname,Rdate,Rlocation,Rtemperature from join_dp_s_hr where Rtemperature > 36.5 and Sid in (select Sid from student where (Ssex = '\u7537'))";
    			textArea_2.setText("");
    			textArea_2.setText(sql);
    			return connect.query(sql);
    		} else if(comboBox_2.getSelectedIndex() == 1) {
    			String sql = "select t.Tid,t.Tname,t.Tsalary,c.Cid,c.Cname from teacher as t,course as c where c.Tid = t.Tid and t.Tid in (select Tid from teacher where (Tsalary >= 10000))";
    			textArea_2.setText("");
    			textArea_2.setText(sql);
    			return connect.query(sql);
    		} else {
    			textArea_2.setText("");
    			return null;
    		}
    	} else if(radioButton3.isSelected()) {
    		if(comboBox_3.getSelectedIndex() == 0) {
    			String sql = "select Sclass,avg(Score) from join_s_sc_c where Cid = 'cs001' group by Sclass";
    			textArea_2.setText("");
    			textArea_2.setText(sql);
    			return connect.query(sql);
    		} else if(comboBox_3.getSelectedIndex() == 1) {
    			String sql = "select Aid,count(*) from student group by Aid";
    			textArea_2.setText("");
    			textArea_2.setText(sql);
    			return connect.query(sql);
    		} else {
    			textArea_2.setText("");
    			return null;
    		}
    	} else if(radioButton4.isSelected()) {
    		String sql = textArea_2.getText();
    		return connect.query(sql);
    	} else {
    		return null;    		
    	}
    }
}