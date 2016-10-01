import java.util.Scanner;

/**
 * Created by cameronseebach on 9/24/16.
 */
public class Robot {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int testcases = input.nextInt();

        for(int i = 0; i < testcases; i++){
            int l1 = input.nextInt();
            int a1 = input.nextInt();
            int l2 = input.nextInt();
            int a2 = input.nextInt();
            int lt = input.nextInt();
            int at = input.nextInt();

            RobotCount(l1, a1, l2, a2, lt, at);
        }
    }

    public static void RobotCount(int l1, int a1, int l2, int a2, int lt, int at){
        int robot1 = 0;
        int robot2 = 0;
        int counter = 0;
        int answer = 0;

        while(true) {
            //System.out.println("Answer is " + answer);
            if (answer > 1 || lt <= 0 || at <= 0){
                break;
            }

            if(lt/l1 == at/a1 && lt%l1 == 0 && at%a1 == 0){
                    robot1 = lt/l1;
                    answer++;
                    //System.out.println("Robot 1 and Robot 2: " + robot1 + " " + robot2);
            }
            
            lt = lt-l2;
            at = at-a2;
            counter++;

            //System.out.println("Counter "+ counter);
            if(lt/l1 == at/a1 && lt%l1 == 0 && at%a1 == 0){
                robot2 = counter;
            }
        }

        print(robot1, robot2, answer);
    }

    public static void print(int robot1, int robot2, int answer){
        if(answer == 1){
            System.out.println(robot1 + " " + robot2);
        } else {
            System.out.println("?");
        }
    }
}
