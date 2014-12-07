package cz.codeland.hackerhub;

import junit.framework.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

public class HelperTest
{
  @Test
  public void testParseLink() throws Exception
  {
    Assert.assertEquals("solve-me-first", Helper.parseLink("https://www.hackerrank.com/challenges/solve-me-first"));
    String content = Helper.readFile("src/main/resources/MainTemplate.txt", Charset.defaultCharset());
    System.out.println(content);
  }
}
