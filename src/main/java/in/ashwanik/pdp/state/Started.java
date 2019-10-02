package in.ashwanik.pdp.state;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

class Started extends WorkflowState {
    private static Started instance = new Started();

    private static Set<WorkflowState> allowedFrom;
    private static Set<WorkflowState> allowedTo;

    static {
        allowedFrom = new HashSet<>();
        allowedTo = new HashSet<>();
        allowedTo.add(InDraft.state());
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
        workflowContext.setCreatedAt(LocalDateTime.now());
    }
}
