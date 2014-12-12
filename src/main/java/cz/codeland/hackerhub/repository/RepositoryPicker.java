package cz.codeland.hackerhub.repository;

import cz.codeland.hackerhub.client.Client;

import java.util.List;

public interface RepositoryPicker
{
  List<Repository> getRepositories(Client client);

  void listRepositories(List<Repository> repositories);
}
