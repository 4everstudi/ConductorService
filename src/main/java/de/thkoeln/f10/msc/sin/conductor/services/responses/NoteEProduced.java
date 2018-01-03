package de.thkoeln.f10.msc.sin.conductor.services.responses;

import de.thkoeln.f10.msc.sin.conductor.sagas.Note;

public class NoteEProduced extends NoteProduced {
    public final Note note = Note.E;

    @Override
    public Note note() {
        return note;
    }
}
