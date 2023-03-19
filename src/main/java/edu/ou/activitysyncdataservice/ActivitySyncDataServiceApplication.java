package edu.ou.activitysyncdataservice;

import edu.ou.coreservice.annotation.BaseSyncDataAnnotation;
import org.springframework.boot.SpringApplication;

@BaseSyncDataAnnotation
public class ActivitySyncDataServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivitySyncDataServiceApplication.class, args);
    }

}
