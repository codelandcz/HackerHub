package cz.codeland.hackerhub.issue;

import cz.codeland.hackerhub.problem.Problem;
import cz.codeland.hackerhub.repository.Repository;
import cz.codeland.hackerhub.client.Client;

import java.io.IOException;

public interface IssueManager
{
  Issue createIssue(Client client, Repository repository, Problem problem) throws IOException;
}
