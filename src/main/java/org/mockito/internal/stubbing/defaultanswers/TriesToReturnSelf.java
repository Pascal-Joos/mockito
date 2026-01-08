/*
 * Copyright (c) 2016 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.stubbing.defaultanswers;

import java.io.Serializable;
import javax.annotation.Nullable;
import org.mockito.internal.util.MockUtil;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TriesToReturnSelf implements Answer<Object>, Serializable {

  private final ReturnsEmptyValues defaultReturn = new ReturnsEmptyValues();

  @Nullable
  @Override
  public Object answer(InvocationOnMock invocation) throws Throwable {
    Class<?> methodReturnType = invocation.getMethod().getReturnType();
    Object mock = invocation.getMock();
    Object mockHandler = MockUtil.getMockHandler(mock);
    if (mockHandler == null) {
      return null;
    }
    Class<?> mockType = ((MockHandler) mockHandler).getMockSettings().getTypeToMock();

    if (methodReturnType.isAssignableFrom(mockType)) {
      return invocation.getMock();
    }

    return defaultReturn.returnValueFor(methodReturnType);
  }
}
