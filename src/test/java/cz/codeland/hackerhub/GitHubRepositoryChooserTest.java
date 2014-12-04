package cz.codeland.hackerhub;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GitHubRepositoryChooserTest
{
  @Test
  public void testListRepositories() throws Exception
  {
    GitHubRepositoryChooser repositoryChooser = new GitHubRepositoryChooser();
    List<Repository> repositories = new ArrayList<>();
    repositories.add(new GitHubRepository("name1", "homepage1"));
    repositories.add(new GitHubRepository("name2", "homepage2"));
    repositories.add(new GitHubRepository("name3", "homepage3"));
    repositoryChooser.listRepositories(repositories);
  }
}
