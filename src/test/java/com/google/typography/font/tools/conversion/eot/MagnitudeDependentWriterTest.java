/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.typography.font.tools.conversion.eot;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Raph Levien
 */
public class MagnitudeDependentWriterTest {

  // This is the example from section 5.3.1 of the spec.
  @Test
  public void testMagnitudeDependent() {
    MagnitudeDependentWriter writer = new MagnitudeDependentWriter();
    writer.writeValue(0);
    writer.writeValue(0);
    writer.writeValue(0);
    writer.writeValue(0);
    writer.writeValue(1);
    writer.writeValue(1);
    writer.writeValue(0);
    writer.writeValue(1);
    writer.writeValue(1);
    writer.writeValue(0);
    writer.writeValue(1);
    writer.writeValue(0);
    writer.writeValue(0);
    writer.writeValue(0);
    writer.flush();
    byte[] result = writer.toByteArray();
    // Note: the spec says 0x90, 0x48, 0x84, but the spec is wrong.
    byte[] expected = {(byte)0x90, (byte)0x48, (byte)0x04};
    assertArrayEquals(expected, result);
  }

  @Test
  public void testMagnitudeDependentValues() {
    MagnitudeDependentWriter writer = new MagnitudeDependentWriter();
    writer.writeValue(0);
    writer.writeValue(-1);
    writer.writeValue(2);
    writer.writeValue(-3);
    writer.flush();
    byte[] result = writer.toByteArray();
    byte[] expected = {(byte)0x3a, (byte)0x17};
    assertArrayEquals(expected, result);
  }
}
