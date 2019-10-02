package in.ashwanik.pdp.state;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

class Closed extends WorkflowState {
    private static Closed instance = new Closed();
    private static Set<WorkflowState> allowedFrom;
    private static Set<WorkflowState> allowedTo;

    static {
        allowedFrom = new HashSet<>();
        allowedTo = new HashSet<>();
        allowedFrom.add(Started.state());
        allowedFrom.add(InDraft.state());
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
