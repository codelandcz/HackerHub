package cz.codeland.hackerhub;

import java.io.IOException;
import java.util.List;

public interface RepositoryChooser
{
  List<Repository> getRepositories(Client client) throws IOException;

  void listRepositories(List<Repository> repositories);
}
