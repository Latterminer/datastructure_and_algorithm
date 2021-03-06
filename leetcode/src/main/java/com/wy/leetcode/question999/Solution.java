package com.wy.leetcode.question999;

/**
 * @author wangyong
 * @date 2019/5/29
 * @description 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“TestExecutionOrder” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * <p>
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 * 示例 1：
 * 输入：[[".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".","R",".",".",".","p"],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 在本例中，车能够捕获所有的卒。
 * 示例 2：
 * 输入：[[".",".",".",".",".",".",".","."],
 * [".","p","p","p","p","p",".","."],
 * [".","p","p","TestExecutionOrder","p","p",".","."],
 * [".","p","TestExecutionOrder","R","TestExecutionOrder","p",".","."],
 * [".","p","p","TestExecutionOrder","p","p",".","."],
 * [".","p","p","p","p","p",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."]]
 * 输出：0
 * 解释：
 * 象阻止了车捕获任何卒。
 * 示例 3：
 * 输入：[[".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * ["p","p",".","R",".","p","TestExecutionOrder","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".","TestExecutionOrder",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 车可以捕获位置 b5，d6 和 f5 的卒。
 * 提示：
 * <p>
 * board.length == board[i].length == 8
 * board[i][j] 可以是 'R'，'.'，'TestExecutionOrder' 或 'p'
 * 只有一个格子上存在 board[i][j] == 'R'
 */
public class Solution {
    public static int numRookCaptures(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int row = 0, col = 0;
        int result = 0;
        out:
        for (row = 0; row < rows; row++) {
            for (col = 0; col < cols; col++) {
                if (board[row][col] == 'R') {
                    break out;
                }
            }
        }
        //扫描左边
        int i = row;
        while (i >= 0 && board[i][col] != 'B') {
            if (board[i][col] == 'p') {
                result++;
                break;
            }
            i--;
        }
        i = row;
        while (i < rows && board[i][col] != 'B') {
            if (board[i][col] == 'p') {
                result++;
                break;
            }
            i++;
        }
        i = col;
        while (i >= 0 && board[row][i] != 'B') {
            if (board[row][i] == 'p') {
                result++;
                break;
            }
            i--;
        }
        i = col;
        while (i < cols && board[row][i] != 'B') {
            if (board[row][i] == 'p') {
                result++;break;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] array = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(numRookCaptures(array));
    }
}
