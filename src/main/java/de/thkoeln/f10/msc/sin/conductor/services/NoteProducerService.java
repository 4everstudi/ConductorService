package de.thkoeln.f10.msc.sin.conductor.services;

import de.thkoeln.f10.msc.sin.conductor.sagas.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoteProducerService {

    @Autowired
    public NoteProducerService() {

    }

    public String requestNote(Note note){
        return "";
    }
}
