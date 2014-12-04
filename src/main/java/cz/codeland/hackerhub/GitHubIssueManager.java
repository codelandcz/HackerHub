package cz.codeland.hackerhub;

import java.io.IOException;

public class GitHubIssueManager implements IssueManager
{
  @Override
  public Issue createIssue(Client client, Repository repository, Problem problem) throws IOException
  {
    IssueService issueService = new GitHubIssueService();
    Issue createdIssue = issueService.createIssue((GitHubClient) client, repository, problem);

    return createdIssue;
  }
}
