import java.util.ArrayList;

public class SpacecraftMovement {
    public static void main(String[] args) {
       int[] position = {10,10,0};
       char direction = 'N';
       char[] commands = {'f', 'r', 'f', 'r', 'f', 'l', 'f', 'l', 'b', 'b'};
       ArrayList<Character> arrayOfDirections = new ArrayList<Character>();
       arrayOfDirections.add('N');
       char lastDirection = 'N';
        for(int i=0;i<commands.length;i++) {
            switch (commands[i]) {
                case 'f':
                    moveForward(direction, position);
                    break;

                case 'b':
                    moveBackward(direction, position);
                    break;

                case 'r':
                    lastDirection = findLastDirection(arrayOfDirections, arrayOfDirections.size());
                    direction = turnRight(direction,lastDirection);
                    arrayOfDirections.add(direction);
                    break;

                case 'l':
                    lastDirection = findLastDirection(arrayOfDirections, arrayOfDirections.size());
                    direction = turnLeft(direction,lastDirection);
                    arrayOfDirections.add(direction);
                    break;

                case 'u':
                    direction = turnUp(direction);
                    arrayOfDirections.add(direction);
                    break;

                case 'd':
                    direction = turnDown(direction);
                    arrayOfDirections.add(direction);
                    break;
                
            }   
            
        }
        System.out.println("Final Direction: " + direction);
        System.out.println("Final Position: (" + position[0] + ", " + position[1] + ", " + position[2] + ")");

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

    // turnRight methd Implementation
    public static char turnRight(char direction, char lastChar) {
        switch (direction) {
            case 'N':
                return 'E';
            case 'S':
                return 'W';
            case 'E':
                return 'S';
            case 'W':
                return 'N';
            case 'U':
                if(lastChar == 'E')
                    return 'S';
                else if(lastChar == 'W')
                    return 'N';
                else if(lastChar == 'N')
                    return 'E';
                else if(lastChar == 'S')
                    return 'W';
                else
                    return direction;
                
            case 'D':
                if(lastChar == 'E')
                    return 'S';
                else if(lastChar == 'W')
                    return 'N';
                else if(lastChar == 'N')
                    return 'E';
                else if(lastChar == 'S')
                    return 'W';
                else 
                    return direction;
            default:
                return direction;
        }
    }

    // turnLeft method implementation
    public static char turnLeft(char direction,char lastChar) {
        switch (direction) {
            case 'N':
                return 'W';
            case 'S':
                return 'E';
            case 'E':
                return 'N';
            case 'W':
                return 'S';
            case 'U':
                if(lastChar == 'E')
                    return 'N';
                else if(lastChar == 'W')
                    return 'S';
                else if(lastChar == 'N')
                    return 'W';
                else if(lastChar == 'S')
                    return 'E';
            case 'D':
                if(lastChar == 'E')
                    return 'N';
                else if(lastChar == 'W')
                    return 'S';
                else if(lastChar == 'N')
                    return 'W';
                else if(lastChar == 'S')
                    return 'E'; 
            default:
                return direction;
        }
    }

    // turnUp method Implementation
    public static char turnUp(char direction) {
        if (direction == 'N' || direction == 'S' || direction == 'E' || direction == 'W') {
            return 'U';
        } else {
            return direction;
        }
    }

    // turnDown method Implementation
    public static char turnDown(char direction) {
        if (direction == 'N' || direction == 'S' || direction == 'E' || direction == 'W') {
            return 'D';
        } else {
            return direction;
        }
    }

    // findLastDirection method implementation
    public static char findLastDirection(ArrayList<Character> arrayOfDirections,int i) {
        for(int j = i-1;j>=0;j--) {
            char temp = arrayOfDirections.get(j);
            if(temp != 'U' && temp != 'D')
            return temp;
        }
        return arrayOfDirections.get(i-1);
    }

}
