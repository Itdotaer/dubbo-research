package com.itdotaer.basiclearn.collections;


import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.Event;
import com.sun.jdi.request.EventRequest;

/**
 * TimeEscapeTest
 *
 * @author jt_hu
 * @date 2018/11/21
 */
public class TimeEscapeTest {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        TimeEscape timeEscape = new TimeEscape(eventSource);
    }

}

class TimeEscape {

    public TimeEscape(EventSource source) {
        source.registerListener(e -> doSomething(e));
    }

    public void doSomething(Event event) {
        System.out.println("do something");
    }

}

class EventSource {

    void registerListener(EventListener eventListener) {
        System.out.println("registerListener");

        eventListener.onEvent(new Event() {
            @Override
            public EventRequest request() {
                return null;
            }

            @Override
            public VirtualMachine virtualMachine() {
                return null;
            }
        });
    }

}

interface EventListener {

    void onEvent(Event e);

}
