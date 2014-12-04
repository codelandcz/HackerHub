package cz.codeland.hackerhub;

public class GitHubRepository implements Repository
{
  private final String name;
  private final String homepage;

  public GitHubRepository(String name, String homepage)
  {
    this.name = name;
    this.homepage = homepage;
  }

  @Override
  public String getName()
  {
    return name;
  }

  @Override
  public String getHomepage()
  {
    return homepage;
  }
}
