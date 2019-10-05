package in.ashwanik.pdp.others.retry;

import in.ashwanik.pdp.common.DesignPatternException;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * Uses {@link RetryParam} to retry a supplier in case of an exception
 *
 * @param <T> Data returned on the completion of the task
 */
@Slf4j
class RetryCommand<T> {
    private static final int DEFAULT_WAIT = 100;
    private RetryParam retryParam;
    private int retryCounter = 0;
    private long exponentialWaitTime;

    RetryCommand(final RetryParam retryParam) {
        this.retryParam = retryParam;
    }

    int getRetryCounter() {
        return retryCounter;
    }

    RetryParam getRetryParam() {
        return retryParam;
    }

    long getExponentialWaitTime() {
        return exponentialWaitTime;
    }

    /**
     * This runs a supplier and reties it depending upon the params {@link RetryParam}
     *
     * @param job Supplier
     * @return The output of the task
     */
    T run(final Supplier<T> job) {
        return run(job, null);
    }

    /**
     * This runs a supplier and reties it depending upon the params {@link RetryParam}
     *
     * @param job          Supplier
     * @param defaultValue Default value in case of an error after all the retries
     * @return The output of the task
     */
    T run(final Supplier<T> job,
          final T defaultValue) {
        try {
            return job.get();
        } catch (final Exception ex) {
            checkExceptionForRetrying(ex);
            return retry(job, defaultValue);
        }
    }


    private T retry(final Supplier<T> job,
                    final T defaultValue) {
        Exception exception = null;
        while (retryCounter < retryParam.getRetryCount()) {
            retryCounter++;
            try {
                log.info("retry {} / {}, {}", retryCounter, retryParam.getRetryCount(), retryParam.getMessage());
                return job.get();
            } catch (final Exception ex) {
                exception = ex;
                checkExceptionForRetrying(ex);
            }
        }
        if (defaultValue != null) {
            return defaultValue;
        }
        if (exception != null) {
            throw new DesignPatternException(exception);
        } else {
            return null;
        }
    }

    private void checkExceptionForRetrying(final Exception exception) {
        if (retryParam.getRetryAbleException() != null) {
            if (retryParam.getRetryAbleException().test(exception)) {
                applyExponentialBackOff(retryCounter);
            } else {
                log.warn("Non retryable exception occurred.");
                throw new DesignPatternException(exception);
            }
        } else {
            applyExponentialBackOff(retryCounter);
        }
    }

    private void applyExponentialBackOff(final int retryCounter) {
        if (retryParam.isUseExponentialBackOff()) {
            try {
                log.warn("Request throttled, retrying with retryCount {}", retryCounter);
                exponentialWaitTime = (long) Math.pow(retryParam.getExponentialBackOffBase(), retryCounter) * retryParam.getExponentialBackOffMultiplier();
                Thread.sleep(exponentialWaitTime);
            } catch (final InterruptedException e) {
                log.error("Exception while waiting for next call", e);
            }
        } else {
            log.info("Retry without exponential back-off");
            try {
                Thread.sleep(DEFAULT_WAIT);
            } catch (final InterruptedException e) {
                log.error("Exception while waiting for next call", e);
            }
        }
    }
}
