package cn.elvea.samples.webflux;

import cn.elvea.samples.webflux.config.Config;
import org.springframework.web.server.adapter.AbstractReactiveWebInitializer;

public class Initializer extends AbstractReactiveWebInitializer {

    @Override
    protected Class<?>[] getConfigClasses() {
        return new Class[]{Config.class};
    }

}
