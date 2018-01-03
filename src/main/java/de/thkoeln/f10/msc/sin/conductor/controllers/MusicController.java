package de.thkoeln.f10.msc.sin.conductor.controllers;

import com.codebullets.sagalib.MessageStream;
import com.codebullets.sagalib.startup.EventStreamBuilder;
import de.thkoeln.f10.msc.sin.conductor.sagas.MusicSagaProviderFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class MusicController {
    private final MusicSagaProviderFactory factory;

    @Autowired
    public MusicController(MusicSagaProviderFactory factory) {
        this.factory = factory;
    }

    @RequestMapping("/")
    public String home() {
        MessageStream msgStream = EventStreamBuilder.configure()
                .usingSagaProviderFactory(factory)
                .build();
        return "Accepted";
    }
}
