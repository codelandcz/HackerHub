package cz.codeland.hackerhub.repository;

import cz.codeland.hackerhub.client.ClientType;

public class RepositoryPickerFactory
{
  public static RepositoryPicker createRepositoryPicker(ClientType clientType)
  {
    RepositoryPicker repositoryPicker = null;
    if (clientType.equals(clientType)) {
      repositoryPicker = new GitHubRepositoryPicker();
    }
    return repositoryPicker;
  }
}
