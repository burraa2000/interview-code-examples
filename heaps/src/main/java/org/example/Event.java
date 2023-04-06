package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Event {
    int startTime;
    int endTime;

    public Event(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static int getMaxSimultaneousEvents(List<Event> events) {
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        int currentIndex = 0, maxSimultaneousEvents = 0, currentEvents = 0;
        while (currentIndex < events.size()) {
            if (endTimes.isEmpty() || events.get(currentIndex).startTime <= endTimes.peek()) {
                endTimes.offer(events.get(currentIndex).endTime);
                currentEvents++;
                maxSimultaneousEvents = Math.max(maxSimultaneousEvents, currentEvents);
                currentIndex++;
            } else {
                endTimes.remove();
                currentEvents--;
            }
        }
        return maxSimultaneousEvents;
    }


    public static void main(String[] args) {
        List<Event> allEvents = new ArrayList<>();
        allEvents.add(new Event(0, 5));
        allEvents.add(new Event(6, 15));
        allEvents.add(new Event(6, 7));
        allEvents.add(new Event(3, 4));
        allEvents.sort(Comparator.comparing(e->e.startTime));
        System.out.println(getMaxSimultaneousEvents(allEvents));

    }

}

