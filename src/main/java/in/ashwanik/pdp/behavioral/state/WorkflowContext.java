package in.ashwanik.pdp.behavioral.state;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
class WorkflowContext {
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private WorkflowState currentState;

    WorkflowContext() {
        currentState = Started.state();
        currentState.update(this);
    }

    void changeState(WorkflowState newState) {
        if (newState.canTransitionFrom(currentState)) {
            currentState = newState;
        } else {
            throw new IllegalStateException("this transition is not allowed");
        }
    }

    void update() {
        this.currentState.update(this);
    }
}
