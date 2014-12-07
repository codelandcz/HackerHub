package cz.codeland.hackerhub;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;

public class GitHubRepository implements Repository
{
  private final String                                  name;
  private final String                                  htmlUrl;
  private       org.eclipse.egit.github.core.Repository repository;

  public GitHubRepository(String name, String htmlUrl)
  {
    this.name = name;
    this.htmlUrl = htmlUrl;
  }

  public GitHubRepository(org.eclipse.egit.github.core.Repository repository)
  {
    this.name = repository.getName();
    this.htmlUrl = repository.getHtmlUrl();
    this.repository = repository;
  }

  @Override
  public String getName()
  {
    return name;
  }

  @Override
  public String getHtmlUrl()
  {
    return htmlUrl;
  }

  @Override
  public void createContent(Client client, String content, String commitMessage, String path) throws IOException
  {
    GitHub gitHub = GitHub.connectUsingPassword(client.getUsername(), client.getPassword());
    GHRepository ghRepository = gitHub.getRepository(client.getUsername() + "/" + this.getName());
    ghRepository.createContent(content, commitMessage, path);
  }

  @Override
  public String toString()
  {
    return "{" + this.getName() + ", " + this.getHtmlUrl() + "}";
  }

  public org.eclipse.egit.github.core.Repository getRepository()
  {
    return repository;
  }
}
