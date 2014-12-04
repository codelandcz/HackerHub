package cz.codeland.hackerhub;

import java.io.IOException;

public class GitHubIssueService implements IssueService
{
  @Override
  public Issue createIssue(GitHubClient client, Repository repository, Problem problem) throws IOException
  {
    org.eclipse.egit.github.core.service.IssueService issueService;
    org.eclipse.egit.github.core.Issue createdIssue;

    issueService = new org.eclipse.egit.github.core.service.IssueService(client.getClient());
    org.eclipse.egit.github.core.Issue serviceIssue = new org.eclipse.egit.github.core.Issue();
    serviceIssue.setTitle("Solve \"" + problem.name + "\" problem");
    serviceIssue.setBody(problem.link);
    createdIssue = issueService.createIssue(client.getUsername(), repository.getName(), serviceIssue);

    GitHubIssue issue = new GitHubIssue();
    issue.setIssue(createdIssue);

    return issue;
  }
}
