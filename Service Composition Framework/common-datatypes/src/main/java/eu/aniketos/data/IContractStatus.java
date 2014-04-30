package eu.aniketos.data;

import eu.aniketos.data.impl.Result;

/**
 * This is a wrapper interface, that wraps the result of each process of contract analysis.
 * It is returned by the Contract Manager Service as the output of the AnalyseSecureComposition method.
 * @author Luca Wiegand
 *
 */
public interface IContractStatus {

	
	/**
	 * get the result of the trust check process from Trustworthinness manager.
	 * @return: the TM result.
	 */
	public Result getTrustResult();

	/**
	 * get the result of the threat check process.
	 * @return: the threat check result.
	 */
	public Result getSPDMStatus();

	/**
	 * get the result of the matching process.
	 * @return: the matching result.
	 */
	public Result getMatchingResult();
}
