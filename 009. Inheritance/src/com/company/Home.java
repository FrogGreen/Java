package com.company;

public class Home {
    private int window;
    private int room;
    private int bathroom;
    private int bed;

    public Home(int window, int room, int bathroom, int bed) {
        this.window = window;
        this.room = room;
        this.bathroom = bathroom;
        this.bed = bed;
    }

    @Override
    public String toString() {
        return "Home{" +
            "window=" + window +
            ", room=" + room +
            ", bathroom=" + bathroom +
            ", bed=" + bed +
            '}';
    }

    public void myPlaceToLive() {
        System.out.println("I like my " + toString());
    }
}
