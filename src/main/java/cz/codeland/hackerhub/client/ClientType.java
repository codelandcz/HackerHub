package cz.codeland.hackerhub.client;

public enum ClientType
{
  GITHUB("GitHub");

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
