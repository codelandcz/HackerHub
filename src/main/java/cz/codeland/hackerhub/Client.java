package cz.codeland.hackerhub;

import java.util.List;

public interface Client
{
  Client setCredentials() throws GitHubClientCredentialsException;
  List<Repository> getRepositories();
}
