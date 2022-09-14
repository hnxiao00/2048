/*********************************************
* Game
* Author:  Hannah Xiao
* Pennkey: hnxiao
*
* Description:
* This program executes the game 2048
* Execution:    java Game
*
*********************************************/
public class Game {
    public static void main(String[] args) {
        //Setting up the board
        boolean playing = true;
        //Initialize the tiles and set equal to 0
        Tile[][] board = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = new Tile(0, i, j);
            }
        }
        drawBoard(board);
        //Generate two starting tiles
        newTile(board);
        newTile(board);
        
        int countSteps = 0;
        //
        while (playing) {
            //accept keyboard entries
            if (PennDraw.hasNextKeyTyped()) {
                //initialize a copy of the array
                Tile[][] array = new Tile[4][4];
                //switch case for each of the letters corresponding to a direction
                switch(PennDraw.nextKeyTyped()) {
                    //move right, check if this results in a losing board
                    case 'd':
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            array[i][j] = new Tile(0, i, j);
                            array[i][j].setValue(board[i][j].getValue());
                        }
                    }
                    //if moving is a valid move, add a new tile and increase count
                    if (moveRight(board)) {
                        countSteps = countSteps + 1;
                        newTile(board);
                    }
                    if (checkLoss(array, board, countSteps)) {
                        playing = false;
                    }
                    break;
                    
                    //move left, check if this results in a losing board
                    case 'a':
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            array[i][j] = new Tile(0, i, j);
                            array[i][j].setValue(board[i][j].getValue());
                        }
                        
                    }
                    //if moving is a valid move, add a new tile and increase count
                    if (moveLeft(board)) {
                        countSteps = countSteps + 1;
                        newTile(board);
                    }
                    if (checkLoss(array, board, countSteps)) {
                        playing = false;
                    }
                    break;
                    
                    //move up, check if this results in a losing board
                    case 'w':
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            array[i][j] = new Tile(0, i, j);
                            array[i][j].setValue(board[i][j].getValue());
                        }
                        
                    }
                    //if moving is a valid move, add a new tile and increase count
                    if (moveUp(board)) {
                        countSteps = countSteps + 1;
                        newTile(board);
                    }
                    if (checkLoss(array, board, countSteps)) {
                        playing = false;
                    }
                    break;
                    
                    case 's':
                    //move right, check if this results in a losing board
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            array[i][j] = new Tile(0, i, j);
                            array[i][j].setValue(board[i][j].getValue());
                        }
                        
                    }
                    //if moving is a valid move, add a new tile and increase count
                    if (moveDown(board)) {
                        countSteps = countSteps + 1;
                        newTile(board);
                    }
                    if (checkLoss(array, board, countSteps)) {
                        playing = false;
                    }
                    break;
                    default:
                    break;
                }
                System.out.println(countSteps);
            }
            checkWin(board, countSteps);
            if (checkWin(board, countSteps)) {
                playing = false;
            }
        }
    }
    
    /**
    * Inputs: The board array
    * Outputs: true if the right move is a valid move that increases count
    * Description: This function moves everything to the right
    */
    public static boolean moveRight(Tile[][] board) {
        //Make a copy of the board so invalid moves can't be made
        Tile[][] array = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = new Tile(0, i, j);
                array[i][j].setValue(board[i][j].getValue());
            }
        }
        boolean isMoveValid = false;
        //move all squares to the right if possibe
        for (int k = 0; k < 4; k = k + 1) {
            for (int i = 0; i < 4; i = i + 1) {
                for (int j = 3; j > 0; j = j - 1) {
                    add(board[j - 1][i], board[j][i]);
                }
            }
        }
        //make the move valid as long as every element isn't the same
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!array[i][j].equals(board[i][j])) {
                    isMoveValid = true;
                }
            }
        }
        drawBoard(board);
        return isMoveValid;
    }
    
    /**
    * Inputs: The board array
    * Outputs: true if the up move is a valid move that increases count
    * Description: This function moves everything up
    */
    public static boolean moveUp(Tile[][] board) {
        //Make a copy of the board so invalid moves can't be made
        Tile[][] array = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = new Tile(0, i, j);
                array[i][j].setValue(board[i][j].getValue());
            }
        }
        boolean isMoveValid = false;
        //move all squares up if possibe
        for (int k = 0; k < 4; k = k + 1) {
            for (int i = 0; i < 4; i = i + 1) {
                for (int j = 3; j > 0; j = j - 1) {
                    add(board[i][j - 1], board[i][j]);
                }
            }
        }
        //make the move valid as long as every element isn't the same
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!array[i][j].equals(board[i][j])) {
                    isMoveValid = true;
                }
            }
        }
        drawBoard(board);
        return isMoveValid;
    }
    
    /**
    * Inputs: The board array
    * Outputs: true if the down move is a valid move that increases count
    * Description: This function moves everything down
    */
    public static boolean moveDown(Tile[][] board) {
        //Make a copy of the board so invalid moves can't be made
        Tile[][] array = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = new Tile(0, i, j);
                array[i][j].setValue(board[i][j].getValue());
            }
        }
        boolean isMoveValid = false;
        //move all squares down if possibe
        for (int k = 0; k < 4; k = k + 1) {
            for (int i = 0; i < 4; i = i + 1) {
                for (int j = 0; j < 3; j = j + 1) {
                    add(board[i][j + 1], board[i][j]);
                }
            }
        }
        //make the move valid as long as every element isn't the same
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!array[i][j].equals(board[i][j])) {
                    isMoveValid = true;
                }
            }
        }
        drawBoard(board);
        return isMoveValid;
    }
    
    /**
    * Inputs: The board array
    * Outputs: true if the left move is a valid move that increases count
    * Description: This function moves everything to the left
    */
    public static boolean moveLeft(Tile[][] board) {
        //Make a copy of the board so invalid moves can't be made
        Tile[][] array = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = new Tile(0, i, j);
                array[i][j].setValue(board[i][j].getValue());
            }
        }
        boolean isMoveValid = false;
        //move all squares to the left if possibe
        for (int k = 0; k < 4; k = k + 1) {
            for (int i = 0; i < 4; i = i + 1) {
                for (int j = 0; j < 3; j = j + 1) {
                    add(board[j + 1][i], board[j][i]);
                }
            }
        }
        //if any element is different, the board is changed
        //by the move and the move is valid
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!array[i][j].equals(board[i][j])) {
                    isMoveValid = true;
                }
            }
        }
        drawBoard(board);
        return isMoveValid;
    }
    
    /**
    * Inputs: The board array and number of steps
    * Outputs: none
    * Description: This function checks if anyone has won,
    * gives a winning message and says the step count
    */
    public static boolean checkWin(Tile[][] tile, int count) {
        //check if any tile had value of 2048, if so, give message
        boolean win = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tile[i][j].getValue() == 2048) {
                    PennDraw.setPenColor(PennDraw.BLACK);
                    PennDraw.setFontSize(20);
                    PennDraw.text(.5, .5, "Congrats you won! Step Count = " + count);
                    win = true;
                }
            }
        }
        return win;
    }
    
    /**
    * Inputs: A copy of the board and the board itself
    * Outputs: Boolean if the two boards are the same or not
    * Description: This function checks if the two boards are the same
    */
    public static boolean checkChanged(Tile[][] array, Tile[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!array[i][j].equals(board[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
    * Inputs: The board array
    * Outputs: none
    * Description: This function checks if the player has lost
    */
    public static boolean checkLoss(Tile[][] array, Tile[][] board, int count) {
        boolean canRight = false;
        boolean canLeft = false;
        boolean canDown = false;
        boolean canUp = false;
        
        //perform right move on copied array
        for (int k = 0; k < 4; k = k + 1) {
            for (int i = 0; i < 4; i = i + 1) {
                for (int j = 3; j > 0; j = j - 1) {
                    add(array[j - 1][i], array[j][i]);
                }
            }
        }
        //check if right move changes array
        canRight = checkChanged(array, board);
        
        //perform down move on copied array
        for (int k = 0; k < 4; k = k + 1) {
            for (int i = 0; i < 4; i = i + 1) {
                for (int j = 0; j < 3; j = j + 1) {
                    add(array[i][j + 1], array[i][j]);
                }
            }
        }
        //check if down move changes array
        canDown = checkChanged(array, board);
        
        //perform up move on copied array
        for (int k = 0; k < 4; k = k + 1) {
            for (int i = 0; i < 4; i = i + 1) {
                for (int j = 3; j > 0; j = j - 1) {
                    add(array[i][j - 1], array[i][j]);
                }
            }
        }
        //check if up move changes array
        canUp = checkChanged(array, board);
        
        //perform left move on copied array
        for (int k = 0; k < 4; k = k + 1) {
            for (int i = 0; i < 4; i = i + 1) {
                for (int j = 0; j < 3; j = j + 1) {
                    add(array[j + 1][i], array[j][i]);
                }
            }
        }
        //check if left move changes array
        canLeft = checkChanged(array, board);
        
        //if copy is unchanged by all moves, no more possible moves, player loses
        if (canLeft == false && canUp == false && canDown == false && 
            canRight == false) {
            PennDraw.setPenColor(PennDraw.BLACK);
            PennDraw.setFontSize(20);
            PennDraw.text(.5, .5, "You lose!  Hit run to play again!");
            PennDraw.text(.5, .3,  "Step Count = " + count);
            return true;
        }
        return false;
    }
    
    /**
    * Inputs: board
    * Outputs: none
    * Description: This function randomly generates new tiles with value 2 or 4
    */
    public static void newTile(Tile[][] tile) {
        //initialize random numbers for position and value
        int a = (int) Math.round(Math.random() * (double) 3);
        int b = (int) Math.round(Math.random() * (double) 3);
        int d;
        double c = Math.random();
        //randomly generate a 2 or 4
        if (c > .5) {
            d = 2;
        }
        else {
            d = 4;
        }
        //if randomly selected tile is 0, change value to 2 or 4
        if (tile[a][b].getValue() == 0) {
            tile[a][b].setValue(d);
            tile[a][b].reveal();
        }
        //if randomly selected tile is not 0, find a 0 tile
        else {
            int count = 1;
            //loop through each row and column individually
            while (tile[a][b].getValue() != 0) {
                if (count % 4 != 0) {
                    a = a + 1;
                    if (a > 3) {
                        a = a % 4;
                    }
                }
                if (count % 4 == 0) {
                    b = b + 1;
                    if (b > 3) {
                        b = b % 4;
                    }
                }
                count = count + 1;
            }
            
            tile[a][b].setValue(d);
            tile[a][b].reveal();
        }
    }
    
    /**
    * Inputs: Two adjacent tiles
    * Outputs: None
    * Description: This function adds two adjecent tile
    * values by pushing tile A into tile B
    */
    public static void add(Tile a, Tile b) {
        //if the tile values are the same, make b the sum and make a 0
        if (a.equals(b)) {
            a.setValue(0);
            b.setValue(b.getValue() * 2);
        }
        //if b is 0, slide a over, make a 0
        if (b.getValue() == 0) {
            b.setValue(a.getValue());
            a.setValue(0);
        }
    }
    
    /**
    * Inputs: The tile board
    * Outputs: none
    * Description: This program draws the board with the appropriate number values
    */
    public static void drawBoard(Tile[][] board) {
        PennDraw.clear(255, 220, 122);
        PennDraw.setPenColor(PennDraw.ORANGE);
        PennDraw.setPenRadius(0.005);
        PennDraw.line(0, 0, 0, 1);
        PennDraw.line(.25, 0, .25, 1);
        PennDraw.line(.5, 0, .5, 1);
        PennDraw.line(.75, 0, .75, 1);
        PennDraw.line(1, 0, 1, 1);
        PennDraw.line(0, 0, 1, 0);
        PennDraw.line(0, .25, 1, .25);
        PennDraw.line(0, .5, 1, .5);
        PennDraw.line(0, .75, 1, .75);
        PennDraw.line(0, 1, 1, 1);
        //reveal the whole board of tiles
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j].reveal();
            }
        }
    }
}
