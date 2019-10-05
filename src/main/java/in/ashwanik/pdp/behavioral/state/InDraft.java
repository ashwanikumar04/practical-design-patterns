package in.ashwanik.pdp.behavioral.state;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

class InDraft extends WorkflowState {
    private static InDraft instance = new InDraft();
    private static Set<WorkflowState> allowedFrom;
    private static Set<WorkflowState> allowedTo;

    static {
        allowedFrom = new HashSet<>();
        allowedTo = new HashSet<>();
        allowedFrom.add(Started.state());
        allowedTo.add(Approved.state());
        allowedTo.add(Closed.state());
    }

    static WorkflowState state() {
        return instance;
    }

    @Override
    Set<WorkflowState> getAllowedFromState() {
        return allowedFrom;
    }

    @Override
    Set<WorkflowState> getAllowedToState() {
        return allowedTo;
    }

    @Override
    void update(WorkflowContext workflowContext) {
        workflowContext.setLastModifiedAt(LocalDateTime.now());
    }
}
