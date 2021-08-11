package Services.SchedulerService;

import Business.PlanificationStrategy.Planificador;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

//create CreateQuartzJob class that implements Job
public class CreateQuartzJob implements Job {

    //execute Job by using execute() method of the Job interface
    public void execute(JobExecutionContext jExeCtx) {
        Planificador planificador = Planificador.getInstance();
        planificador.planificar();
    }

}
