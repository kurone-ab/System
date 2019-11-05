package os;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader {

	public Process load(String fileName) {
		try {
			int stackSegmentSize = 0;
			int[] codes = null;
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line.substring(0, 4).equals(".code")) {
					codes = this.parseCode(scanner);
				}else if(line.substring(0, 4).equals(".stack")) {
					stackSegmentSize = this.parseStack(scanner);
				}else if(line.substring(0, 1).equals("//")) {
					
				}else if(line.isEmpty()) {
					
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
		return 0;
	}

	private int[] parseCode(Scanner scanner) {
		return null;
	}
}