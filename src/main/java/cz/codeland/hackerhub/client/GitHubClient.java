package cz.codeland.hackerhub.client;

import cz.codeland.hackerhub.Helper;

public class GitHubClient implements Client
{
  String username = null;
  String password = null;
  org.eclipse.egit.github.core.client.GitHubClient client;

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  @Override
  public Client setCredentials()
  {
    username = Helper.readString("Insert your username.");
    password = Helper.readString("Insert your password.");

    client = new org.eclipse.egit.github.core.client.GitHubClient();
    client.setCredentials(username, password);

    return this;
  }

  public org.eclipse.egit.github.core.client.GitHubClient getClient()
  {
    return client;
  }
}
