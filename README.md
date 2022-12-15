# Rectangles
READ ME:
Catherine Davis  
November 2022

This program will analyze rectangles and features that exist among rectangles
such as: intersection, containment, and adjacency (sub-line share, partial, proper) 
This will be done by first taking in information about two rectangles from the 
user and then prompting the user to select which type of analysis they would 
like to have done. This is on a continuous loop so the user can select different
analysis of the same data set. There is an option to exit to terminate the program.

Left to finish would be to iron out the final display of the rectangles 
the user entered into the program. This call is in the main after the user enters the data set.
Currently when the program is run with that portion of the code uncommented
the pop-up appears but the drawn image does not appear. 
I left the code I have commented out as an indicator of where my next efforts 
would go to in order to expand this program.

Test data to enter with expected output:

{0,0,1,2,3,4,5,6}      This is not adjacent, nor is it contained, nor is it an intersection.

{0,0,4,5,2,3,4,5}      This is not adjacent, nor is it contained, it is an intersection at (2,4),(5,3).

{0,0,100,101,5,5,3,10} This is not adjacent, it is contained, and it is not an intersection.

{5,5,4,5,0,0,100,101}  This is not adjacent, it is contained, and it is not an intersection.

{0,0,5,6,6,0,5,8}      This is adjacent proper, it is not contained, and it does not intersect 

{0,0,5,6,0,5,7,6}	     This is adjacent proper, it is not contained, and it does not intersect  

{0,0,10,3,3,5,10,3}	   This is adjacent partial, not contained, no intersection.  

{3,5,10,3,0,0,10,3)	   This is adjacent partial, not contained, no intersection. 

{0,0,5,10,5,5,6,8}	   This is adjacent partial, not contained, no intersection.  

{5,5,6,8,0,0,5,10}	   This is adjacent partial, not contained, no intersection.  

{0,0,10,5,5,2,1,5}     This is adjacent sub-line, not contained, no intersection. 

{0,2,1,5,5,0,10,11}    This is adjacent sub-line, not contained, no intersection. 

{0,10,3,14,4,0,10,5}   This is adjacent sub-line, not contained, no intersection. 

{0,0,5,20,10,5,7,3}    This is adjacent sub-line, not contained, no intersection. 

{0,0,9,10,0,2,3,4}     This is adjacent sub-line, contained, no intersection.
