package cz.codeland.hackerhub;

import junit.framework.Assert;
import org.junit.Test;

public class HelperTest
{
  @Test
  public void testParseLink() throws Exception
  {
    Assert.assertEquals("solve-me-first", Helper.parseLink("https://www.hackerrank.com/challenges/solve-me-first"));
  }
}
