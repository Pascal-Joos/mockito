/*
 * Copyright (c) 2018 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.junit;

import javax.annotation.Nullable;

public interface TestFinishedEvent {

  @Nullable
  Throwable getFailure();

  String getTestName();
}
