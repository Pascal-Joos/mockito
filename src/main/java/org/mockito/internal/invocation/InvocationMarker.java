/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.invocation;

import java.util.List;

import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;
import javax.annotation.Nullable;
import org.mockito.NullUnmarked;

public class InvocationMarker {

    private InvocationMarker() {}

    public static void markVerified(List<Invocation> invocations, @Nullable MatchableInvocation wanted) {
        for (Invocation invocation : invocations) {
            markVerified(invocation, wanted);
        }
    }

    @NullUnmarked public static void markVerified(Invocation invocation, @Nullable MatchableInvocation wanted) {
        invocation.markVerified();
        wanted.captureArgumentsFrom(invocation);
    }

    public static void markVerifiedInOrder(
            List<Invocation> chunk, @Nullable MatchableInvocation wanted, InOrderContext context) {
        markVerified(chunk, wanted);

        for (Invocation i : chunk) {
            context.markVerified(i);
        }
    }
}
