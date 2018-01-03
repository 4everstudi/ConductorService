package de.thkoeln.f10.msc.sin.conductor.sagas;

import com.codebullets.sagalib.Saga;
import com.codebullets.sagalib.processing.SagaProviderFactory;
import de.thkoeln.f10.msc.sin.conductor.sagas.StarWars.StarWarsSaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Provider;

@Component
public class MusicSagaProviderFactory implements SagaProviderFactory {
    private final StarWarsSaga sw;

    @Autowired
    public MusicSagaProviderFactory(final StarWarsSaga sw) {
        this.sw = sw;
    }

    @Override
    public Provider<? extends Saga> createProvider(final Class sagaClass) {
        if (sagaClass.equals(StarWarsSaga.class))
            return () -> sw;
        else
            return () -> sw;
    }
}
