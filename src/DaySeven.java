import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class DaySeven {
    int[] code = new int[]{3,8,1001,8,10,8,105,1,0,0,21,38,47,64,89,110,191,272,353,434,99999,3,9,101,4,9,9,102,3,9,9,101,5,9,9,4,9,99,3,9,1002,9,5,9,4,9,99,3,9,101,2,9,9,102,5,9,9,1001,9,5,9,4,9,99,3,9,1001,9,5,9,102,4,9,9,1001,9,5,9,1002,9,2,9,1001,9,3,9,4,9,99,3,9,102,2,9,9,101,4,9,9,1002,9,4,9,1001,9,4,9,4,9,99,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,99,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,99,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,99,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,99,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,99};
    boolean running = true;
    boolean ended = false;
    int pointer;
    int output;
    int[] currentOpcode;
    List<Integer> inputList = new ArrayList<>();

    public DaySeven(int phase, int thrustInput){
        inputList.add(phase);
        inputList.add(thrustInput);
    }

    public static void main(String[] args) {
        AmplifierConfigurator program = new AmplifierConfigurator();
        int biggestThrusterOutput = program.findThrusterOutput();
        System.out.println(biggestThrusterOutput);
    }

    int run() {
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
            case 4 -> {
                writeOutput();
                running = false;
            }
            case 5 -> jumpIfTrue();
            case 6 -> jumpIfFalse();
            case 7 -> lessThan();
            case 8 -> ifEquals();

            case 99 -> {
                endProgram();
                running = false;
            }
            default -> {
                int invalidOpcode = currentOpcode[0];
                System.out.println("Invalid opcode: " + invalidOpcode);
                running = false;
            }
        }
    }

    void addNumbers() {
        int valueOne = getParameterValue(1);
        int valueTwo = getParameterValue(2);
        int newValue = valueOne + valueTwo;
        code[code[pointer + 3]] = newValue;
        pointer += 4;
    }

    void multiply() {
        int valueOne = getParameterValue(1);
        int valueTwo = getParameterValue(2);
        int newValue = valueOne * valueTwo;
        code[code[pointer + 3]] = newValue;
        pointer += 4;
    }

    void readInput() {
        int input = inputList.remove(0);
        code[code[pointer + 1]] = input;

        pointer += 2;
    }

    void writeOutput() {
        output = getParameterValue(1);
        System.out.println("Output is: " + output);
        pointer += 2;
    }

    void jumpIfTrue() {
        jump((value) -> value != 0);
    }

    void jumpIfFalse() {
        this.jump((value) -> value == 0);
    }

    void jump(Predicate<Integer> predicate) {
        int valueOne = getParameterValue(1);
        int valueTwo = getParameterValue(2);
        if (predicate.test(valueOne)) {
            pointer = valueTwo;
        } else {
            pointer += 3;
        }

    }

    void lessThan() {
        this.write((valueOne, valueTwo) -> valueOne < valueTwo);
    }

    void ifEquals() {
        this.write(Integer::equals);
    }

    void write(BiPredicate<Integer, Integer> predicate) {
        int valueOne = getParameterValue(1);
        int valueTwo = getParameterValue(2);
        if (predicate.test(valueOne, valueTwo)) {
            code[code[pointer + 3]] = 1;
        } else {
            code[code[pointer + 3]] = 0;
        }

        pointer += 4;
    }

    void endProgram() {
        //output = code[0];
        ended = true;
    }

    void updateOpcode() {
        int rawOpcode = code[pointer];
        int[] command = new int[4];
        command[0] = rawOpcode % 100;
        rawOpcode /= 100;

        for(int i = 1; i < 4; ++i) {
            command[i] = rawOpcode % 10;
            rawOpcode /= 10;
        }

        this.currentOpcode = command;
    }

    int getParameterValue(int argumentIndex) {
        return currentOpcode[argumentIndex] == 1 ? code[pointer + argumentIndex] : code[code[pointer + argumentIndex]];
    }

    boolean hasEnded(){
        return ended;
    }

    int runInput(int input){
        inputList.add(input);
        return run();
    }
}

class AmplifierConfigurator{
    List<int[]> phaseConfigs = new ArrayList<>();
    List<Integer> thrusterOutputs = new ArrayList<>();

    int findThrusterOutput(){
        makePhaseConfigs();
        tryEveryPhaseConfig();
        return findBiggestThrusterOutput();
    }

    void makePhaseConfigs(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 2; l ++){
                        addConfig(new int[]{i, j, k, l, 0});
                    }
                }
            }
        }
    }

    void addConfig(int[] order){
        ArrayList<Integer> optionList = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9));
        int[] config = new int[5];
        for(int i = 0; i < 5; i++){
            config[i] = optionList.remove(order[i]);
        }
        phaseConfigs.add(config);
    }

    void tryEveryPhaseConfig(){
        for(int[] config : phaseConfigs){
            tryConfig(config);
        }
    }

    void tryConfig(int[] config){
        int output = 0;
        List<DaySeven> amplifierList = new ArrayList<>();
        DaySeven A = new DaySeven(config[0], 0); amplifierList.add(A);
        DaySeven B = new DaySeven(config[1], A.run()); amplifierList.add(B);
        DaySeven C = new DaySeven(config[2], B.run()); amplifierList.add(C);
        DaySeven D = new DaySeven(config[3], C.run()); amplifierList.add(D);
        DaySeven E = new DaySeven(config[4], D.run()); amplifierList.add(E);
        output = E.run();
        while(!E.hasEnded()){
            output = runLoop(output, amplifierList);
        }
        thrusterOutputs.add(output);
    }

    int runLoop(int input, List<DaySeven> amplifierList){
        int output = input;
        for(DaySeven amplifier : amplifierList){
            output = amplifier.runInput(output);
        }
        return output;
    }

    int findBiggestThrusterOutput(){
        Integer biggestOutput = 0;
        for(Integer output : thrusterOutputs){
            if(output > biggestOutput){
                biggestOutput = output;
            }
        }
        System.out.println(thrusterOutputs);
        return biggestOutput;
    }
}