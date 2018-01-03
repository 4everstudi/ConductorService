package de.thkoeln.f10.msc.sin.conductor.sagas;

public enum Note {
    C(1, "C"),
    D(2, "D"),
    E(3, "E"),
    F(4, "F"),
    G(5, "G"),
    A(6, "A"),
    B(7, "B")
    ;

    private int code;
    private String name;

    private Note(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
