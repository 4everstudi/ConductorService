package de.thkoeln.f10.msc.sin.conductor.sagas;

public class NoteRequest {
    private String requestId;
    private Originator originator;
    private Note note;
    private Integer sequenceNumber;

    public String getRequestId() {
        return requestId;
    }

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}
