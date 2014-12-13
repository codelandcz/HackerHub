package cz.codeland.hackerhub.issue;

import cz.codeland.hackerhub.client.Client;
import cz.codeland.hackerhub.problem.Problem;
import cz.codeland.hackerhub.repository.Repository;

import java.io.IOException;

public interface IssueService
{
  Issue createIssue(Client client, Repository repository, Problem problem) throws IOException;
}
