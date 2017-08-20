package com.billkang.designmode;

/**
 * 657. Judge Route Circle
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 * <p>
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 * Created by Kangbin on 2017/8/20.
 */
public class _657JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                default:
                    break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        boolean s1 = new _657JudgeRouteCircle().judgeCircle("UD");
        boolean s2 = new _657JudgeRouteCircle().judgeCircle("LL");
        System.out.println(s1);
        System.out.println(s2);
    }
}
