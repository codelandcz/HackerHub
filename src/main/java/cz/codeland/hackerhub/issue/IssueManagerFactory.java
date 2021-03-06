package cz.codeland.hackerhub.issue;

import cz.codeland.hackerhub.client.ClientType;

public class IssueManagerFactory
{
  public static IssueManager createIssueManager(ClientType clientType)
  {
    IssueManager issueManager = null;
    if (clientType.equals(ClientType.GITHUB)) {
      issueManager = new GitHubIssueManager();
    }

    return issueManager;
  }
}
