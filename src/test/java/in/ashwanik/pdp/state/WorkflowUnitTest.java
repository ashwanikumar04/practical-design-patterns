package in.ashwanik.pdp.state;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WorkflowUnitTest {
    @Test
    public void testWorkflow() {
        WorkflowContext workflowContext = new WorkflowContext();
        assertThat(workflowContext.getCreatedAt()).isNotNull();
        assertThatThrownBy(() -> workflowContext.changeState(Approved.state())).isInstanceOf(IllegalStateException.class);
        workflowContext.changeState(InDraft.state());
        workflowContext.changeState(Approved.state());
    }
}
