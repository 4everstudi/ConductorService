package de.thkoeln.f10.msc.sin.conductor.services.responses;

import de.thkoeln.f10.msc.sin.conductor.sagas.Note;

public abstract class NoteProduced {
    private String requestId;
    private Integer sequenceNumber;
    private String path;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public abstract Note note();

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
