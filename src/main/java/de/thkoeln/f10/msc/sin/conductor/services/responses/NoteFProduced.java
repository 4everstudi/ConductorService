package de.thkoeln.f10.msc.sin.conductor.services.responses;

import de.thkoeln.f10.msc.sin.conductor.sagas.Note;

public class NoteFProduced extends NoteProduced {
    public final Note note = Note.F;

    @Override
    public Note note() {
        return note;
    }
}
