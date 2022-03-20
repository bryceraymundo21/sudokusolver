import java.util.ArrayList;
import java.util.Random;

public class SolverTester {
    public static void main(String [] args){
        Sudoku stuff = new Sudoku();
    }
}

class Sudoku {
    private int [][] board; 
    private ArrayList<Integer> choices;
    private int difficulty;


    public Sudoku(){
        //Generates a 9x9 filled board
        board = new int [9][9];   
        choices = new ArrayList();

        //Generate a filled 3x3 board
        // for(int row = 0; row<board.length; row++) {
        //     for(int col = 0; col <board[row].length; col++){
        //         int randomOption = new Random().nextInt(choices.size());
        //         board[row][col] = choices.get(randomOption);
        //         choices.remove(randomOption);
        //     }
        // }
        
        generateBoard();
        //print();
    }
    
    //Generates a 9x9 board ready for solving
    public void generateBoard(){
        board[0][0] = 9;
        board[0][1] =4;
        //board[0][4] = 6;
        board[0][5] = 1;
        board[0][8]=3;
        board[1][0] =7;
        board[1][3]=4;
        board[1][5]=3;
        board[1][7]=6;
        board[1][8]=1;
        board[2][0]=3;
        board[2][2]=6;
        board[2][3]=7;
        board[2][4]=9;
        board[2][5]=5;
        board[2][6]=8;
        board[2][8]=4;
        board[3][1]=8;
        board[3][4]=4;
        board[3][5]=9;
        board[3][7]=5;
        board[4][3]=1;
        board[4][4]=5;
        board[4][5]=2;
        board[4][6]=3;
        board[4][7]=9;
        board[4][8]=8;
        board[5][0]=2;
        board[5][2]=5;
        board[5][3]=3;
        board[5][4]=7;
        board[5][5]=8;
        board[5][6]=4;
        board[5][7]=1;
        board[6][2]=1;
        board[7][0]=8;
        board[7][3]=9;
        board[7][5]=7;
        board[7][6]=6;
        board[8][1]=3;
        board[8][3]=2;
        board[8][5]=6;
        board[8][6]=1;

        


        //Generates a board that is completely solved(no it doesnt lol)
        //You need to check for how many solutions there are first, if there are multiple then dont put the number in
        while(true){
            int zeros = 0;
            for(int i = 0; i <board.length; i++){
                for(int j = 0; j<board[i].length; j++){
                    //int randomOption = new Random().nextInt(choices.size());
                    //int num = choices.get(0);
                    if(board[i][j]==0) zeros++;
                    if(board[i][j]!=0) {
                        
                        continue;
                    }
                    //if there is only one choice, input the number, otherwise, move on
                    int options = 0;
                    int add = 0;
                    for(int x=1; x<10; x++){
                        if(!hasDuplicates(i, j, x)){
                            add = x;
                            options++;
                        }
                        if(options>1) break;
                    }
                    if(options>1)continue;
                    board[i][j] = add;
                    print();
                    System.out.println();
                    
                    
                }
                
            }
            if(zeros == 0){
                break;
            }
        }   
        print();
        //fix this next
        

        //int randomSkips = new Random().nextInt(3);
        // int randomSkips = 0;
        // for(int row = 0; row<board.length; row++){
        //     for(int col = 0; col<board[row].length; col++){
        //         if(randomSkips > 0) {
        //             board[row][col] = 0;
        //             randomSkips--;
        //         }else{
        //             if(choices.size()==0){
        //                 for(int i = 1; i<10; i++){
        //                     choices.add(i);
        //                 }
        //             }
        //             //int randomOption = new Random().nextInt(choices.size());
        //             //System.out.println(randomOption);

        //             int randomOption = 2;
        //             while(hasDuplicates(row, col, randomOption)){
                        
        //                 board[row][col] = choices.get(randomOption);
                        
        //                 //choices.remove(randomOption);
        //                 //randomOption = new Random().nextInt(choices.size());
        //             }
        //             //System.out.println(choices.toString());
        //             //randomSkips = new Random().nextInt(3);
        //         }
        //     }
        // }
    }

    /**
     * 
     * @param x row
     * @param y column
     * @param add number to be potentially added
     * @return are there duplicates
     */
    public boolean hasDuplicates(int x, int y, int add){
        //int addY=0;
        int startX=x;
        int startY=y;

        if( x%3 == 1 ){
            startX=x-1;

        }else if( x%3 == 2 ) {
            startX=x-2;
        }

        if(y%3==1){
            startY=y-1;
        }else if(y%3==2){
            startY=y-2;
        }
        
        for(int i = 0; i< board.length; i++){
            if(board[x][i] == add){
                return true;
            }
            if(board[i][y] == add){
                return true;
            }
            if(board[startX][startY]== add){
                return true;
            }
            if((i+1)%3 == 0){
                startX++;
                startY-=2;
                
            }else{
                startY++;
            }

        }
        return false;
    }
    /**
     * Assumptions
     * 1. There will always be at least one square that only has one solution
     * 2. Find this through other numbers in that row, column, or 3x3 square
     * 3. Every square has an array attached to it with every possible number solution
     */
    public void solver(){

    }

    /**
     * 
     * @return all possible solutions for that square
     */
    private int[] possibleSolutions(){
        int [] arr = new int[9];
        return arr;
    }

    public void print(){
        for (int x = 0; x<board.length; x++) {
            for (int y = 0; y<board[x].length; y++) {
                System.out.print(board[x][y] + "  ");
                if(y==8) System.out.println();
            }
        }
    }


}
    


