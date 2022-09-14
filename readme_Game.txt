/**********************************************************************
 *  readme template
 *  HW1: Rivalry and Click Art
 **********************************************************************/

Name: Hannah Xiao
PennKey: hnxiao
Hours to complete assignment (optional): 14



/**********************************************************************
 *  Please list all help, collaboration, and outside resources
 *  you used here. 
 *
 *  If you did not get any help in outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/
"I did not receive any help outside of TA office hours.  I
did not collaborate with anyone, and I did not use any
resources beyond the standard course materials."

/**********************************************************************
 *  Comments/thoughts/feedback
 **********************************************************************/
I liked this assignment, however I was really really confused on how to 
use PennDraw.nextKeyTyped() and the resources on the wiki are not helpful. 
I think it would have been helpful for me if I could see like a rubric or 
list with everything I needed to accomplish. 

/**********************************************************************
 *  How to run the program
 **********************************************************************/
Run Game.java by typing in "java Game" into the command line. There are 
no arguments needed. Tile.java is needed because the tile objects are 
stored there. 

/**********************************************************************
 *  Descriptions of each file and their purposes
 **********************************************************************/
Tile.java contains the constructor, methods and fields for the tile object. 
These are the tiles that get slid across the board and add. There are three 
fields, the value and the positions of the tile. There is a setter and a 
getter for the value because it is a private field. The method reveal will 
show the number value if it is nonzero. Tiles with a zero value are not 
shown and look empty. The method equals compares two tiles and returns whether 
they have the same value. 

Game.java has the game. First the board is drawn and an 4 x 4 array of tiles 
is instantiated. Each tile has a value of zero. There is a new tile function 
that randomly generates a 2 or 4, and puts the value in a random tile in the 
board. There are methods that "add" and "move" tiles by comparing the values of two 
tiles. For the adding method, if two input tiles have the same value, the first 
value becomes 0 and the second value becomes twice of its original value. If 
the second value is zero, it takes on the value of the first and the first 
value becomes zero. Each of the move methods move in the opposite direction 
of the direction of the move, adding every pair of tiles, in order to add the 
tiles in the right order. Each move method is looped 4 times so that tiles on 
the very far side can be added or moved if possible. After every move function, 
drawBoard() redraws the background and updates the values of the tiles. There 
is also a counter that keeps track of the number of valid moves made, with valid 
moves being meaningful moves that will change the board and create a new tile. The 
last two methods check whether the player has won or lost. If any one of the 
tiles has a value of 2048, the game ends and the player wins. If after a key 
is pressed, and none of the possible moves will change the array, the player 
loses. There is also a method that checks if an array is changed or not that 
is used in the move (to check for a valid move) and in the checkLoss methods 
(to check if any moves will change the board). 

Inside the main method of the game, while the game is still active (meaning 
playing == true), the game accepts key presses because of 
PennDraw.hasNextKeyTyped(). A switch statement decides which direction the 
tiles are moved in. This depends on which key is pressed. w is up, a is left, 
s is down and d is right. After each key is pressed, the game checks for if 
there are still possible combinations or if the player has lost. The checkWin 
method is always active and will appear immediately after the 2048 tile appears. 