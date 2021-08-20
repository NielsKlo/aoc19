//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class DayFive {
    int[] code = new int[]{3, 225, 1, 225, 6, 6, 1100, 1, 238, 225, 104, 0, 1102, 79, 14, 225, 1101, 17, 42, 225, 2, 74, 69, 224, 1001, 224, -5733, 224, 4, 224, 1002, 223, 8, 223, 101, 4, 224, 224, 1, 223, 224, 223, 1002, 191, 83, 224, 1001, 224, -2407, 224, 4, 224, 102, 8, 223, 223, 101, 2, 224, 224, 1, 223, 224, 223, 1101, 18, 64, 225, 1102, 63, 22, 225, 1101, 31, 91, 225, 1001, 65, 26, 224, 101, -44, 224, 224, 4, 224, 102, 8, 223, 223, 101, 3, 224, 224, 1, 224, 223, 223, 101, 78, 13, 224, 101, -157, 224, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 3, 224, 1, 224, 223, 223, 102, 87, 187, 224, 101, -4698, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 4, 224, 1, 223, 224, 223, 1102, 79, 85, 224, 101, -6715, 224, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 2, 224, 1, 224, 223, 223, 1101, 43, 46, 224, 101, -89, 224, 224, 4, 224, 1002, 223, 8, 223, 101, 1, 224, 224, 1, 223, 224, 223, 1101, 54, 12, 225, 1102, 29, 54, 225, 1, 17, 217, 224, 101, -37, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 3, 224, 1, 223, 224, 223, 1102, 20, 53, 225, 4, 223, 99, 0, 0, 0, 677, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1105, 0, 99999, 1105, 227, 247, 1105, 1, 99999, 1005, 227, 99999, 1005, 0, 256, 1105, 1, 99999, 1106, 227, 99999, 1106, 0, 265, 1105, 1, 99999, 1006, 0, 99999, 1006, 227, 274, 1105, 1, 99999, 1105, 1, 280, 1105, 1, 99999, 1, 225, 225, 225, 1101, 294, 0, 0, 105, 1, 0, 1105, 1, 99999, 1106, 0, 300, 1105, 1, 99999, 1, 225, 225, 225, 1101, 314, 0, 0, 106, 0, 0, 1105, 1, 99999, 107, 226, 226, 224, 1002, 223, 2, 223, 1006, 224, 329, 101, 1, 223, 223, 1108, 677, 226, 224, 1002, 223, 2, 223, 1006, 224, 344, 101, 1, 223, 223, 7, 677, 226, 224, 102, 2, 223, 223, 1006, 224, 359, 101, 1, 223, 223, 108, 226, 226, 224, 1002, 223, 2, 223, 1005, 224, 374, 101, 1, 223, 223, 8, 226, 677, 224, 1002, 223, 2, 223, 1006, 224, 389, 101, 1, 223, 223, 1108, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 404, 101, 1, 223, 223, 1007, 677, 677, 224, 1002, 223, 2, 223, 1006, 224, 419, 101, 1, 223, 223, 8, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 434, 1001, 223, 1, 223, 1008, 226, 226, 224, 102, 2, 223, 223, 1005, 224, 449, 1001, 223, 1, 223, 1008, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 464, 101, 1, 223, 223, 1107, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 479, 101, 1, 223, 223, 107, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 494, 1001, 223, 1, 223, 1107, 226, 677, 224, 1002, 223, 2, 223, 1005, 224, 509, 101, 1, 223, 223, 1108, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 524, 101, 1, 223, 223, 7, 226, 226, 224, 1002, 223, 2, 223, 1005, 224, 539, 101, 1, 223, 223, 108, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 554, 101, 1, 223, 223, 8, 677, 226, 224, 1002, 223, 2, 223, 1005, 224, 569, 1001, 223, 1, 223, 1008, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 584, 101, 1, 223, 223, 107, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 599, 1001, 223, 1, 223, 7, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 614, 101, 1, 223, 223, 1007, 226, 226, 224, 1002, 223, 2, 223, 1005, 224, 629, 101, 1, 223, 223, 1107, 677, 226, 224, 1002, 223, 2, 223, 1006, 224, 644, 101, 1, 223, 223, 108, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 659, 101, 1, 223, 223, 1007, 677, 226, 224, 102, 2, 223, 223, 1006, 224, 674, 101, 1, 223, 223, 4, 223, 99, 226};
    int pointer;
    int output;
    int[] opcode;

    public DayFive() {
    }

    public static void main(String[] args) {
        DayFive program = new DayFive();
        program.iterate();
    }

    void iterate() {
        while(this.pointer < this.code.length && this.readOpcode()) {
        }

    }

    boolean readOpcode() {
        this.setOpcode();
        switch(this.opcode[0]) {
            case 1:
                this.addNumbers();
                return true;
            case 2:
                this.multiply();
                return true;
            case 3:
                this.readInput();
                return true;
            case 4:
                this.writeOutput();
                return true;
            case 5:
                this.jumpIfTrue();
                return true;
            case 6:
                this.jumpIfFalse();
                return true;
            case 7:
                this.lessThan();
                return true;
            case 8:
                this.ifEquals();
                return true;
            case 99:
                this.endProgram();
                return false;
            default:
                int var10001 = this.code[this.pointer];
                System.out.println("Invalid opcode: " + var10001);
                return false;
        }
    }

    void addNumbers() {
        int valueOne = this.getParameterValue(1);
        int valueTwo = this.getParameterValue(2);
        int newValue = valueOne + valueTwo;
        this.code[this.code[this.pointer + 3]] = newValue;
        this.pointer += 4;
    }

    void multiply() {
        int valueOne = this.getParameterValue(1);
        int valueTwo = this.getParameterValue(2);
        int newValue = valueOne * valueTwo;
        this.code[this.code[this.pointer + 3]] = newValue;
        this.pointer += 4;
    }

    void readInput() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.println("Please give your integer input: ");
                String rawInput = reader.readLine();
                int input = Integer.parseInt(rawInput);
                this.code[this.code[this.pointer + 1]] = input;
            } catch (Throwable var5) {
                try {
                    reader.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            reader.close();
        } catch (Exception var6) {
            throw new RuntimeException("Invalid input. Integer needed.");
        }

        this.pointer += 2;
    }

    void writeOutput() {
        int output = this.getParameterValue(1);
        System.out.println("Output is: " + output);
        this.pointer += 2;
    }

    void jumpIfTrue() {
        this.jump((value) -> {
            return value != 0;
        });
    }

    void jumpIfFalse() {
        this.jump((value) -> {
            return value == 0;
        });
    }

    void jump(Predicate<Integer> predicate) {
        int valueOne = this.getParameterValue(1);
        int valueTwo = this.getParameterValue(2);
        if (predicate.test(valueOne)) {
            this.pointer = valueTwo;
        } else {
            this.pointer += 3;
        }

    }

    void lessThan() {
        this.write((valueOne, valueTwo) -> {
            return valueOne < valueTwo;
        });
    }

    void ifEquals() {
        this.write(Integer::equals);
    }

    void write(BiPredicate<Integer, Integer> predicate) {
        int valueOne = this.getParameterValue(1);
        int valueTwo = this.getParameterValue(2);
        if (predicate.test(valueOne, valueTwo)) {
            this.code[this.code[this.pointer + 3]] = 1;
        } else {
            this.code[this.code[this.pointer + 3]] = 0;
        }

        this.pointer += 4;
    }

    void endProgram() {
        this.output = this.code[0];
    }

    void setOpcode() {
        int rawOpcode = this.code[this.pointer];
        int[] command = new int[4];
        command[0] = rawOpcode % 100;
        rawOpcode /= 100;

        for(int i = 1; i < 4; ++i) {
            command[i] = rawOpcode % 10;
            rawOpcode /= 10;
        }

        this.opcode = command;
    }

    int getParameterValue(int argumentIndex) {
        return this.opcode[argumentIndex] == 1 ? this.code[this.pointer + argumentIndex] : this.code[this.code[this.pointer + argumentIndex]];
    }
}
