package cz.codeland.hackerhub.configuration;

public class Configuration
{
  private static Configuration instance = new Configuration();

  private Configuration()
  {
  }

  public static Configuration getInstance()
  {
    return instance;
  }

  public String getTemplatePath()
  {
    return "src/main/resources/MainTemplate.txt";
  }

  public String getRemotePath()
  {
    return "/src/Main.java";
  }
}
