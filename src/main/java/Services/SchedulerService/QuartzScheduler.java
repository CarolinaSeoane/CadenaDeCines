package Services.SchedulerService;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzScheduler {

    final String NAME_OF_JOB = "Planificador de Películas";
    final String NAME_OF_GROUP = "Grupo Planificación";
    final String NAME_OF_TRIGGER = "Comenzar Planificación";

    //create variable scheduler of type Scheduler
    Scheduler scheduler;

    // Expresion que indica cuando se ejecuta el scheduler.
    // La dejo hardcodeada como todos los jueves 4 am
    String CRON_EXPRESSION = "0 0 4 ? * 5";

    public void setCRON_EXPRESSION(String nuevaCron){
        this.CRON_EXPRESSION = nuevaCron;
    }

    public void ejecutar() throws Exception {

        //show message to know about the main thread
        //System.out.println(" The name of the QuartzScheduler main thread is: " + Thread.currentThread().getName());

        //initialize scheduler instance from Quartz
        scheduler = new StdSchedulerFactory().getScheduler();

        //start scheduler
        scheduler.start();

        //create scheduler trigger with a cron expression
        Trigger triggerNew = createCronTrigger();

        //schedule trigger
        scheduleJob(triggerNew);


    }

    //create scheduleJob() method to schedule a job
    private void scheduleJob(Trigger triggerNew) throws Exception {

        //create an instance of the JoDetails to connect Quartz job to the CreateQuartzJob
        JobDetail jobInstance = JobBuilder.newJob(CreateQuartzJob.class).withIdentity(NAME_OF_JOB, NAME_OF_GROUP).build();

        //invoke scheduleJob method to connect the Quartz scheduler to the jobInstance and the triggerNew
        scheduler.scheduleJob(jobInstance, triggerNew);

    }

    //create createTrigger() method that returns a trigger based on the time interval
    private Trigger createCronTrigger() {


        //create a trigger to be returned from the method
        Trigger triggerNew = TriggerBuilder.newTrigger().withIdentity(NAME_OF_TRIGGER, NAME_OF_GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule(CRON_EXPRESSION)).build();

        //return triggerNew to schedule it in main() method
        return triggerNew;
    }

}
