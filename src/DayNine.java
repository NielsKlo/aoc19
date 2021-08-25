import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class DayNine {
    BigInteger[] code;
    boolean running = true;
    boolean ended = false;
    int pointer = 0;
    int relativePointer = 0;
    BigInteger output;
    int[] currentOpcode;
    List<Integer> inputList = new ArrayList<>();

    public DayNine(int input){
        inputList.add(input);
        makeCodeArray();
    }

    private void makeCodeArray(){
        int[] code = new int[]{1102,34463338,34463338,63,1007,63,34463338,63,1005,63,53,1101,0,3,1000,109,988,209,12,9,1000,209,6,209,3,203,0,1008,1000,1,63,1005,63,65,1008,1000,2,63,1005,63,904,1008,1000,0,63,1005,63,58,4,25,104,0,99,4,0,104,0,99,4,17,104,0,99,0,0,1102,1,432,1027,1101,439,0,1026,1101,0,36,1010,1101,0,34,1018,1102,278,1,1029,1101,0,24,1002,1102,1,20,1016,1102,1,31,1011,1102,319,1,1024,1102,21,1,1012,1102,1,763,1022,1102,1,25,1007,1101,0,287,1028,1102,32,1,1008,1101,0,22,1013,1102,38,1,1001,1101,0,314,1025,1102,35,1,1009,1102,1,23,1015,1102,39,1,1019,1102,27,1,1000,1102,1,37,1003,1102,1,28,1017,1101,0,0,1020,1101,0,29,1004,1102,1,30,1006,1102,1,756,1023,1102,1,33,1005,1101,0,1,1021,1102,26,1,1014,109,13,2108,28,-7,63,1005,63,201,1001,64,1,64,1105,1,203,4,187,1002,64,2,64,109,8,21107,40,41,-3,1005,1018,225,4,209,1001,64,1,64,1105,1,225,1002,64,2,64,109,-3,1206,2,239,4,231,1105,1,243,1001,64,1,64,1002,64,2,64,109,-21,1201,6,0,63,1008,63,35,63,1005,63,267,1001,64,1,64,1105,1,269,4,249,1002,64,2,64,109,35,2106,0,-4,4,275,1001,64,1,64,1105,1,287,1002,64,2,64,109,-11,1205,-1,303,1001,64,1,64,1105,1,305,4,293,1002,64,2,64,109,8,2105,1,-5,4,311,1106,0,323,1001,64,1,64,1002,64,2,64,109,-7,21108,41,38,-6,1005,1016,339,1106,0,345,4,329,1001,64,1,64,1002,64,2,64,109,2,21102,42,1,-8,1008,1016,45,63,1005,63,369,1001,64,1,64,1105,1,371,4,351,1002,64,2,64,109,-14,21101,43,0,1,1008,1011,43,63,1005,63,397,4,377,1001,64,1,64,1106,0,397,1002,64,2,64,109,-8,21101,44,0,8,1008,1010,47,63,1005,63,417,1105,1,423,4,403,1001,64,1,64,1002,64,2,64,109,25,2106,0,0,1001,64,1,64,1105,1,441,4,429,1002,64,2,64,109,-20,2107,37,-6,63,1005,63,463,4,447,1001,64,1,64,1106,0,463,1002,64,2,64,109,8,2108,25,-8,63,1005,63,485,4,469,1001,64,1,64,1106,0,485,1002,64,2,64,109,-1,21107,45,44,-1,1005,1013,505,1001,64,1,64,1106,0,507,4,491,1002,64,2,64,109,-11,1207,-1,25,63,1005,63,529,4,513,1001,64,1,64,1106,0,529,1002,64,2,64,109,23,1206,-5,545,1001,64,1,64,1106,0,547,4,535,1002,64,2,64,109,-31,2102,1,5,63,1008,63,27,63,1005,63,569,4,553,1106,0,573,1001,64,1,64,1002,64,2,64,109,27,21102,46,1,-9,1008,1013,46,63,1005,63,595,4,579,1105,1,599,1001,64,1,64,1002,64,2,64,109,-26,2101,0,6,63,1008,63,24,63,1005,63,625,4,605,1001,64,1,64,1106,0,625,1002,64,2,64,109,5,1208,0,37,63,1005,63,645,1001,64,1,64,1105,1,647,4,631,1002,64,2,64,109,7,2102,1,-3,63,1008,63,31,63,1005,63,671,1001,64,1,64,1105,1,673,4,653,1002,64,2,64,109,2,1202,-5,1,63,1008,63,33,63,1005,63,699,4,679,1001,64,1,64,1105,1,699,1002,64,2,64,109,-4,2101,0,-3,63,1008,63,35,63,1005,63,719,1105,1,725,4,705,1001,64,1,64,1002,64,2,64,109,-5,1207,4,32,63,1005,63,741,1106,0,747,4,731,1001,64,1,64,1002,64,2,64,109,29,2105,1,-7,1001,64,1,64,1106,0,765,4,753,1002,64,2,64,109,-26,2107,36,5,63,1005,63,781,1105,1,787,4,771,1001,64,1,64,1002,64,2,64,109,10,1201,-6,0,63,1008,63,32,63,1005,63,809,4,793,1106,0,813,1001,64,1,64,1002,64,2,64,109,3,21108,47,47,-5,1005,1012,835,4,819,1001,64,1,64,1106,0,835,1002,64,2,64,109,-24,1202,9,1,63,1008,63,25,63,1005,63,859,1001,64,1,64,1106,0,861,4,841,1002,64,2,64,109,19,1205,9,875,4,867,1106,0,879,1001,64,1,64,1002,64,2,64,109,-3,1208,-1,32,63,1005,63,897,4,885,1106,0,901,1001,64,1,64,4,64,99,21102,27,1,1,21101,915,0,0,1105,1,922,21201,1,60043,1,204,1,99,109,3,1207,-2,3,63,1005,63,964,21201,-2,-1,1,21102,1,942,0,1106,0,922,21202,1,1,-1,21201,-2,-3,1,21101,957,0,0,1106,0,922,22201,1,-1,-2,1105,1,968,22102,1,-2,-2,109,-3,2105,1,0};
        this.code = new BigInteger[code.length + 1000];
        Arrays.fill(this.code, BigInteger.valueOf(0));
        for(int i = 0; i < code.length; i++){
            this.code[i] = BigInteger.valueOf(code[i]);
        }
    }

    public static void main(String[] args) {
        DayNine program = new DayNine(2);
        System.out.println(program.run());
    }

    BigInteger run() {
        running = true;
        while( pointer < code.length && running && !ended) {
            readOpcode();
        }
        return output;
    }

    void readOpcode() {
        updateOpcode();
        switch (currentOpcode[0]) {
            case 1 -> addNumbers();
            case 2 -> multiply();
            case 3 -> readInput();
            case 4 -> writeOutput();
            case 5 -> jumpIfTrue();
            case 6 -> jumpIfFalse();
            case 7 -> lessThan();
            case 8 -> ifEquals();
            case 9 -> adjustRelativeBase();

            case 99 -> {
                endProgram();
                running = false;
            }
            default -> {
                long invalidOpcode = currentOpcode[0];
                System.out.println("Invalid opcode: " + invalidOpcode);
                running = false;
            }
        }
    }

    void addNumbers() {
        modify(BigInteger::add);
    }

    void multiply() {
        modify(BigInteger::multiply);
    }

    void modify(BinaryOperator<BigInteger> operator){
        BigInteger valueOne = getParameterValue(1);
        BigInteger valueTwo = getParameterValue(2);
        BigInteger newValue = operator.apply(valueOne, valueTwo);

        int targetPosition = getWriteIndex(3);
        code[targetPosition] = newValue;
        pointer += 4;
    }

    void readInput() {
        int input = inputList.remove(0);
        int targetPosition = getWriteIndex(1);
        code[targetPosition] = BigInteger.valueOf(input);
        pointer += 2;
    }

    void writeOutput() {
        BigInteger output = getParameterValue(1);
        System.out.println("Output is: " + output);
        pointer += 2;
    }

    void jumpIfTrue() {
        jump((value) -> value.compareTo(BigInteger.ZERO) != 0);
    }

    void jumpIfFalse() {
        jump((value) -> value.compareTo(BigInteger.ZERO) == 0);
    }

    void jump(Predicate<BigInteger> predicate) {
        BigInteger valueOne = getParameterValue(1);
        BigInteger valueTwo = getParameterValue(2);
        if (predicate.test(valueOne)) {
            pointer = valueTwo.intValue();
        } else {
            pointer += 3;
        }
    }

    void lessThan() {
        write((valueOne, valueTwo) -> valueOne.compareTo(valueTwo) < 0);
    }

    void ifEquals() {
        write(BigInteger::equals);
    }

    void write(BiPredicate<BigInteger, BigInteger> predicate) {
        BigInteger valueOne = getParameterValue(1);
        BigInteger valueTwo = getParameterValue(2);

        int targetPosition = getWriteIndex(3);
        if (predicate.test(valueOne, valueTwo)) {
            code[targetPosition] = BigInteger.valueOf(1);
        } else {
            code[targetPosition] = BigInteger.valueOf(0);
        }
        pointer += 4;
    }

    void adjustRelativeBase(){
        relativePointer += getParameterValue(1).intValue();
        pointer += 2;
    }

    void endProgram() {
        output = code[0];
        ended = true;
    }

    void updateOpcode() {
        int rawOpcode = code[pointer].intValue();
        int[] command = new int[4];
        command[0] = rawOpcode % 100;
        rawOpcode /= 100;

        for(int i = 1; i < 4; ++i) {
            command[i] = rawOpcode % 10;
            rawOpcode /= 10;
        }

        this.currentOpcode = command;
    }

    BigInteger getParameterValue(int argumentIndex) {
        return switch(currentOpcode[argumentIndex]){
            case 1 -> code[pointer + argumentIndex];
            case 2 -> code[(relativePointer + code[pointer + argumentIndex].intValue())];
            default -> code[code[pointer + argumentIndex].intValue()];
        };
    }

    int getWriteIndex(int argumentIndex){
        if(currentOpcode[argumentIndex] == 2){
            return relativePointer + code[pointer + argumentIndex].intValue();
        } else {
            return code[pointer + argumentIndex].intValue();
        }
    }

    boolean hasEnded(){
        return ended;
    }

    BigInteger runInput(int input){
        inputList.add(input);
        return run();
        //Output opcode has to break the for loop for this to work.
    }
}
