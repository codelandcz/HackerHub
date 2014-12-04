package cz.codeland.hackerhub;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Helper
{
  static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  public static String readString(String question)
  {
    System.out.println(question);
    return scanner.nextLine().trim();
  }

  public static String parseLink(String link) throws MalformedURLException
  {
    URL url = new URL(link);
    String[] crumbs = link.split("/");
    return crumbs[crumbs.length - 1];
  }
}
