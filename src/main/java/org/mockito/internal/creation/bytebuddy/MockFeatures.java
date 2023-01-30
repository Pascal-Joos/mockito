/*
 * Copyright (c) 2016 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.creation.bytebuddy;

import java.util.Collections;
import java.util.Set;

import org.mockito.mock.SerializableMode;
import javax.annotation.Nullable;

class MockFeatures<T> {

    @Nullable final Class<T> mockedType;
    final Set<Class<?>> interfaces;
    final SerializableMode serializableMode;
    final boolean stripAnnotations;

    private MockFeatures(
            @Nullable Class<T> mockedType,
            Set<Class<?>> interfaces,
            SerializableMode serializableMode,
            boolean stripAnnotations) {
        this.mockedType = mockedType;
        this.interfaces = Collections.unmodifiableSet(interfaces);
        this.serializableMode = serializableMode;
        this.stripAnnotations = stripAnnotations;
    }

    public static <T> MockFeatures<T> withMockFeatures(
            @Nullable Class<T> mockedType,
            Set<Class<?>> interfaces,
            SerializableMode serializableMode,
            boolean stripAnnotations) {
        return new MockFeatures<T>(mockedType, interfaces, serializableMode, stripAnnotations);
    }
}
