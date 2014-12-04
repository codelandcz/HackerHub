package cz.codeland.hackerhub;

import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class GitHubClient implements Client
{

  String username = null;
  String password = null;

  @Override
  public Client setCredentials() throws GitHubClientCredentialsException
  {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      username = reader.readLine();
      password = reader.readLine();
    } catch (IOException e) {
      //TODO Add msg
      throw new GitHubClientCredentialsException();
    }
    return this;
  }

  @Override
  public List<Repository> getRepositories()
  {
    ArrayList<Repository> repositories = new ArrayList<>();
    if (username == null) {
      try {
        setCredentials();
      } catch (GitHubClientCredentialsException e) {
        System.out.println(e.getMessage());
      }
    }

    RepositoryService service = new RepositoryService();
    try {
      for (org.eclipse.egit.github.core.Repository repo : service.getRepositories("defunkt"))
        repositories.add(new GitHubRepository(repo.getName(), repo.getHomepage()));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return repositories;
  }

}
