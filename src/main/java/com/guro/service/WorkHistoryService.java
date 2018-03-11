package com.guro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.guro.domain.Jobs;
import com.guro.domain.WorkHistory;

@Service
public class WorkHistoryService {

	static WorkHistory workHistoryDetails =new WorkHistory();
	static{
		List<String> workDones = new ArrayList<>();
		workDones.add("angular");
		workDones.add("description");
		List<String> workDones1 = new ArrayList<>();
		workDones1.add("java,c++");
		workDones1.add("description also");
		
		Jobs job1 = new Jobs("Twitter", "USA",workDones); 
		Jobs job2 = new Jobs("Microsoft", "USA",workDones1);
		List<Jobs> jobList = new ArrayList<>();
		jobList.add(job1);
		jobList.add(job2);
		workHistoryDetails.setJobs(jobList);
	}
	public WorkHistory getAllHistoryDetail(){
		
		return workHistoryDetails;
	}
	public void setJobs(WorkHistory workHistory){
		workHistoryDetails.getJobs().clear();
		List<Jobs> jobs = workHistory.getJobs();
		for (Jobs job : jobs) {
			workHistoryDetails.getJobs().add(job);
	    }
	}
}
