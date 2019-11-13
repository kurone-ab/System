package os;

public class OperatingSystem {
	private UXManager uxManager;
	private Loader loader;//프로세스매니저나 ux매니저로 들어가도 상관없음.
	/*io매니저는 간단한 경우 하나만 있을 수도 여러 개 있을 수도 있다.
	메모리 컨트롤러, 디바이스 컨트롤러-작은 cpu
	디바이스 인터럽트 발생은 독립적인 링크를 통해 스테이터스 레지스터에 전달한다.
	time expired, io start, io finish, halt
	소프트웨어 인터럽트, 하드웨어 인터럽트
	cisc, risc
	조각모음-compaction
	*/

	private FileManager fileManager;
	private MemoryManager memoryManager;
	private ProcessManager processManager;

	public OperatingSystem() {
		this.uxManager = new UXManager();
		this.loader = new Loader();
		this.fileManager = new FileManager();
		this.memoryManager = new MemoryManager();
		this.processManager = new ProcessManager();
	}
	
	public void associate() {
		this.uxManager.associate(this.loader, this.processManager);
		this.processManager.associate(this.memoryManager, this.fileManager);
	}
	
	public void run() {
		this.uxManager.run();
	}
}
