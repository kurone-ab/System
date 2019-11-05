package os;

public class OperatingSystem {
	private UXManager uxManager;
	private Loader loader;
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
