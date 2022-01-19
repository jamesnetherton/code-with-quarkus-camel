package t.lux.quarkus.azure;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class CamelContextProducer {

    @ApplicationScoped
    @Produces
    public CamelContext getInstance() {
        return new DefaultCamelContext();
    }
}
