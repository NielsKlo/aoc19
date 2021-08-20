//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class DayTwo {
    int[] code = new int[]{1, 12, 2, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 10, 19, 1, 19, 5, 23, 2, 23, 6, 27, 1, 27, 5, 31, 2, 6, 31, 35, 1, 5, 35, 39, 2, 39, 9, 43, 1, 43, 5, 47, 1, 10, 47, 51, 1, 51, 6, 55, 1, 55, 10, 59, 1, 59, 6, 63, 2, 13, 63, 67, 1, 9, 67, 71, 2, 6, 71, 75, 1, 5, 75, 79, 1, 9, 79, 83, 2, 6, 83, 87, 1, 5, 87, 91, 2, 6, 91, 95, 2, 95, 9, 99, 1, 99, 6, 103, 1, 103, 13, 107, 2, 13, 107, 111, 2, 111, 10, 115, 1, 115, 6, 119, 1, 6, 119, 123, 2, 6, 123, 127, 1, 127, 5, 131, 2, 131, 6, 135, 1, 135, 2, 139, 1, 139, 9, 0, 99, 2, 14, 0, 0};
    int output;

    public static void main(String[] args) {
        int[] inputs = findInputs();
        int answer = calculateAnswer(inputs);
        System.out.println(answer);
    }

    DayTwo(int noun, int verb) {
        this.code[1] = noun;
        this.code[2] = verb;
    }

    void iterate() {
        this.output = 0;
        for (int i = 0; i < this.code.length && this.readOpcode(i); i += 4) {
        }
    }

    boolean readOpcode(int i) {
        switch (this.code[i]) {
            case 1:
                this.addNumbers(i);
                return true;
            case 2:
                this.multiply(i);
                return true;
            case 99:
                this.endProgram();
                return false;
            default:
                int var10001 = this.code[i];
                System.out.println("Invalid opcode: " + var10001);
                return false;
        }
    }

    void addNumbers(int intCodeIndex) {
        int[] values = this.getValues(intCodeIndex);
        int newValue = values[0] + values[1];
        this.code[this.code[intCodeIndex + 3]] = newValue;
    }

    void multiply(int intCodeIndex) {
        int[] values = this.getValues(intCodeIndex);
        int newValue = values[0] * values[1];
        this.code[this.code[intCodeIndex + 3]] = newValue;
    }

    int[] getValues(int intCodeIndex) {
        int[] values = new int[]{this.code[this.code[intCodeIndex + 1]], this.code[this.code[intCodeIndex + 2]]};
        return values;
    }

    void endProgram() {
        this.output = this.code[0];
    }

    static int[] findInputs() {
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 100; ++j) {
                DayTwo program = new DayTwo(i, j);
                program.iterate();
                if (program.output == 19690720) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    static int calculateAnswer(int[] inputs) {
        return 100 * inputs[0] + inputs[1];
    }
}