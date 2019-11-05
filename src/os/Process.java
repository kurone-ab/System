package os;

import java.util.Vector;

public class Process {
	//global constants
	public enum EState {nnew, running, wait, ready, terminated};
	public enum ERegister {ePC, eCS, eDS, eSS, eHS, eMAR, eMBR, eIR, eStatus, eAC}
	public enum EInterrupt {eIO, eTerminate}
	
	//components
	private PCB pcb;
	private Segment codeSegment;
	private Segment stackSegment;
	
	//working variables
	private int timeSlice;
	
	public PCB getPcb() {return pcb;}
	public void setPcb(PCB pcb) {this.pcb = pcb;}
//	public Segment getCodeSegment() {return codeSegment;}
//	public void setCodeSegment(Segment codeSegment) {this.codeSegment = codeSegment;}
//	public Segment getStackSegment() {return stackSegment;}
//	public void setStackSegment(Segment stackSegment) {this.stackSegment = stackSegment;}
	
	public Process(int stackSegmentSize, int[] codes) {
		this.pcb = new PCB();
		this.codeSegment = new Segment(codes);
		this.stackSegment = new Segment(stackSegmentSize);
	}
	public void initialize(int timeSlice) {
		this.pcb.seteState(EState.running);
		this.timeSlice = timeSlice;
	}

	public EState executeALine() {
		int instruction = this.codeSegment.fetch(this.pcb.getRegisters().get(ERegister.ePC.ordinal()).get());
		////////////////////////////////////////////////
		//cpu execute
		////////////////////////////////////////////////
		
		if(this.pcb.getRegisters().get(ERegister.ePC.ordinal()).get() == EInterrupt.eIO.ordinal()) {
			return EState.wait;
		}else if(this.pcb.getRegisters().get(ERegister.ePC.ordinal()).get() == EInterrupt.eTerminate.ordinal()) {
			return EState.terminated;
		}else {
			this.timeSlice--;
			if(this.timeSlice == 0) {
				return EState.ready;
			}
		}
		return null;
	}
	
	////////////////////////////////////////////////////////////////////////
	private class PCB{
		private int id;
		private EState eState;
		private Vector<Register> registers;
		public PCB() {
			this.registers = new Vector<Register>();
			for(ERegister eRegister: ERegister.values()) {
				this.registers.add(new Register());
			}
		}
		public int getId() {return id;}
		public void setId(int id) {this.id = id;}
		public EState geteState() {return eState;}
		public void seteState(EState eState) {this.eState = eState;}
		public Vector<Register> getRegisters() {return registers;}
		public void setRegisters(Vector<Register> registers) {this.registers = registers;}
	}
	
	////////////////////////////////////////////////////////////////////////
	private class Segment{
		private int[] memory;
		public Segment(int size) {
			this.memory = new int[size];
		}
		public Segment(int[] memory) {
			this.memory = memory;
		}
		public void store(int address, int data) {
			this.memory[address] = data;
		}
		public int fetch(int address) {
			return this.memory[address];
		}
	}
	
	////////////////////////////////////////////////////////////////////////
	private class Register{
		private int value;
		public Register() {
		}
		public int get() {return value;}
		public void set(int value) {this.value = value;}
		
	}
}
