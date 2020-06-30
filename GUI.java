package Assignment2;



import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;



public class GUI {
	private JFrame frame;
	private static Queue<String> SequenceList = new LinkedList<>();
	private static JTextField TiltTime;
	static Finch Kierans_Finch = new Finch();
	
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				
				try 
				{
					GUI window = new GUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
		
		public GUI() 
		{
			initialize();
		}
	
	private void initialize() 
	{
		//////////////////////////////////////////1st Frame///////////////////////////////
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 172, 181));
		frame.setBounds(500, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel Title_1stPage = new JLabel("");
		Title_1stPage.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		Title_1stPage.setText("Finch: Tilt Control");
		Title_1stPage.setBounds(170, 44, 237, 44);
		frame.getContentPane().add(Title_1stPage);
		
		JLabel Label1 = new JLabel("\"How Many Seconds do you want to record Tilts For?\"\r\n");
		Label1.setFont(new Font("Calibri", Font.ITALIC, 15));
		Label1.setBounds(121, 182, 328, 26);
		frame.getContentPane().add(Label1);
		
		Label Label2 = new Label("Enter a Tilt Time (1-20) Seconds");
		Label2.setFont(new Font("Calibri", Font.PLAIN, 12));
		Label2.setBounds(121, 206, 197, 22);
		frame.getContentPane().add(Label2);
		
		
		
		TiltTime = new JTextField();
		TiltTime.setBounds(277, 273, 28, 20);
		frame.getContentPane().add(TiltTime);
		TiltTime.setColumns(10);
		
		TiltTime.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e)
			{
				char ch =e.getKeyChar();
				if (Character.isDigit(ch) || (ch == KeyEvent.VK_BACK_SPACE))
				{
					//do nothing
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Only Numbers are allowed!");
					TiltTime.setText("");
				}
			}
		});
		
		JLabel lblTiltTime = new JLabel("Tilt Time:");
		lblTiltTime.setFont(new Font("Calibri", Font.BOLD, 12));
		lblTiltTime.setBounds(218, 274, 59, 20);
		frame.getContentPane().add(lblTiltTime);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBackground(new Color(255, 255, 255));
		btnStart.setFont(new Font("Calibri", Font.BOLD, 14));
		btnStart.setBounds(250, 356, 68, 44);
		frame.getContentPane().add(btnStart);
		
		btnStart.setEnabled(TiltTime.getText().length()!=0);
		
		btnStart.addMouseListener(new MouseAdapter() 
				{
		
			public void mouseClicked(MouseEvent e) 
			{
				String Tilttxt;
				Tilttxt = TiltTime.getText(); //getting the values entered into the Txtbox and turning it into a string
				int TiltNo = Integer.parseInt(Tilttxt); // turning the String Value into integer so that the if statement can work with the paramters
				
				if ((TiltNo >= 1) && (TiltNo <= 20 ))
				{
				frame.setVisible(false); //closes previous Frame
				Instructions_Page();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please Enter a number between 1 and 20");
				}
					
				
				
			}
				});
		
		///////////////////////////////////// Contents of the Instructions Page //////////////////////////////////////////////////
		
	}
	private static void Instructions_Page()
	{
		JFrame Instructions_Page = new JFrame();
		Instructions_Page.setVisible(true);
		Instructions_Page.getContentPane().setBackground(new Color(64, 172, 181));
		Instructions_Page.setBounds(500, 100, 600, 500);
		Instructions_Page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Instructions_Page.getContentPane().setLayout(null);
		
		JLabel Title_Instructions = new JLabel("");
		Title_Instructions.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Instructions.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		Title_Instructions.setText("Instructions");
		Title_Instructions.setBounds(170, 44, 237, 44);
		Instructions_Page.getContentPane().add(Title_Instructions);
		
		JButton btnBegin_Recording = new JButton("Begin Recording");
		btnBegin_Recording.setBackground(new Color(255, 255, 255));
		btnBegin_Recording.setFont(new Font("Calibri", Font.BOLD, 14));
		btnBegin_Recording.setBounds(293, 360, 129, 44);
		Instructions_Page.getContentPane().add(btnBegin_Recording);
		
		JLabel lblTiltYourFinch = new JLabel("Tilt Your finch in a direction of your choosing. Hold the Finch in that Position until you hear it beep. ");
		lblTiltYourFinch.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblTiltYourFinch.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiltYourFinch.setBounds(10, 109, 564, 27);
		Instructions_Page.getContentPane().add(lblTiltYourFinch);
		
		JLabel lblHearTheBeep = new JLabel("When you hear the Beep, tilt the Finch in another direction. The Movement you have just entered ");
		lblHearTheBeep.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblHearTheBeep.setBounds(10, 138, 564, 27);
		Instructions_Page.getContentPane().add(lblHearTheBeep);
		
		JLabel lblWillBeDisplayed = new JLabel("will be displayed on the screen. Once you are finished entering your Sequence of Movements, Tap");
		lblWillBeDisplayed.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblWillBeDisplayed.setBounds(10, 171, 564, 27);
		Instructions_Page.getContentPane().add(lblWillBeDisplayed);
		
		JLabel lblFinchsHeadAnd = new JLabel("the finch's Head and the Red nose Turns off and you hear a Beep.\u201D ");
		lblFinchsHeadAnd.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFinchsHeadAnd.setBounds(10, 209, 535, 20);
		Instructions_Page.getContentPane().add(lblFinchsHeadAnd);
		
		JLabel lbltheTiltDirections = new JLabel("The Tilt Directions Translate as followed: ");
		lbltheTiltDirections.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbltheTiltDirections.setBounds(10, 251, 250, 20);
		Instructions_Page.getContentPane().add(lbltheTiltDirections);
		
		JLabel lblBeakUp = new JLabel("Beak Up = move forward ");
		lblBeakUp.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblBeakUp.setBounds(10, 282, 237, 20);
		Instructions_Page.getContentPane().add(lblBeakUp);
		
		JLabel lblBeakDown = new JLabel("Beak Down = move backward ");
		lblBeakDown.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblBeakDown.setBounds(10, 313, 191, 20);
		Instructions_Page.getContentPane().add(lblBeakDown);
		
		JLabel lblLeftWingDown = new JLabel("Left Wing Down = turn left ");
		lblLeftWingDown.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblLeftWingDown.setBounds(10, 344, 173, 20);
		Instructions_Page.getContentPane().add(lblLeftWingDown);
		
		JLabel lblRightWingDown = new JLabel("Right Wing Down = turn right ");
		lblRightWingDown.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblRightWingDown.setBounds(10, 372, 191, 20);
		Instructions_Page.getContentPane().add(lblRightWingDown);
		
		JLabel lblLevel = new JLabel("Level = stop");
		lblLevel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblLevel.setBounds(10, 400, 110, 20);
		Instructions_Page.getContentPane().add(lblLevel);
		
		btnBegin_Recording.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e) 
			{
				Instructions_Page.setVisible(false);   //closes previous Frame
				RecordSequenceInput_Page();
			}
		});
	}
	
	public static void RecordSequenceInput_Page()
	{
		JFrame RecordSequnecInput = new JFrame();
		RecordSequnecInput.getContentPane().setBackground(new Color(64, 172, 181));
		RecordSequnecInput.setBounds(500, 100, 800, 500);
		RecordSequnecInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RecordSequnecInput.getContentPane().setLayout(null);
		RecordSequnecInput.setVisible(true);
		
		JLabel Title_SequenceInput = new JLabel("");
		Title_SequenceInput.setHorizontalAlignment(SwingConstants.CENTER);
		Title_SequenceInput.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		Title_SequenceInput.setText("Sequence Input");
		Title_SequenceInput.setBounds(271, 21, 237, 44);
		RecordSequnecInput.getContentPane().add(Title_SequenceInput);
		
		JSlider UpDown = new JSlider();
		UpDown.setPaintLabels(true);
		UpDown.setValue(0);
		UpDown.setMajorTickSpacing(45);
		UpDown.setMinorTickSpacing(15);
		UpDown.setMinimum(-90);
		UpDown.setMaximum(90);
		UpDown.setBounds(457, 179, 300, 51);
		RecordSequnecInput.getContentPane().add(UpDown);
		
		JSlider LeftRight = new JSlider();
		LeftRight.setPaintLabels(true);
		LeftRight.setBounds(38, 179, 300, 51);
		LeftRight.setValue(0);
		LeftRight.setMajorTickSpacing(45);
		LeftRight.setMinorTickSpacing(15);
		LeftRight.setMinimum(-90);
		LeftRight.setMaximum(90);
		RecordSequnecInput.getContentPane().add(LeftRight);
		
		JLabel lblBeakDown = new JLabel("Beak Down");
		lblBeakDown.setFont(new Font("Calibri", Font.BOLD, 14));
		lblBeakDown.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeakDown.setBounds(708, 234, 76, 14);
		RecordSequnecInput.getContentPane().add(lblBeakDown);
		
		JLabel lblBeakUp = new JLabel("Beak Up");
		lblBeakUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeakUp.setFont(new Font("Calibri", Font.BOLD, 14));
		lblBeakUp.setBounds(427, 234, 64, 14);
		RecordSequnecInput.getContentPane().add(lblBeakUp);
		
		JLabel lblLeftwingDown = new JLabel("Left-Wing Down");
		lblLeftwingDown.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeftwingDown.setFont(new Font("Calibri", Font.BOLD, 14));
		lblLeftwingDown.setBounds(5, 234, 104, 14);
		RecordSequnecInput.getContentPane().add(lblLeftwingDown);
		
		JLabel lblRightwingDown = new JLabel("Right-Wing Down");
		lblRightwingDown.setHorizontalAlignment(SwingConstants.CENTER);
		lblRightwingDown.setFont(new Font("Calibri", Font.BOLD, 14));
		lblRightwingDown.setBounds(282, 234, 104, 14);
		RecordSequnecInput.getContentPane().add(lblRightwingDown);
		
		JTextField FinchMovement = new JTextField();
		FinchMovement.setFont(new Font("Calibri", Font.PLAIN, 16));
		FinchMovement.setEditable(false);
		FinchMovement.setBounds(367, 325, 156, 32);
		RecordSequnecInput.getContentPane().add(FinchMovement);
		FinchMovement.setColumns(10);
		
		JLabel lblFinchMovement = new JLabel("Finch Movement :");
		lblFinchMovement.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFinchMovement.setBounds(232, 325, 131, 32);
		RecordSequnecInput.getContentPane().add(lblFinchMovement);
		
		String TiltTxt;
		TiltTxt = TiltTime.getText();
		
		int TiltNo;
		TiltNo = Integer.parseInt(TiltTxt);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() // the Timer has been add so that the computer can load the GUI before executing any more Functions.
				{
			public void run()
			{
				Kierans_Finch.setLED(150, 0, 0);// Numbers are RGB in order
				
		while ((Kierans_Finch.getLeftLightSensor() >= 30) || ( Kierans_Finch.getRightLightSensor() >= 30))
			{
			Long StartTime = System.currentTimeMillis();
			Long elapsedTime = 0L;
		while (elapsedTime< TiltNo*1000) //TiltNo * 1000 = Time in Seconds. E.g. 12 *1000 = 12 seconds.
		{
		
			double x, y;
			int x_Degree, y_Degree;
			
			
			x = Kierans_Finch.getXAcceleration(); // beak up or down
			y = Kierans_Finch.getYAcceleration(); // left wing or ring wing
			x_Degree = (int)Math.round( 90*(x));
			y_Degree = (int)Math.round( 90*(y));
			UpDown.setValue(x_Degree);
			LeftRight.setValue(y_Degree);
			elapsedTime = (new Date().getTime()- StartTime);
			
			
			Long RecordStart = System.currentTimeMillis();
			Long RecordDiff = 0L;
			while (RecordDiff< 500)   // Delays so that Orientation is Recorded and shown every 500 Milliseconds
			{
			
				RecordDiff = (new Date().getTime()- RecordStart);
				
				
			}
			
		}
		
		//////////////////////////////////To Determine Which Tilt Direction has been inputted////////////////////////////////
		int UpDownNo = UpDown.getValue(); 
		int LeftRightNo = LeftRight.getValue(); 
		
		String TiltDirection = null;
		
		
		if ((UpDownNo < 0) && (LeftRightNo > 0)) //  if UpDown slider is less than 0
		{
			UpDownNo = (UpDownNo)*(-1); // if UpDown slider value is a negative No. this will turn it into Positive value
			
			if((UpDownNo < 15) && (LeftRightNo < 15))
			{
				TiltDirection = "Level";
			} 
			else if (UpDownNo < LeftRightNo)
			{
				TiltDirection = "Left Wing Down";
			}
			else if (UpDownNo > LeftRightNo)
			{
				TiltDirection = "Beak Up";
			}

			
		}
		else if ((UpDownNo > 0) && (LeftRightNo < 0)) // if the LeftRight Slider is less than 0
		{
			LeftRightNo = (LeftRightNo)*(-1); // if LeftRight Slider value is a negative No. this will turn it into Positive value
			
			if  ((UpDownNo < 15) && (LeftRightNo < 15))
			{
				TiltDirection = "Level";
			}
			else if (UpDownNo < LeftRightNo)
			{
				TiltDirection = "Right Wing Down";
			}
			else if (UpDownNo > LeftRightNo)
			{
				TiltDirection = "Beak Down";
			}
		}
		else if ((UpDownNo > 0) && (LeftRightNo > 0)) // if they are both greater than 0
		{
			
			if ((UpDownNo < 15) && (LeftRightNo < 15))
			{
				TiltDirection ="Level" ;
			}
			else if (UpDownNo < LeftRightNo)
			{
				TiltDirection = "Left Wing Down";
			}
			else if (UpDownNo > LeftRightNo)
			{
				TiltDirection = "Beak Down" ;
			}
		}
		else // if they are both less than 0
		{
			LeftRightNo = ((LeftRightNo)*(-1));
			UpDownNo = ((UpDownNo)*(-1));
			
			if ((UpDownNo < 15) && (LeftRightNo < 15))
			{
				TiltDirection = "Level";
			}
			else if (UpDownNo < LeftRightNo)
			{
				TiltDirection = "Right Wing Down";
			}
			else if (UpDownNo > LeftRightNo)
			{
				TiltDirection = "Beak Up" ;
			}
				
		}
		
		
			
		switch (TiltDirection)
		{
		case "Beak Up":
			
			FinchMovement.setText("Forwards");
			break;
		
		case "Beak Down":
			FinchMovement.setText("Backwards");
			break;
			
		case "Left Wing Down":
			FinchMovement.setText("Turn Left");
			break;
		
		case "Right Wing Down":
			FinchMovement.setText("Turn Right");
			break;
			
		case "Level":
			FinchMovement.setText("Stop");
		}
		
		
		
		SequenceList.add(FinchMovement.getText());
		
		System.out.println(SequenceList);
		System.out.println(Kierans_Finch.getLeftLightSensor());
		System.out.println(Kierans_Finch.getRightLightSensor());
		
		Kierans_Finch.playTone(1500, 50, 250); // Finch goes beep to Indicate when the Tilt has been recorded
		Kierans_Finch.playTone(2000, 50, 250);
		}// End Of Light Sensor While Loop
		
		
		
		Kierans_Finch.setLED(0,0,0);  //Red Light Turns off,
		Kierans_Finch.playTone(2000, 50, 1000); // Beep Once When Recording Session is Over
		RecordSequnecInput.setVisible(false);
		Execute_Tilt_Sequence();
				
		}
		
			
		
			
				}, 1000);
		
		
	}
	
	public static void Execute_Tilt_Sequence()
	{
		JOptionPane.showMessageDialog(null, "Place Finch on The Floor");
		
		JFrame Execute_Tilt_Sequence = new JFrame();
		
		Execute_Tilt_Sequence = new JFrame();
		Execute_Tilt_Sequence.getContentPane().setBackground(new Color(64, 172, 181));
		Execute_Tilt_Sequence.setBounds(500, 100, 200, 100);
		Execute_Tilt_Sequence.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Execute_Tilt_Sequence.getContentPane().setLayout(null);
		Execute_Tilt_Sequence.setVisible(true);
		
		JLabel Title_Execution = new JLabel("");
		Title_Execution.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Execution.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		Title_Execution.setText("Execution");
		Title_Execution.setBounds(10, 11, 163, 44);
		Execute_Tilt_Sequence.getContentPane().add(Title_Execution);
		
Timer Wait = new Timer();
		
		Wait.schedule(new TimerTask()
				{
			public void run()
			{
				Kierans_Finch.setLED(0,150,0);
				System.out.println(SequenceList.size());
				while (SequenceList.size() > 0)
				{
					int min = 1;
					int Max = 255 ;
					int WheelSpeed ;
					
					Random RndmNumber = new Random();
					
					WheelSpeed = min+ RndmNumber.nextInt(Max);
					
					switch (SequenceList.peek())
					{
					case "Forwards":
						Kierans_Finch.buzz(600, 100);
						Kierans_Finch.buzz(600, 100);
						Kierans_Finch.setWheelVelocities(WheelSpeed, WheelSpeed, 500); //left wheel, right wheel
						break;
					
						
						
					case "Backwards":
						Kierans_Finch.buzz(300, 100);
						Kierans_Finch.buzz(300, 100);
						Kierans_Finch.setWheelVelocities((WheelSpeed*(-1)), (WheelSpeed*(-1)), 500);
						break;
						
					case "Turn Left":
						Kierans_Finch.buzz(300, 100);
						Kierans_Finch.buzz(600, 100);
						Kierans_Finch.setWheelVelocities((WheelSpeed*(-1)), WheelSpeed, 500); // Wheel Speed of the Left  wheel is Negative so that the Finch makes more of a "Turning" motion than a "Rotate on axis" motion, if it where set to 0
						break;
					
					case "Turn Right":
						Kierans_Finch.buzz(600, 100);
						Kierans_Finch.buzz(300, 100);
						Kierans_Finch.setWheelVelocities(WheelSpeed, (WheelSpeed*(-1)), 500);
						break;
					
					case "Stop":
						Kierans_Finch.buzz(600, 100);
						Kierans_Finch.buzz(300, 50);
						Kierans_Finch.buzz(600, 100);
						Kierans_Finch.setWheelVelocities(0, 0, 500);
					}

					SequenceList.remove();
					
					Long DelayStart = System.currentTimeMillis();
					Long DelayTime = 0L;
					
					while (DelayTime< 500) // Wait for 500 Milliseconds between each Movement
					{
					
						DelayTime = (new Date().getTime()- DelayStart);
						
						
					}
					
				
				} // End of Execution While Loop
				
				Kierans_Finch.playTone(2000, 50, 500); 
				Kierans_Finch.playTone(2000, 50, 500);
				Kierans_Finch.setLED(0,0,0);
				
			
			}
			
			
				}, 2000);// Wait for 2 Seconds Before Executing
		
		

	}
	
}
//////////////////////////////////END OF PROGRAM//////////////////////////////////////////////	