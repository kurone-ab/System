package os;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader {

	public Process load(String fileName) {
		/*내가 만든거는 컴파일러..
		* 스테이터스 레지스터-사인플래그, 제로플래그
		* 마스킹-다른 비트를 0으로 세팅, 알고싶은 비트를 1으로 세팅 후 앤드계산 결과가 1이면 알고싶은 비트는 1, 아니면 0
		* 대소비교보다 이퀄이 시간을 덜 잡아먹는다. -테스트 결과
		* 산술연산, 관계연산, 논리연산
		* 관계연산-대소비교, 논리연산-앤드, 오어, 낫, 익스클루시브 오어
		* 인위적으로 인테져도 참, 거짓으로 만들 수 있다. 0은 거짓 0이 아닌 나머지는 참
		* os랑 연결
		* 베이직 인풋 아웃풋 디바이스
		*/

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