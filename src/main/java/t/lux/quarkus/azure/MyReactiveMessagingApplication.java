package t.lux.quarkus.azure;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class MyReactiveMessagingApplication {

    @Incoming("source-in")
    public CompletionStage<Void> consume(Message<String> message) {
        System.out.println(message);
        return message.ack();
    }

}
