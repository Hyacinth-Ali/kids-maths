package ali.hyacinth.kid.maths;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KidMathView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4889640188589013442L;
	private JPanel contentPane;
	private JLabel lblValue1;
	private JTextField textFieldAnswer;
	private JLabel lblStatement;
	private JLabel lblValue2;
	private JLabel lblOperator;
	
	 int value1;
	 int value2;
	 MathOperator operator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KidMathView frame = new KidMathView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KidMathView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSophieMathHome = new JLabel("SOPHIE MATH HOME WORKS");
		lblSophieMathHome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSophieMathHome.setForeground(Color.MAGENTA);
		
		lblValue1 = new JLabel("value 1");
		lblValue1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblOperator = new JLabel("operator");
		lblOperator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblValue2 = new JLabel("VALUE 2");
		lblValue2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label = new JLabel("=");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldAnswer.setColumns(10);
		
		lblStatement = new JLabel("");
		lblStatement.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnCheck = new JButton("CHECK");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int correctAnswer = solve(MathOperator.ADD, value1, value2);
	            String input = textFieldAnswer.getText();
	            int inputAnswer = 0;
	            try {
	              inputAnswer = Integer.parseInt(input);
	            } catch (NumberFormatException e) {
	              lblStatement.setText("Enter correct values");
	            } 
	            if (correctAnswer == inputAnswer) {
	              lblStatement.setText("Sophie is correct");
	              lblStatement.setForeground(Color.GREEN);
	              refresh();
	              JOptionPane.showMessageDialog(null, lblStatement);
//	              KidMathView.this.lblFeedback.setText("Correct!");
//	              KidMathView.this.lblFeedback.setForeground(Color.GREEN);
//	              KidMathView.this.lblStatement.setForeground(Color.GREEN);
	            } else {
	              lblStatement.setText("Sophie is wrong, try again");
	              lblStatement.setForeground(Color.RED);
	              JOptionPane.showMessageDialog(null, lblStatement);
//	              KidMathView.this.lblFeedback.setText("Wrong!");
//	              KidMathView.this.lblFeedback.setForeground(Color.RED);
//	              KidMathView.this.lblStatement.setForeground(Color.RED);
	            }
			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCheck.setForeground(Color.MAGENTA);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(183)
					.addComponent(lblSophieMathHome, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
					.addGap(223))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(63)
					.addComponent(lblStatement)
					.addContainerGap(588, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblValue1)
					.addGap(18)
					.addComponent(lblOperator)
					.addGap(18)
					.addComponent(lblValue2)
					.addGap(18)
					.addComponent(label)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCheck)
						.addComponent(textFieldAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(lblSophieMathHome)
					.addGap(86)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValue1)
						.addComponent(lblOperator)
						.addComponent(lblValue2)
						.addComponent(label)
						.addComponent(textFieldAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(btnCheck)
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addComponent(lblStatement)
					.addGap(107))
		);
		contentPane.setLayout(gl_contentPane);
		refresh();
	}
	  private void refresh() {
		    value1 = (int )Math.floor(Math.random() * 31);
		    value1 = value1 < 10 ? value1 + 10 : value1;
		    value2 = (int) Math.floor(Math.random() * 31);
		    value2 = value2 < 10 ? value2 + 10 : value2;
		    
		    lblValue1.setText(value1 + "");
		    lblValue2.setText(value2 + "");
		    textFieldAnswer.setText("");

		    // return random value between 1 and 4
		    int operatorValue =(int) Math.floor((Math.random() * 4) + 1);
		    if (operatorValue == 1) {
		    	// 1 represents addition
		      lblOperator.setText("+");
		      operator = MathOperator.ADD;
		    } else if (operatorValue == 2) {
		    	// 2 represents subtraction
		      lblOperator.setText("-");
		      operator = MathOperator.SUBTRACT;
		    } else if (operatorValue == 3) {
		      lblOperator.setText("/");
		      operator = MathOperator.DIVISION;
		    } else if (operatorValue == 4) {
		      lblOperator.setText("*");
		      operator = MathOperator.MULTIPLICATION;
		    } 
		  }
		  
		  private int solve(MathOperator operator, int value1, int value2) {
		    int answer = 0;
		    if (operator == MathOperator.ADD) {
		      answer = value1 + value2;
		    } else if (operator == MathOperator.SUBTRACT) {
		      answer = value1 - value2;
		    } else if (operator == MathOperator.MULTIPLICATION) {
		      answer = value1 * value2;
		    } else if (operator == MathOperator.DIVISION) {
		      answer = value1 / value2;
		    } 
		    return answer;
		  }

}
