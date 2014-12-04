package cz.codeland.hackerhub;

import java.io.IOException;

public interface IssueService
{
  Issue createIssue(GitHubClient client, Repository repository, Problem problem) throws IOException;
}
