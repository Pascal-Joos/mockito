/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.verification;

import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationEvent;
import org.mockito.verification.VerificationMode;
import javax.annotation.Nullable;

public class VerificationEventImpl implements VerificationEvent {
    private final Object mock;
    private final VerificationMode mode;
    private final VerificationData data;
    @Nullable private final Throwable cause;

    public VerificationEventImpl(
            Object mock, VerificationMode mode, VerificationData data, @Nullable Throwable cause) {
        this.mock = mock;
        this.mode = mode;
        this.data = data;
        this.cause = cause;
    }

    public Object getMock() {
        return mock;
    }

    public VerificationMode getMode() {
        return mode;
    }

    public VerificationData getData() {
        return data;
    }

    @Nullable public Throwable getVerificationError() {
        return cause;
    }
}
