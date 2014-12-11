package cz.codeland.hackerhub;

public enum ClientType
{
  GITHUB("GitHub"), BITBUCKET("Bitbucket");

  private String name;

  ClientType(String name)
  {

    this.name = name;
  }

  @Override
  public String toString()
  {
    return name;
  }
}
