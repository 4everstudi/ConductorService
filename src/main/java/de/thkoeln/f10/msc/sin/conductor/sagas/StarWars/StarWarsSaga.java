package de.thkoeln.f10.msc.sin.conductor.sagas.StarWars;

import com.codebullets.sagalib.*;
import com.google.common.collect.Lists;
import de.thkoeln.f10.msc.sin.conductor.services.NoteProducerService;
import de.thkoeln.f10.msc.sin.conductor.services.responses.*;
import de.thkoeln.f10.msc.sin.conductor.sagas.NoteRequest;
import de.thkoeln.f10.msc.sin.conductor.sagas.NoteState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Service
public class StarWarsSaga extends AbstractSaga<NoteState> {
    private final NoteProducerService noteService;

    @Autowired
    public StarWarsSaga(final NoteProducerService noteService) {
        this.noteService = noteService;
    }

    @StartsSaga
    public void sagaStartup(NoteRequest noteRequest) {
        // perform saga start logic
        // save id to map further messages back to the specific saga state
        String noteServiceRequestId = noteService.requestNote(noteRequest.getNote());

        state().setNoteRequestId(noteRequest.getRequestId());
        state().setOriginator(noteRequest.getOriginator());
        state().addInstanceKey(noteServiceRequestId);
        requestTimeout(60, TimeUnit.SECONDS);
    }

    @EventHandler
    public void noteAProduced(NoteProduced productionResponse) {
        // perform custom logic and mark saga as finished
        setFinished();
    }

    @Override
    public void createNewState() {
        setState(new NoteState());
    }

    @Override
    public Collection<KeyReader> keyReaders() {
        // creates a reader used to map between the OtherMessage event
        // and the stored instance key of the existing saga state.
        Collection<KeyReader> readers = new ArrayList<>(1);
        readers.add(KeyReaders.forMessage(
                NoteAProduced.class,
                verifiedMessage -> verifiedMessage.getRequestId()));

        return Lists.newArrayList(readers);
    }
}
