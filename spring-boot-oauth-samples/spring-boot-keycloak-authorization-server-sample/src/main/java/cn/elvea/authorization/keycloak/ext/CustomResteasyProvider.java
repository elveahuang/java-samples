package cn.elvea.authorization.keycloak.ext;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.keycloak.common.util.ResteasyProvider;

/**
 * CustomResteasyProvider
 *
 * @author elvea
 */
public class CustomResteasyProvider implements ResteasyProvider {

    @Override
    public <R> R getContextData(Class<R> type) {
        ResteasyProviderFactory.getInstance();
        return ResteasyProviderFactory.getContextData(type);
    }

    @Override
    public void pushDefaultContextObject(Class type, Object instance) {
        ResteasyProviderFactory.getInstance();
        ResteasyProviderFactory.getContextData(Dispatcher.class).getDefaultContextObjects().put(type, instance);
    }

    @Override
    public void pushContext(Class type, Object instance) {
        ResteasyProviderFactory.getInstance();
        ResteasyProviderFactory.pushContext(type, instance);
    }

    @Override
    public void clearContextData() {
        ResteasyProviderFactory.getInstance();
        ResteasyProviderFactory.clearContextData();
    }

}