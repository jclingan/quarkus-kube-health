package org.acme;

import java.io.File;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
public class FileHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        String filename = "/tmp/error";

        File file = new File(filename);

        return HealthCheckResponse
            .named("FileHealthCheck")
            .state(! file.exists())
            .withData("filename", filename)
            .build();
    }

    
    
}