package cz.codeland.hackerhub;

public class GitHubFactory implements ClientFactory
{
  @Override
  public Client createClient(ClientType clientType) throws ClientTypeException
  {
    Client client;
    if (clientType.equals(ClientType.GITHUB)) {
      client = new GitHubClient();
    } else {
      throw new ClientTypeException("Unknown ClientType!");
    }

    return client;
  }
}
