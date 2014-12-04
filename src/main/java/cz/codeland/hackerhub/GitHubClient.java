package cz.codeland.hackerhub;

public class GitHubClient implements Client
{
  String username = null;

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  String password = null;

  @Override
  public Client setCredentials()
  {
    username = Helper.readString("Insert your username.");
    password = Helper.readString("Insert your password.");

    org.eclipse.egit.github.core.client.GitHubClient client = new org.eclipse.egit.github.core.client.GitHubClient();
    client.setCredentials(username, password);

    return this;
  }
}
