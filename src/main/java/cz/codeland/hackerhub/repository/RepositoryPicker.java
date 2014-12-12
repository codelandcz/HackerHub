package cz.codeland.hackerhub.repository;

import cz.codeland.hackerhub.client.Client;

import java.io.IOException;
import java.util.List;

public interface RepositoryPicker
{
  List<Repository> getRepositories(Client client) throws IOException;

  void listRepositories(List<Repository> repositories);
}
