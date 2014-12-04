package cz.codeland.hackerhub;

import java.io.IOException;

public interface IssueManager
{
  Issue createIssue(Client client, Repository repository, Problem problem) throws IOException;
}
