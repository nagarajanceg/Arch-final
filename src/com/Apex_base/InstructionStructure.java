package com.Apex_base;

import com.Apex_base.helpers.ApexSimulatorHelper;

public class InstructionStructure {
	private String src1;
	private String src2;
	private String dest;
	private String Stage;
	private int result;
	private int literal;
	private int inst_number;
	private String logicOpSign;
	private boolean currentValue;
	private String currentExecInst;
	public int decodedSrc1 = 0;
	public int decodedSrc2 = 0;
	public int decodedDest = 0;
	public int forwardSrc1 = 0;
	public int forwardSrc2 = 0;
	public boolean fwSrc1Status = false;
	public boolean fwSrc2Status = false;
	public boolean fwpswFlag = false;
	public int PswFlagValue = -1;
	
	public int getPswFlagValue() {
		return PswFlagValue;
	}

	public void setPswFlagValue(int pswFlagValue) {
		PswFlagValue = pswFlagValue;
	}

	public boolean isFwpswFlag() {
		return fwpswFlag;
	}

	public void setFwpswFlag(boolean fwpswFlag) {
		this.fwpswFlag = fwpswFlag;
	}

	public int getForwardSrc1() {
		return forwardSrc1;
	}

	public void setForwardSrc1(int forwardSrc1) {
		this.forwardSrc1 = forwardSrc1;
	}

	public int getForwardSrc2() {
		return forwardSrc2;
	}

	public void setForwardSrc2(int forwardSrc2) {
		this.forwardSrc2 = forwardSrc2;
	}
	
	public boolean isFwSrc1Status() {
		return fwSrc1Status;
	}

	public void setFwSrc1Status(boolean fwSrc1Status) {
		this.fwSrc1Status = fwSrc1Status;
	}

	public boolean isFwSrc2Status() {
		return fwSrc2Status;
	}

	public void setFwSrc2Status(boolean fwSrc2Status) {
		this.fwSrc2Status = fwSrc2Status;
	}

	public InstructionStructure(){
		this.currentExecInst = "";
	}

	public String getSrc1() {
		return src1;
	}

	public void setSrc1(String src1) {
		this.src1 = src1;
		//set src to the current execution if it's not branching instructions
		if(!logicOpSign.equals("BNZ") && !logicOpSign.equals("BZ")){
			this.currentExecInst += " "+this.src1; 
		}
	}

	public String getSrc2() {
		return src2;
	}

	public void setSrc2(String src2) {
		this.src2 = src2;
		this.currentExecInst += " "+ this.src2;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
		this.currentExecInst += " " + this.dest; 
	}

	public String getStage() {
		return Stage;
	}

	public void setStage(String stage) {
		Stage = stage;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getLiteral() {
		return literal;
	}

	public void setLiteral(int literal) {
		this.literal = literal;
		this.currentExecInst += " " + this.literal; 
	}

	public int getInst_number() {
		return inst_number;
	}

	public void setInst_number(int inst_number) {
		this.inst_number = inst_number;
		this.currentExecInst +=""+ this.inst_number+""+":";
	}
	public boolean is_mul(){
		return logicOpSign.equals("MUL");
	}
	public boolean is_div(){
		return logicOpSign.equals("DIV");
	}
	public boolean is_halt(){
		return logicOpSign.equals("HALT");
	}
	public String getLogicOpSign() {
		return logicOpSign;
	}
	public boolean is_arthimetic(){
		return logicOpSign.equals("ADD")|| logicOpSign.equals("MUL")||logicOpSign.equals("SUB")||logicOpSign.equals("DIV");
	}
	public void setLogicOpSign(String logicOpSign) {
		this.logicOpSign = logicOpSign;
		this.currentExecInst +=" " + this.logicOpSign;
	}

	public boolean isCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(boolean currentValue) {
		this.currentValue = currentValue;
	}
	public void decode_source1(){
		if(ApexSimulatorHelper.INSTANCE.getRegister(this.src1) != null){
			RegisterHandler source = ApexSimulatorHelper.INSTANCE.getRegister(this.src1);
			this.decodedSrc1 = source.getValue();
		}
	}
	public void decode_source2(){
		if(ApexSimulatorHelper.INSTANCE.getRegister(this.src2) != null){
			RegisterHandler source = ApexSimulatorHelper.INSTANCE.getRegister(this.src2);
			this.decodedSrc2 = source.getValue();
		}
	}
	public void decode_dest(){
		if(ApexSimulatorHelper.INSTANCE.getRegister(this.dest) != null){
			RegisterHandler source = ApexSimulatorHelper.INSTANCE.getRegister(this.dest);
			this.decodedDest = source.getValue();
		}
	}
	@Override
	public String toString(){
		return this.currentExecInst;
	}
}
