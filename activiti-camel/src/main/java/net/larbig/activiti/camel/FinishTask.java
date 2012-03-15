package net.larbig.activiti.camel;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class FinishTask implements JavaDelegate {
	

	@Override
	public void execute(DelegateExecution paramDelegateExecution)
			throws Exception {
		System.out.println("############## FINISH ####################### ");

	}

}
