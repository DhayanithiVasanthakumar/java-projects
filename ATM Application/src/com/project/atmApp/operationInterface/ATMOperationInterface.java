package com.project.atmApp.operationInterface;

import com.project.atmApp.atm.ATM;

public interface ATMOperationInterface {

	public boolean viewBalance();

	public void withDrawAmount(double withDrawAmount);

	public void depositAmount(double depositAmount);

	public void viewMiniStatement();
	
	
	
	
	
	
	

	public boolean insertCustomerID(int addCusID);

	public boolean deleteCustomerID(int delCusID);

}