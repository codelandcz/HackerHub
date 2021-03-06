package cz.codeland.hackerhub.repository;

import cz.codeland.hackerhub.client.Client;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GitHubRepositoryPicker implements RepositoryPicker
{
  @Override
  public List<Repository> getRepositories(Client client)
  {
    List<Repository> repositories = new ArrayList<>();
    RepositoryService service = new RepositoryService();

    List<org.eclipse.egit.github.core.Repository> remoteRepositories = new ArrayList<>();
    try {
      remoteRepositories = service.getRepositories(client.getUsername());
    } catch (IOException e) {
      System.out.println("An error during reading the repositories.");
    }

    for (org.eclipse.egit.github.core.Repository repository : remoteRepositories) {
      repositories.add(new GitHubRepository(repository));
    }

    return repositories;
  }

  @Override
  public void listRepositories(List<Repository> repositories)
  {
    for (int i = 0; i < repositories.size(); i++) {
      Repository repository = repositories.get(i);
      System.out.printf("%3d) %s [%s]%n", i, repository.getName(), repository.getHtmlUrl());
    }
  }
}
