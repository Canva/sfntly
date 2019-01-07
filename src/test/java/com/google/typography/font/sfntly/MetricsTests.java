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

package com.google.typography.font.sfntly;

import com.google.typography.font.sfntly.table.core.HorizontalMetricsTable;
import com.google.typography.font.sfntly.testutils.TestFont;
import com.google.typography.font.sfntly.testutils.TestFontUtils;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


/**
 * @author Stuart Gill
 */
public class MetricsTests {

  private static final String TEST_FONT_FILE = TestFont.TestFontNames.OPENSANS.getPath();

    @Test
  public void testBasicHmtxValidity() throws Exception {
      Font[] fonts = TestFontUtils.loadFont(TEST_FONT_FILE);
      Font font = fonts[0];
      HorizontalMetricsTable hmtxTable = font.getTable(Tag.hmtx);
      
      for (int gid = 0; gid < 100; gid++) {
        int width = hmtxTable.advanceWidth(gid);
          assertNotEquals(width, -1);
      }
    }
}
