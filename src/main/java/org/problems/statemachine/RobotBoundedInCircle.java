package org.problems.statemachine;

/**
 * https://leetcode.com/problems/robot-bounded-in-circle 
 * 
 * 
 * On an infinite plane, a
 * robot initially stands at (0, 0) and faces north. The robot can receive one
 * of three instructions: "G": go straight 1 unit; "L": turn 90 degrees to the
 * left; "R": turn 90 degress to the right. The robot performs the instructions
 * given in order, and repeats them forever. 
 * 
 * Return true if and only if there
 * exists a circle in the plane such that the robot never leaves the circle.
 */
public class RobotBoundedInCircle {

    static class Robot {
        static int[] next = { 1, 10, -1, -10 };
        int dx = 0, dy = 1;
        int[] coords = new int[2];

        public void setDir(char c) {
            int cur = dx * 10 + dy;
            for (int i = 0; i < 4; i++) {
                if (next[i] == cur) {
                    int indx = 0;
                    if (c == 'L') {
                        indx = (i + 4 - 1) % 4;
                    } else if (c == 'R') {
                        indx = (i + 1) % 4;
                    }
                    dy = next[indx] % 10;
                    dx = next[indx] / 10;
                    return;
                }
            }
        }

        public int[] move(int step) {
            coords[0] += dx * step;
            coords[1] += dy * step;
            return coords.clone();
        }
    }

    static boolean check(String instructions) {
        Robot r = new Robot();
        char[] cmd = instructions.toCharArray();
        int[] next = new int[2];
        for (char c : cmd) {
            if (c == 'L' || c == 'R') {
                r.setDir(c);
            } else {
                next = r.move(1);
            }
        }
        if (next[0] == 0 && next[1] == 0) {
            return true;
        }
        return false;
    }

    public boolean isRobotBounded(String instructions) {
        if (check(instructions)) {
            return true;
        }
        String alt = instructions + instructions + instructions + instructions;
        return check(alt);
    }

    public static void main(String[] arg) {

        System.out.println("D");

    }

}
