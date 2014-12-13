package cz.codeland.hackerhub.helper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
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

  public static int readInteger(String question)
  {
    System.out.println(question);
    int input;
    do {
      try {
        input = scanner.nextInt();
        break;
      } catch (InputMismatchException e) {
        System.out.println("Please insert correct number.");
      }
    } while (true);

    return input;
  }

  public static String readFile(String path, Charset encoding) throws IOException
  {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
  }
}
