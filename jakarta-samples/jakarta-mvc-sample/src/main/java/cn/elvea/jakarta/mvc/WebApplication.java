package cn.elvea.jakarta.mvc;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * WebApplication
 *
 * @author elvea
 */
@ApplicationPath("mvc")
public class WebApplication extends Application {
    public WebApplication() {
        System.out.println("Config...");
    }
}
