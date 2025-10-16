package heap.aa9b.two;

import java.util.ArrayList;
import java.util.List;

// Someone who says "Hello"
class Initiater
{
    private final List<HelloListener> listeners = new ArrayList<>();

    void addListener(HelloListener toAdd)
    {
        listeners.add(toAdd);
    }

    void sayHello()
    {
        System.out.println("Hello!!");

        // Notify everybody that may be interested.
        for (HelloListener hl : listeners)
        {
            hl.someoneSaidHello();
        }
    }
}