package de.thkoeln.f10.msc.sin.conductor.sagas;

import com.codebullets.sagalib.AbstractSagaState;

public class NoteState extends AbstractSagaState<String> {
    private String noteRequestId;
    private Originator originator;

    public String getNoteRequestId() {
        return noteRequestId;
    }

    public void setNoteRequestId(final String requestId) {
        noteRequestId = requestId;
    }

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(final Originator originator) {
        this.originator = originator;
    }
}
