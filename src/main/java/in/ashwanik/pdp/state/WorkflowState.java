package in.ashwanik.pdp.state;

import java.util.Set;

abstract class WorkflowState {

    abstract Set<WorkflowState> getAllowedFromState();

    abstract Set<WorkflowState> getAllowedToState();

    boolean canTransitionFrom(WorkflowState updatedState) {
        return getAllowedFromState().contains(updatedState) && updatedState.getAllowedToState().contains(this);
    }

    abstract void update(WorkflowContext workflowContext);
}
