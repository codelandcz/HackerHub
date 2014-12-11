package cz.codeland.hackerhub;

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
