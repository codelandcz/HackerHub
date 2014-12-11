package cz.codeland.hackerhub;

public class ClientFactory
{
  public static Client createClient(ClientType clientType)
  {
    Client client = null;
    if (clientType.equals(ClientType.GITHUB)) {
      client = new GitHubClient();
    }

    return client;
  }
}
