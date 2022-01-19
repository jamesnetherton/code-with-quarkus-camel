package t.lux.quarkus.azure;

import io.quarkus.runtime.StartupEvent;
import org.apache.camel.CamelContext;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class MyReactiveMessagingApplication {

    @Inject
    private CamelContext camelContext;
//
//    @Inject
//    @Channel("source-out")
//    Emitter<String> emitter;

    /** Sends message to the source channel, can be used from a JAX-RS resource or any bean of your application **/
    void onStart(@Observes StartupEvent ev) {
        camelContext.start();
    }

    @Incoming("manifest-request-upc")
    public CompletionStage<Void> consume(Message<String> message) {
        System.out.println(message);
        return message.ack();
    }

}
