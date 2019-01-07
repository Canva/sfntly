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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Raph Levien
 */
public class GlyfEncoderTest {

  @Test
  public void test255UShort1() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255UShort(os, 142);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte)142};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255UShort2() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255UShort(os, 254);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte)255, (byte)1};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255UShort3() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255UShort(os, 507);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte)254, (byte)1};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255UShort4() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255UShort(os, 0x1234);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte)253, (byte)0x12, (byte)0x34};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short1() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, 249);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 249};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short2() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, -249);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 250, (byte) 249};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short3() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, 250);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 255, (byte) 0};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short4() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, -250);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 250, (byte) 255, (byte) 0};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short5() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, 251);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 255, (byte)1};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short6() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, 499);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 255, (byte) 249};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short7() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, -499);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 250, (byte) 255, (byte) 249};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short8() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, 500);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 254, (byte) 0};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short9() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, -500);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 250, (byte) 254, (byte) 0};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short10() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, 749);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 254, (byte) 249};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short11() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, -749);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 250, (byte) 254, (byte) 249};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short12() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, 750);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 253, (byte) 0x02, (byte) 0xEE};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short13() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, -750);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 253, (byte) 0xFD, (byte) 0x12};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short14() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, -984);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte) 253, (byte) 0xFC, (byte) 0x28};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test255Short15() throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    GlyfEncoder.write255Short(os, 0x1234);
    byte[] actual = os.toByteArray();
    byte[] expected = {(byte)253, (byte)0x12, (byte)0x34};
    assertArrayEquals(expected, actual);
  }
  
  private byte[] tripletEncode(boolean onCurve, int x, int y) throws IOException {
    GlyfEncoder e = new GlyfEncoder();
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    e.writeTriplet(os, onCurve, x, y);
    
    byte[] flagBytes = e.getGlyfBytes();
    assertEquals(1, flagBytes.length);
    byte[] valueBytes = os.toByteArray();
    byte[] result = new byte[flagBytes.length + valueBytes.length];
    System.arraycopy(flagBytes, 0, result, 0, flagBytes.length);
    System.arraycopy(valueBytes, 0, result, flagBytes.length, valueBytes.length);
    return result;
  }

  @Test
  public void testTriplet1() throws IOException {
    byte[] expected = {(byte)1, (byte)1};
    assertArrayEquals(expected, tripletEncode(true, 0, 1));
  }

  @Test
  public void testTriplet2() throws IOException {
    byte[] expected = {(byte)2, (byte)1};
    assertArrayEquals(expected, tripletEncode(true, 0, -257));
  }

  @Test
  public void testTriplet11() throws IOException {
    byte[] expected = {(byte)11, (byte)1};
    assertArrayEquals(expected, tripletEncode(true, 1, 0));
  }

  @Test
  public void testTriplet15() throws IOException {
    byte[] expected = {(byte)15, (byte)1};
    assertArrayEquals(expected, tripletEncode(true, 513, 0));
  }

  @Test
  public void testTriplet21() throws IOException {
    byte[] expected = {(byte)21, (byte)0x12};
    assertArrayEquals(expected, tripletEncode(true, 2, -3));
  }

  @Test
  public void testTriplet56() throws IOException {
    byte[] expected = {(byte)56, (byte)0x12};
    assertArrayEquals(expected, tripletEncode(true, -34, -19));
  }

  public void testTriplet87() throws IOException {
    byte[] expected = {(byte)87, (byte)128, (byte)130};
    assertArrayEquals(expected, tripletEncode(true, 129, 131));
  }

  @Test
  public void testTriplet105() throws IOException {
    byte[] expected = {(byte)105, (byte)200, (byte)100};
    assertArrayEquals(expected, tripletEncode(true, 457, -613));
  }

  @Test
  public void testTriplet121() throws IOException {
    byte[] expected = {(byte)121, (byte)0x12, (byte)0x34, (byte)0x56};
    assertArrayEquals(expected, tripletEncode(true, 0x123, -0x456));
  }

  @Test
  public void testTriplet126() throws IOException {
    byte[] expected = {(byte)126, (byte)0x12, (byte)0x34, (byte)0x56, (byte)0x78};
    assertArrayEquals(expected, tripletEncode(true, -0x1234, 0x5678));
  }

  @Test
  public void testTriplet129() throws IOException {
    byte[] expected = {(byte)129, (byte)1};
    assertArrayEquals(expected, tripletEncode(false, 0, 1));
  }

  @Test
  public void testTriplet254() throws IOException {
    byte[] expected = {(byte)254, (byte)0x12, (byte)0x34, (byte)0x56, (byte)0x78};
    assertArrayEquals(expected, tripletEncode(false, -0x1234, 0x5678));
  }
}
