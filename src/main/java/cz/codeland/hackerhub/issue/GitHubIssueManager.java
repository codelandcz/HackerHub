package cz.codeland.hackerhub.issue;

import cz.codeland.hackerhub.problem.Problem;
import cz.codeland.hackerhub.repository.Repository;
import cz.codeland.hackerhub.client.Client;
import cz.codeland.hackerhub.client.GitHubClient;

import java.io.IOException;

public class GitHubIssueManager implements IssueManager
{
  private Issue createdIssue;

  @Override
  public Issue createIssue(Client client, Repository repository, Problem problem) throws IOException
  {
    IssueService issueService = new GitHubIssueService();
    createdIssue = issueService.createIssue((GitHubClient) client, repository, problem);

    return createdIssue;
  }
}
