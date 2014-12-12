package cz.codeland.hackerhub.issue;

import cz.codeland.hackerhub.problem.Problem;
import cz.codeland.hackerhub.repository.Repository;
import cz.codeland.hackerhub.client.GitHubClient;

import java.io.IOException;

public interface IssueService
{
  Issue createIssue(GitHubClient client, Repository repository, Problem problem) throws IOException;
}
