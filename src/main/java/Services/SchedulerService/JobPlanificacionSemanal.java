package Services.SchedulerService;

import Business.PlanificationStrategy.Planificador;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class JobPlanificacionSemanal implements Job {

    public void execute(JobExecutionContext jExeCtx) {
        Planificador planificador = Planificador.getInstance();
        planificador.planificar();
    }

}
