package com.company;

public class MessageWriter implements Runnable {

    private Message message;

    public MessageWriter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String messages[] = {
            "Greenfrog", "is", "very", "good", "frog"
        };

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message.write("Ended");
    }
}
