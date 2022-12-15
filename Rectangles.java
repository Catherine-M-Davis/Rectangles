import java.util.Scanner; //importing scanner class to take user input
import javax.swing.JOptionPane; //importing JOptionPane to display input box

/*
import javax.swing.SwingUtilities;//importing graphics, JComponent, awt, SwingUtilities, and JFrame to display rectangles
import javax.swing.JComponent;
import java.awt.*;
import javax.swing.JFrame;
*/

public class Rectangles /*extends JFrame*/ {

	//declaring class variables in order to reference them in multiple methods
	private static int width1;
	private static int width2;
	private static int length1;
	private static int length2;
	private static int x1;
	private static int x2;
	private static int y1;
	private static int y2;
	private static int rect1[] = {0,0,0,0,0,0,0,0};
	private static int otherx1;
	private static int otherx2;
	private static int othery1;
	private static int othery2;
	static Scanner keyboard = new Scanner(System.in);  
	
	//TODO: Find a way to make this display work it pops up but does not draw
	/*	
	//This method builds the popup 
	public Rectangles() {
        super("Rectangles");
 
        getContentPane().setBackground(Color.WHITE);
        setSize(480, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
 	//This is where the code for the rectangles belongs
    void drawRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
 
        // code to draw rectangles goes here...
        g2d.drawRect(rect1[0],rect1[1],rect1[2],rect1[3]);
        g2d.drawRect(rect1[4],rect1[5],rect1[6],rect1[7]);
    }
    
    //This is where the drawing of the rectangles happens
    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);
    }
   */
	
   /*This method tests for intersection and gives coordinates of intersection if there are any*/
   static void intersection(int[] rect1) {
   /*First it checks if the rectangles are spaced apart indicating they do not intersect. 
    * Then it checks if either rectangle is contained in the other => non intersection.
    * Then it checks if the rectangles share any sides indicating no intersection.
    * Else => intersection is present
    * Then it grabs the points of intersection between the two given rectangles.
    */
		if( rect1[1] > othery2 || rect1[0] > otherx2 || rect1[5] > othery1 || rect1[4] > otherx1) {
			
			System.out.println("We can conclude these two rectangles do not intersect.");
		
		}
		else if ( rect1[1] < othery2 && rect1[0] < otherx2 && rect1[5] < othery1 && rect1[4] < otherx1 && width2 < width1 && length2 < length1) {
			System.out.println("We can conclude these two rectangles do not intersect.");
		}
		else if (rect1[0] == rect1[4] || rect1[0] == otherx2 || rect1[4] == otherx1 || 
				 rect1[1] == rect1[5] || rect1[1] == othery2 || rect1[5] == othery1) {
			System.out.println("Though there is no intersection, we can conclude these two rectangles share a side.");
		}
		else {
			
			int x5 = Math.max(rect1[0], rect1[4]);
			int y5 = Math.max(rect1[1], rect1[5]);
			int x6 = Math.min(otherx1, otherx2);
			int y6 = Math.min(othery1, othery2);
		
			System.out.println("There is an intersection between these two rectangles.");
			System.out.println("The intersection is at (" +x5+","+y6+")("+x6+","+y5+")");
		}
   }//closing intersection method
   
   /*This method tests for levels of containment (contained, not contained, and intersection)*/
   static void containment(int[] rect1) { 
   /*First checks if the second is contained in the first, then if the first is contained in the second.
    * If neither, it calls the intersection method to see if there is an intersection. 
    */	
   
	if (rect1[0] <= rect1[4] && rect1[1] <= rect1[5] && othery2 <= othery1 && otherx2 <= otherx1) {
			System.out.println("The second rectangle is contained within the first.");
	}
	else if (rect1[0] >= rect1[4] && rect1[1] >= rect1[5] && othery2 >= othery1 && otherx2 >= otherx1) {
			System.out.println("The first rectangle is contained within the second.");
	}
	else {
			System.out.println("There is no containment between these two rectangles.");
			intersection(rect1);
	}
   }//closing containment method
   
   /*This method tests for levels of adjacency (proper, subline, partial, and non-adjacent)*/
   static void adjacent(int[] rect1) {
   /*First determine if there is any shared side, from there determine if it is a proper, partial, or subline*/
	
	if(x1 == otherx2) {
		   System.out.println("The left side of rectangle 1 shares the right side of rectangle 2");
		   if ((othery1 == othery2) && (y2 == y1)) {
			   System.out.println("This is adjacent(Proper)");
		   }
		   else if((y1<othery2) && (othery1>othery2) && (y1>y2)) {
			   System.out.println("They are adjacent partial with the second rectangle lower than the first.");
		   }
		   else if((y2>y1) && (othery1>y2) && (othery2>othery1)) {
			   System.out.println("They are adjacent partial with the first rectangle lower than the second.");
		   }
		   else if (y1>=y2 && othery1<othery2 || y1>y2 && othery1<=othery2) {
			   System.out.println("They are adjacent subline with the first rectangle having a smaller width than the second.");
		   }
		   else if (y1<=y2 && othery1>othery2 || y1<y2 && othery1>=othery2) {
			   System.out.println("They are adjacent subline with the second rectangle having a smaller width than the first.");
		   }
		   else {
			   System.out.println("Something went wrong.");
		   }
	}
	else if(x2 == otherx1) {
		   System.out.println("The right side of rectangle 1 shares the left side of rectangle 2");
		   if ((othery1 == othery2) && (y2 == y1)) {
			   System.out.println("This is adjacent(Proper)");
		   }
		   else if((y2<othery1) && (othery2>othery1) && (y2>y1)) {
			   System.out.println("They are adjacent partial with the first rectangle lower than the second.");
		   }
		   else if((y1>y2) && (othery2>y1) && (othery1>othery2)) {
			   System.out.println("They are adjacent partial with the second rectangle lower than the first.");
		   }
		   else if (y2>=y1 && othery2<othery1 || y2>y1 && othery2<=othery1) {
			   System.out.println("They are adjacent subline with the second rectangle having a smaller width than the first.");
		   }
		   else if (y2<=y1 && othery2>othery1 || y2<y1 && othery2>=othery1) {
			   System.out.println("They are adjacent subline with the first rectangle having a smaller width than the second.");
		   }
		   else {
			   System.out.println("Something went wrong.");
		   }
	}
	else if(y1 == othery2) {
		   System.out.println("The bottom of rectangle 1 is shared with the top of rectangle 2");
		   if(x2 == x1 && otherx2 == otherx1) {
			   System.out.println("They are adjacent proper."); 
		   }
		   else if((x1<otherx2) && (otherx1>otherx2) && (x1>x2)) {
			   System.out.println("They are adjacent partial with the first rectangle more to the right than the second.");
		   }
		   else if((x2>x1) && (otherx1>x2) && (otherx2>otherx1)) {
			   System.out.println("They are adjacent partial with the second rectangle more to the right than the first.");
		   }
		   else if (x1>=x2 && otherx1<otherx2 || x1>x2 && otherx1<=otherx2) {
			   System.out.println("They are adjacent subline with the first rectangle having a smaller length than the second.");
		   }
		   else if (x1<=x2 && otherx1>otherx2 || x1<x2 && otherx1>=otherx2) {
			   System.out.println("They are adjacent subline with the second rectangle having a smaller length than the second.");
		   }
		   else {
			   System.out.println("Something went wrong.");
		   }
	}
	else if(y2 == othery1) { 
		   System.out.println("The bottom of rectangle 2 is shared with the top of rectangle 1");
		   if(x2 == x1 && otherx2 == otherx1) {
			   System.out.println("They are adjacent proper."); 
		   }
		   else if((x2<otherx1) && (otherx2>otherx1) && (x2>x1)) {
			   System.out.println("They are adjacent partial with the first rectangle more to the left than the second.");
		   }
		   else if((x1>x2) && (otherx2>x1) && (otherx1>otherx2)) {
			   System.out.println("They are adjacent partial with the second rectangle more to the left than the first.");
		   }
		   else if (x2>=x1 && otherx2<otherx1 || x2>x1 && otherx2<=otherx1) {
			   System.out.println("They are adjacent subline with the second rectangle having a smaller length than the first.");
		   }
		   else if (x2<=x1 && otherx2>otherx1 || x2<x1 && otherx2>=otherx1) {
			   System.out.println("They are adjacent subline with the first rectangle having a smaller length than the second.");
		   }
		   else {
			   System.out.println("Something went wrong.");
		   }
	}
	else {
		   System.out.println("The two rectangles are not adjacent");
	}
   }//closing adjacent method
 	      
   /*This method is for the pop up where a user selects 'intersection,containment,adjacent, or quits the program*/
   static void selection(int[] rect1) {
	   
	    String[] options = new String[] {"Intersection", "Containment", "Adjacency", "Quit"};
	    int response = JOptionPane.showOptionDialog(null, "Here are the options of preset rectangles to choose from", "Options",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
	    
		if (response == 0) {
			intersection(rect1);
		}
		else if (response == 1) {
			containment(rect1);
		}
		else if (response == 2) {
			adjacent(rect1);	
		}
		else {
			System.out.println("Thank you for your time. Have a great day!");
			System.exit(0);		
		}
		return;
   }//closing selection
   
   
   public static void main(String[] args) /*throws Exception*/ {//open main
	   
	       int option = 1; //var to keep loop going for user to select multiple options with the same data set
	   
		   System.out.println("Hello Nuvalence employee!");
		   System.out.println("In this program we will analyze two rectangles as requested.");
		   System.out.println("The following input requests are in regard to the first rectangle to be used in the comparison.");
		   	   //Taking user input and then storing it into an array to be passed to other methods
		       System.out.println("Please enter an X value of the bottom left corner:");
			   x1 = keyboard.nextInt(); 
			   rect1[0] = x1;
			   System.out.println("Please enter a Y value of the bottom left corner:");
			   y1 = keyboard.nextInt();
			   rect1[1] = y1;
			   System.out.println("Please enter a width value:");
			   width1 = keyboard.nextInt();
			   rect1[2] = width1;
			   //The below ensures it is not a line
			   while (width1 ==0 ) {
				   System.out.println("Please enter a value other than 0 for a rectangle to have dimension.");
				   System.out.println("Please enter a length value:");
				   width1 = keyboard.nextInt();
				   rect1[2] = width1;
			   }
			   System.out.println("Please enter a length value:");
			   length1 = keyboard.nextInt();
			   rect1[3] = length1;
			   //The below ensures it is a rectangle and not a square
			   while (length1 == width1) {
				   System.out.println("Please enter a value different than the width for a rectangle.");
				   System.out.println("Please enter a length value:");
				   length1 = keyboard.nextInt();
				   rect1[3] = length1;
			   }
			   //The below ensures it is not a line
			   while (length1 ==0 ) {
				   System.out.println("Please enter a value other than 0 for a rectangle to have dimension.");
				   System.out.println("Please enter a length value:");
				   length1 = keyboard.nextInt();
				   rect1[3] = length1;
			   }
			   System.out.println("The following input requests are in regard to the second rectangle to be used in the comparison.");
			   System.out.println("Please enter a x value of the bottom left corner:");
			   x2 = keyboard.nextInt();
			   rect1[4] = x2;
			   System.out.println("Please enter a Y value of the bottom left corner:");
			   y2 = keyboard.nextInt();
			   rect1[5] = y2;
			   System.out.println("Please enter a width value:");
			   width2 = keyboard.nextInt();
			   rect1[6] = width2;
			   //The below ensures it is not a line
			   while (width2 ==0 ) {
				   System.out.println("Please enter a value other than 0 for a rectangle to have dimension.");
				   System.out.println("Please enter a length value:");
				   width2 = keyboard.nextInt();
				   rect1[6] = width2;
			   }
			   System.out.println("Please enter a length value:");
			   length2 = keyboard.nextInt();
			   rect1[7] = length2;
			   //The below ensures it is a rectangle and not a square
			   while (length2 == width2) {
				   System.out.println("Please enter a value different than the width for a rectangle.");
				   System.out.println("Please enter a length value:");
				   length2 = keyboard.nextInt();
				   rect1[7] = length2;
			   }
			   //The below ensures it is not a line
			   while (length2 ==0 ) {
				   System.out.println("Please enter a value other than 0 for a rectangle to have dimension.");
				   System.out.println("Please enter a length value:");
				   length2 = keyboard.nextInt();
				   rect1[7] = length2;
			   }
			   
			   otherx1 = rect1[0] + rect1[3];
			   otherx2 = rect1[4] + rect1[7];
			   othery1 = rect1[1] + rect1[2];
			   othery2 = rect1[5] + rect1[6];
			   
			   //output what the user entered to paint the picture in their mind
			    System.out.println("Points in the bottom left corner for RT 1: (" + rect1[0] + "," + rect1[1] + "), with a with of " + rect1[2] + " and a length of: " + rect1[3]);
				System.out.println("The coordinates for the opposite upper right corner of the rectangle are : (" + otherx1 + "," + othery1 + ")");
			    System.out.println("Points in the bottom left corner for RT 2: (" + rect1[4] + "," + rect1[5] + "), with a with of " + rect1[6] + " and a length of: " + rect1[7]);
			    System.out.println("The coordinates for the opposite upper right corner of the rectangle are : (" + otherx2 + "," + othery2 + ")");
			 	  
		  //TODO:Need to find how to make this display work it pops up but does not draw
			  /* 
				SwingUtilities.invokeAndWait(new Runnable() {
		        @Override
				public void run(){
				new Rectangles().setVisible(true); //display the drawn rectangles
				}});
			  */
			   
		   while(option == 1) {//to allow user to select different forms of analysis for the same data set
				   selection(rect1);
		   }		
		   
		   keyboard.close();
	   
	}//closing main
}//closing class
