package os;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Loader {

    public Process load(String fileName) {
        try {
            int stackSegmentSize = 0;
            int[] codes = null;
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!(line.isBlank()))
                    if (line.substring(0,2).equals("//")){}
                    else if (line.equals(".stack")) {
                        stackSegmentSize = this.parseStack(scanner);
                        System.out.println("stack segment size: " + stackSegmentSize);
                    } else if (line.equals(".code")) {
                        codes = this.parseCode(scanner);
                    }
            }
            Process process = new Process(stackSegmentSize, codes);
            scanner.close();
            return process;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int parseStack(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine().split(" ")[2]);
    }

    private int[] parseCode(Scanner scanner) {
        Vector<Integer> temp = new Vector<>();
        int count = 0;
        while (scanner.hasNextLine()) {
            String string = scanner.next();
            if (string.substring(0, 2).equals("//")) {
                scanner.nextLine();
                continue;
            }
            int instruction = Instruction.valueOf(string).ordinal();
            int value;
            try {
                value = scanner.nextInt();
            } catch (Exception e) {
                value = 0;
            }
            temp.add((instruction << 16) + value);
            System.out.println(count + "line instruction is " + string + " and value is " + value);
            count++;
        }
        int[] re = new int[temp.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = temp.get(i);
        }
        return re;
    }

    private enum Instruction {
        ldi, sta, addi, cmp, igz, halt
    }
}