package cz.codeland.hackerhub.client;

import org.junit.Before;
import org.junit.Test;

public class GitHubClientTest
{
  private GitHubClient client;

  @Before
  public void setUp() throws Exception
  {
    this.client = new GitHubClient();
  }

  @Test
  public void testSetCredentials() throws Exception
  {
    client = (GitHubClient) ClientFactory.createClient(ClientType.GITHUB);
    client.setCredentials();
  }
}
