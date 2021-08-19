package Services.SchedulerService;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzScheduler {

    Scheduler scheduler;
    String CRON_EXPRESSION = "0 0 4 ? * 5"; // La dejo hardcodeada como todos los jueves 4 am

    public void setCRON_EXPRESSION(String nuevaCron){
        this.CRON_EXPRESSION = nuevaCron;
    }

    public void ejecutar() throws Exception {
        scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        Trigger triggerNew = createCronTrigger();
        scheduleJob(triggerNew);
    }

    // Metodo para decirle que trabajo queremos que haga cuando se ejecute el scheduler
    private void scheduleJob(Trigger triggerNew) throws Exception {
        JobDetail jobInstance = JobBuilder.newJob(JobPlanificacionSemanal.class).build();
        scheduler.scheduleJob(jobInstance, triggerNew);

    }

    // Metodo que crea el "disparador" del scheduler segun una cronología.
    private Trigger createCronTrigger() {
        return TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(CRON_EXPRESSION)).build();
    }

}
