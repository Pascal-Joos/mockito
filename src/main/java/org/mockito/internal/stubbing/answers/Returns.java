/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.stubbing.answers;

import static org.mockito.internal.exceptions.Reporter.cannotStubVoidMethodWithAReturnValue;
import static org.mockito.internal.exceptions.Reporter.wrongTypeOfReturnValue;

import java.io.Serializable;
import javax.annotation.Nullable;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.ValidableAnswer;

public class Returns implements Answer<Object>, ValidableAnswer, Serializable {

  private static final long serialVersionUID = -6245608253574215396L;
  @Nullable private final Object value;

  public Returns(@Nullable Object value) {
    this.value = value;
  }

  @Nullable
  public Object answer(InvocationOnMock invocation) throws Throwable {
    return value;
  }

  @Override
  public void validateFor(InvocationOnMock invocation) {
    InvocationInfo invocationInfo = new InvocationInfo(invocation);
    if (invocationInfo.isVoid()) {
      throw cannotStubVoidMethodWithAReturnValue(invocationInfo.getMethodName());
    }

    if (returnsNull() && invocationInfo.returnsPrimitive()) {
      throw wrongTypeOfReturnValue(
          invocationInfo.printMethodReturnType(), "null", invocationInfo.getMethodName());
    }

    if (!returnsNull() && !invocationInfo.isValidReturnType(returnType())) {
      throw wrongTypeOfReturnValue(
          invocationInfo.printMethodReturnType(),
          printReturnType(),
          invocationInfo.getMethodName());
    }
  }

  private String printReturnType() {
    return value.getClass().getSimpleName();
  }

  private Class<?> returnType() {
    if (value == null) {
      throw new IllegalStateException("Cannot determine return type when value is null");
    }
    return value.getClass();
  }

  private boolean returnsNull() {
    return value == null;
  }

  @Override
  public String toString() {
    return "Returns: " + value;
  }
}
