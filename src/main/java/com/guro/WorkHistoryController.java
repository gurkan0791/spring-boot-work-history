package com.guro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.guro.domain.Jobs;
import com.guro.domain.WorkHistory;
import com.guro.service.WorkHistoryService;

@Controller
public class WorkHistoryController {

	@Autowired
	WorkHistoryService workHistory;
	
	@ModelAttribute("workHistoryDetails")
	public WorkHistory populateSeedStarters() {
	    return this.workHistory.getAllHistoryDetail();
	}
	
    @GetMapping("/work-list")
    public String greeting(final WorkHistory workHistoryDetails) {
        return "work-list";
    }
    
    @RequestMapping(value="/work-list",method=RequestMethod.POST)
    public String create(final WorkHistory workHistoryDetails) {
      //list work senteces in console
      List<Jobs> list = workHistoryDetails.getJobs();	
       for (Jobs job : list) {
		 for (String work : job.getWorkDoneSentences()) {
			System.out.print(work+" ");
		}
		 System.out.println();
       }
       //save it to database
       this.workHistory.setJobs(workHistoryDetails);
       
       return "redirect:work-list";
    }
    
    @RequestMapping(value="/work-list", params={"addRow"})
    public String addRow(final WorkHistory workHistoryDetails, Model model) {
       
    	Jobs jobRow = new Jobs("","",new ArrayList<>());
    	workHistoryDetails.getJobs().add(jobRow);
    	model.addAttribute("workHistoryDetails", workHistoryDetails);
        return "work-list";
    }
	
}