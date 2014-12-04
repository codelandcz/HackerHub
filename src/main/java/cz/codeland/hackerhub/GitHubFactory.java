package cz.codeland.hackerhub;

public class GitHubFactory implements ClientFactory
{
  @Override
  public Client createClient(ClientType clientType)
  {
    Client client = null;
    if (clientType.equals(ClientType.GITHUB)) {
      client = new GitHubClient();
    }

    return client;
  }
}
