/*
 * Copyright (c) 2018 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.junit;
import javax.annotation.Nullable;
import org.jspecify.annotations.NullUnmarked;

public class DefaultTestFinishedEvent implements TestFinishedEvent {
    @Nullable private final Object testClassInstance;
    private final String testMethodName;
    @Nullable private final Throwable testFailure;

    public DefaultTestFinishedEvent(
            @Nullable Object testClassInstance, String testMethodName, @Nullable Throwable testFailure) {
        this.testClassInstance = testClassInstance;
        this.testMethodName = testMethodName;
        this.testFailure = testFailure;
    }

    @Nullable @Override
    public Throwable getFailure() {
        return testFailure;
    }

    @NullUnmarked @Override
    public String getTestName() {
        return testClassInstance.getClass().getSimpleName() + "." + testMethodName;
    }
}
