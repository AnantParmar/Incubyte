public class SpacecraftMovement {
    public static void main(String[] args) {
       int[] position = {0,0,0};
       char direction = 'N';
       char[] commands = {'f', 'r', 'u', 'b', 'l'};
       
        for(int i=0;i<commands.length;i++) {
            if(commands[i]=='f') {
                moveForward(direction, position);
            } else if(commands[i]=='b') {
                moveBackward(direction, position);
            }
        }

       System.out.println("Final Position: (" + position[0] + ", " + position[1] + ", " + position[2] + ")");
       System.out.println("Final Direction: " + direction);
    }

    // moveForward method Implementation
    public static void moveForward(char direction, int[] position) {
        switch (direction) {
            case 'N':
                position[1]++;
                break;
            case 'S':
                position[1]--;
                break;
            case 'E':
                position[0]++;
                break;
            case 'W':
                position[0]--;
                break;
            case 'U':
                position[2]++;
                break;
            case 'D':
                position[2]--;
                break;
        }
    }

    // moveBackward method Implementation
    public static void moveBackward(char direction, int[] position) {
        switch (direction) {
            case 'N':
                position[1]--;
                break;
            case 'S':
                position[1]++;
                break;
            case 'E':
                position[0]--;
                break;
            case 'W':
                position[0]++;
                break;
            case 'U':
                position[2]--;
                break;
            case 'D':
                position[2]++;
                break;
        }
    }
}
