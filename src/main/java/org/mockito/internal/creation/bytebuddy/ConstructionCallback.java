/*
 * Copyright (c) 2020 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.creation.bytebuddy;

import javax.annotation.Nullable;

public interface ConstructionCallback {

    Object apply(Class<?> type, Object object, Object[] arguments, String[] parameterTypeNames);
}
