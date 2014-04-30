package eu.aniketos.data.impl;

import eu.aniketos.data.IContractStatus;

/**
 * This is a wrapper class, that wraps the result of each process of contract analysis.
 * It is returned by the Contract Manager Service as the output of the AnalyseSecureComposition method.
 * @author Luca Wiegand
 *
 */
public class ContractStatus implements IContractStatus{
	
	/**
	 * The array of result in which each result is stored.
	 */
	private Result[] results;

	/**
	 * ContractStatusImpl constructor, creates it from an array of Result objects.
	 * @param res: the array of results that the class has to wrap.
	 */
	public ContractStatus(Result[] res){
		results = res;
	}	
	
	/**
	 * get the result of the trust check process from Trustworthinness manager.
	 * @return: the TM result.
	 */
	public Result getTrustResult(){
		return results[0];
	}
	/**
	 * get the result of the SPDM.
	 * @return: the SPDM result.
	 */
	public Result getSPDMStatus(){
		return results[1];
	}

	/**
	 * get the result of the matching process.
	 * @return: the matching result.
	 */
	public Result getMatchingResult(){
		return results[2];
	}
}
