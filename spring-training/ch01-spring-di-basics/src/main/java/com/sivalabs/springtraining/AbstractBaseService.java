/**
 * 
 */
package com.sivalabs.springtraining;

/**
 * @author Siva
 *
 */
public abstract class AbstractBaseService {

	private CommonDAO commonDAO;
	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
	public CommonDAO getCommonDAO() {
		return commonDAO;
	}
}
