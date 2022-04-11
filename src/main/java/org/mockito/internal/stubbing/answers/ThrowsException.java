/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.stubbing.answers;

import javax.annotation.Nullable;
import java.io.Serializable;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.ValidableAnswer;

/**
 * An answer that always throws the same throwable.
 */
public class ThrowsException extends AbstractThrowsException implements Serializable {

    private static final long serialVersionUID = 1128820328555183980L;

    @Nullable
    private final Throwable throwable;

    /**
     * Creates a new answer always throwing the given throwable. If it is null,
     * {@linkplain ValidableAnswer#validateFor(InvocationOnMock) answer validation}
     * will fail.
     */
    public ThrowsException(@Nullable Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    @Nullable
    protected Throwable getThrowable() {
        return throwable;
    }
}
