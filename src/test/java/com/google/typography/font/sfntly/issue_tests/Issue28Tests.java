package com.google.typography.font.sfntly.issue_tests;

import com.google.common.io.ByteStreams;
import com.google.typography.font.sfntly.Font;
import com.google.typography.font.sfntly.FontFactory;
import com.google.typography.font.sfntly.Tag;
import com.google.typography.font.sfntly.table.truetype.Glyph;
import com.google.typography.font.sfntly.table.truetype.GlyphTable;
import com.google.typography.font.sfntly.table.truetype.LocaTable;
import com.google.typography.font.sfntly.testutils.TestFont;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;

/**
 * Test class showing inconsistent behaviour between loading from a byte array
 * vs loading from a file input stream.
 */
public class Issue28Tests {
  
  private static byte[] readToByteArray(String file) throws IOException {
    try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(file)) {
      return ByteStreams.toByteArray(is);
    }
  }

  private static Glyph getLastGlyph(Font font) {
    LocaTable locaTable = font.getTable(Tag.loca);
    int glyphId = locaTable.numGlyphs() - 1;
    GlyphTable glyfTable = font.getTable(Tag.glyf);
    int offset = locaTable.glyphOffset(glyphId);
    int length = locaTable.glyphLength(glyphId);
    return glyfTable.glyph(offset, length);
  }

  /**
   * Ensure that the stream and byte array sourced fonts both throw an exception when you
   * read off the end of a sliced ReadableFontData
   */
  @Test
  public void testStreamVsBytes() throws Exception {
    FontFactory factory = FontFactory.getInstance();

    byte[] data = readToByteArray(TestFont.TestFontNames.ROBOTO.getPath());
    Font byteFont = factory.loadFonts(data)[0];

    Font streamFont;
    try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(TestFont.TestFontNames.ROBOTO.getPath())) {
      streamFont = factory.loadFonts(is)[0];
    }

    // first test for byte array sourced font
    {
      boolean thrown = false;
      Glyph byteGlyph = getLastGlyph(byteFont);
      try {
        int byteXMin = byteGlyph.xMin();
      } catch (IndexOutOfBoundsException e) {
        // expected exception
        thrown = true;
      }
      assertTrue("IndexOutOfBoundsException was expected but was not thrown.", thrown);
    }

    // next test for stream sourced font
    {
      boolean thrown = false;
      Glyph streamGlyph = getLastGlyph(streamFont);
      try {
        int streamXMin = streamGlyph.xMin();
      } catch (IndexOutOfBoundsException e) {
        // expected exception
        thrown = true;
      }
      assertTrue("IndexOutOfBoundsException was expected but was not thrown.", thrown);
    }
  }
}
