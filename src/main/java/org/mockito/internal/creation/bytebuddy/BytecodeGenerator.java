/*
 * Copyright (c) 2016 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.creation.bytebuddy;
import javax.annotation.Nullable;

public interface BytecodeGenerator {

    @Nullable <T> Class<? extends T> mockClass(MockFeatures<T> features);

    void mockClassConstruction(Class<?> type);

    void mockClassStatic(Class<?> type);
}
