package cz.codeland.hackerhub.issue;

import cz.codeland.hackerhub.client.Client;
import cz.codeland.hackerhub.client.GitHubClient;
import cz.codeland.hackerhub.problem.Problem;
import cz.codeland.hackerhub.repository.Repository;

import java.io.IOException;

public class GitHubIssueService implements IssueService
{
  @Override
  public Issue createIssue(Client client, Repository repository, Problem problem) throws IOException
  {
    GitHubClient gitHubClient;
    if (!(client instanceof GitHubClient))
      throw new IllegalArgumentException("GitHub client needed.");

    gitHubClient = (GitHubClient) client;
    org.eclipse.egit.github.core.service.IssueService issueService;
    org.eclipse.egit.github.core.Issue createdIssue;

    issueService = new org.eclipse.egit.github.core.service.IssueService(gitHubClient.getClient());
    org.eclipse.egit.github.core.Issue issue = new org.eclipse.egit.github.core.Issue();
    issue.setTitle("Solve \"" + problem.getName() + "\" problem");
    issue.setBody(problem.getLink());
    createdIssue = issueService.createIssue(client.getUsername(), repository.getName(), issue);

    GitHubIssue gitHubIssue = new GitHubIssue();
    gitHubIssue.setIssue(createdIssue);

    return gitHubIssue;
  }
}
