package cn.elvea.jakarta.mvc;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Config
 *
 * @author elvea
 */
@ApplicationPath("mvc")
public class Config extends Application {
    public Config() {
        System.out.println("Config...");
    }
}
