package eu.aniketos.data.impl;

/**
 * This class represents a result of any status that the ContractManager module returns.
 * Each Result is composed by a return code(representing the outcome of the process)
 * and an explanation of the result.
 * @author Luca Wiegand
 * @version 12/07/2013 Bo Zhou
 */
public class Result {

	/**
	 * the code representing the process outcome.
	 */
	private int errorCode;
	/**
	 * a human readable explanation of the result.
	 */
	private String explanation;
	/**
	 * Create a Result object with given code and explanation.
	 * @param code: the code of the result.
	 * @param expl: the explanation of the result.
	 */
	public Result(int code, String expl){
		errorCode = code;
		explanation = expl;
	}
	
	public int getErrorCode (){
		return errorCode;
	}
	
	public String getExplanation (){
		return explanation;
	}
	
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
