package org.talend.daikon.content;

import java.util.function.Predicate;

public class IONotifications {

    private final Predicate<DeletableResource> predicate;

    public IONotifications(Predicate<DeletableResource> predicate) {
        this.predicate = predicate;
    }

    public void notifyDelete(DeletableResource resource, long removed) {
        if (predicate.test(resource)) {
            // Update quota
        }
    }

    public void notifyAdd(DeletableResource resource, long added) {
        if (predicate.test(resource)) {
            // Update quota
        }
    }

    public interface IONotificationFilter extends Predicate<DeletableResource> {
    }
}
