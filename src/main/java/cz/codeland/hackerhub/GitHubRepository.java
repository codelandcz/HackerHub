package cz.codeland.hackerhub;

public class GitHubRepository implements Repository
{
  private final String name;
  private final String htmlUrl;

  public GitHubRepository(String name, String htmlUrl)
  {
    this.name = name;
    this.htmlUrl = htmlUrl;
  }

  @Override
  public String getName()
  {
    return name;
  }

  @Override
  public String getHtmlUrl()
  {
    return htmlUrl;
  }

  @Override
  public String toString()
  {
    return "{" + this.getName() + ", " + this.getHtmlUrl() + "}";
  }
}
