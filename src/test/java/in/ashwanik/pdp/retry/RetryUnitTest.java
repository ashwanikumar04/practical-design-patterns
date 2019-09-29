package in.ashwanik.pdp.retry;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RetryUnitTest {
    @Test
    public void givenRetryParamWhenRunJobWithErrorThenRetryOccurs() {
        RetryCommand<String> retryCommand = new RetryCommand<>(RetryParam.builder().retryCount(1).build());
        TestClass testClass = mock(TestClass.class);
        when(testClass.getData())
                .thenThrow(new RuntimeException("Exception"))
                .thenReturn("test");
        String returnData = retryCommand.run(testClass::getData);
        assertThat(returnData).isEqualTo("test");
    }

    private static class TestClass {
        String getData() {
            return null;
        }
    }

}
