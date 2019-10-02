package in.ashwanik.pdp.state;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

class Approved extends WorkflowState {
    private static Approved instance = new Approved();
    private static Set<WorkflowState> allowedFrom;
    private static Set<WorkflowState> allowedTo;

    static {
        allowedFrom = new HashSet<>();
        allowedTo = new HashSet<>();
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
