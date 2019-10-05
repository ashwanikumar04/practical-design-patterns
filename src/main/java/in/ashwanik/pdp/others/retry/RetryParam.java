package in.ashwanik.pdp.others.retry;


import lombok.Getter;

import java.util.function.Predicate;

/**
 * Params used by RetryCommand {@link RetryCommand}
 */
@Getter
class RetryParam {
    private int retryCount;
    private int exponentialBackOffBase;
    private int exponentialBackOffMultiplier;
    private boolean useExponentialBackOff;
    private String message;
    private Predicate<Exception> retryAbleException;

    private RetryParam() {

    }

    static RetryParamBuilder builder() {
        return new RetryParamBuilder();
    }

    static final class RetryParamBuilder {
        private static final int DEFAULT_RETRY_COUNT = 3;
        private static final int DEFAULT_EXPONENTIAL_BACK_OFF_BASE = 2;
        private static final int DEFAULT_EXPONENTIAL_BACK_OFF_MULTIPLIER = 100;
        private static final boolean DEFAULT_USE_EXPONENTIAL_BACK_OFF = false;
        private Integer retryCount;
        private Integer exponentialBackOffBase;
        private Integer exponentialBackOffMultiplier;
        private Boolean useExponentialBackOff;
        private String message;
        private Predicate<Exception> retryAbleException;

        private RetryParamBuilder() {
        }

        /**
         * Sets the number of retry to perform. Defaults to 3
         *
         * @param retryCount Count
         * @return Builder
         */
        RetryParamBuilder retryCount(final Integer retryCount) {
            this.retryCount = retryCount;
            return this;
        }

        /**
         * Sets the base for calculating the exponential back-off. @see <a href=https://en.wikipedia.org/wiki/Exponential_backoff />
         * Defaults to 2
         *
         * @param exponentialBackOffBase Back off base
         * @return Builder
         */
        RetryParamBuilder exponentialBackOffBase(final Integer exponentialBackOffBase) {
            this.exponentialBackOffBase = exponentialBackOffBase;
            return this;
        }

        /**
         * Sets the multiplier for calculating the exponential back-off. @see <a href=https://en.wikipedia.org/wiki/Exponential_backoff />
         * Defaults to 100
         *
         * @param exponentialBackOffMultiplier Multiplier
         * @return Builder
         */
        RetryParamBuilder exponentialBackOffMultiplier(final Integer exponentialBackOffMultiplier) {
            this.exponentialBackOffMultiplier = exponentialBackOffMultiplier;
            return this;
        }

        /**
         * Flag to enable exponential back-off
         * Defaults to false
         *
         * @param useExponentialBackOff Boolean indicating use of exponential back-off
         * @return Builder
         */
        RetryParamBuilder useExponentialBackOff(final Boolean useExponentialBackOff) {
            this.useExponentialBackOff = useExponentialBackOff;
            return this;
        }

        /**
         * Sets the message to be logged along with the other logs
         *
         * @param message Message to be logged
         * @return Builder
         */
        RetryParamBuilder message(final String message) {
            this.message = message;
            return this;
        }

        /**
         * Function which when set is used to check if an exception should be retried
         *
         * @param retryAbleException Function which return boolean to retry for an exception
         * @return Builder
         */
        RetryParamBuilder retryAbleException(final Predicate<Exception> retryAbleException) {
            this.retryAbleException = retryAbleException;
            return this;
        }

        RetryParam build() {
            final RetryParam retryParam = new RetryParam();
            retryParam.exponentialBackOffBase = this.exponentialBackOffBase == null ? DEFAULT_EXPONENTIAL_BACK_OFF_BASE : this.exponentialBackOffBase;
            retryParam.exponentialBackOffMultiplier = this.exponentialBackOffMultiplier == null ? DEFAULT_EXPONENTIAL_BACK_OFF_MULTIPLIER : this.exponentialBackOffMultiplier;
            retryParam.retryCount = this.retryCount == null ? DEFAULT_RETRY_COUNT : this.retryCount;
            retryParam.useExponentialBackOff = this.useExponentialBackOff == null ? DEFAULT_USE_EXPONENTIAL_BACK_OFF : this.useExponentialBackOff;
            retryParam.message = this.message;
            retryParam.retryAbleException = this.retryAbleException;
            return retryParam;
        }
    }
}
