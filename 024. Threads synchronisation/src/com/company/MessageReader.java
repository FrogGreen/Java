package com.company;

public class MessageReader implements Runnable {

    private Message message;

    public MessageReader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {

        for (String latestMessage = message.read(); !latestMessage.equals("Ended"); latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
