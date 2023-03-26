package leetcode.Labuladong.F_DfsBfs.D_Bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class C_slidingPuzzle_773 {

    int row = 2, col = 3;

    /** 
     * 用string，转成charArray，转换位置更方便 ;
     * charArray，可以直接通过 indexOf 函数，查询下标 ;
     * */
    public int slidingPuzzle(int[][] board) {
        Set<Integer> boardSet = new HashSet<>();

        int boardInt = 1000000, blankPos = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                boardInt += board[i][j] * ((int) Math.pow(10, 5 - i * col - j));
                if (board[i][j] == 0) blankPos = 6 - i * col - j;
            }
        MyBoard start = new MyBoard(boardInt, blankPos);
        int endboradInt = 1123450;
        if(boardInt==endboradInt)  return 0;

        Queue<MyBoard> queue = new ArrayDeque<>();
        queue.add(start);
        
        int moves = 0;
        while (!queue.isEmpty()) {
            moves++;
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                MyBoard curr = queue.poll();
                for (MyBoard nextBoard : nextBoardList(curr,boardSet)) {
                    if(nextBoard.board==endboradInt)
                        return moves;
                    boardSet.add(nextBoard.board);
                    queue.add(nextBoard);
                }
            }
        }
        return -1;
    }

    public List<MyBoard> nextBoardList(MyBoard myBoard,Set<Integer> boardSet) {
        List<MyBoard> lists = new ArrayList<>();
        int[][][] neighbors = { {{1,2},{1,4}},
                                {{2,1},{2,3},{2,5}},
                                {{3,2},{3,6}},
                                {{4,1},{4,5}},
                                {{5,2},{5,4},{5,6}},
                                {{6,3},{6,5}}};
        int[][] currPosList = neighbors[myBoard.blankPos - 1];
        for (int[] pos : currPosList) {
            int changeBoard = changeIntPos(myBoard.board,pos[0],pos[1]);
            if(!boardSet.contains(changeBoard))
                lists.add(new MyBoard(changeBoard, pos[1]));
        }
        return lists;
    }

    public int changeIntPos(int boardInt,int pos1,int pos2){
        int pos1Unit = (int)(Math.pow(10,pos1-1)),
            pos2Unit = (int)(Math.pow(10,pos2-1));
        int pos1Num = boardInt / pos1Unit % 10;
        int pos2Num = boardInt / pos2Unit % 10;
        return boardInt-pos1Num*pos1Unit-pos2Num*pos2Unit
                       +pos1Num*pos2Unit+pos2Num*pos1Unit;
    }

    public static class MyBoard {

        public int board;
        public int blankPos;

        public MyBoard(int board, int blankPos) {
            this.board = board;
            this.blankPos = blankPos;
        }

        @Override
        public String toString() {
            return "board=" + String.valueOf(this.board) + ", blankPos=" + String.valueOf(this.blankPos);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.board, this.blankPos);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            MyBoard coord = (MyBoard) obj;
            return this.board == coord.board && this.blankPos == coord.blankPos;
        }
    }

    public static void main(String[] args) {
        int[][] board = { { 4,1,2 }, { 5,0,3 } };
        C_slidingPuzzle_773 solution = new C_slidingPuzzle_773();
        System.out.println(solution.slidingPuzzle(board));

        // System.out.println(solution.nextBoard(new MyBoard(1123405, 2),new HashSet<Integer>()));
    }
}
