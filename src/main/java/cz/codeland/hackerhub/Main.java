package cz.codeland.hackerhub;

import java.io.IOException;
import java.util.List;

public class Main
{
  public static void main(String[] args) throws IOException
  {
    ProblemReader reader = new ProblemReader();
    Problem problem = reader.loadProblem();
    ClientFactory factory = new GitHubFactory();
    //TODO Mask password
    Client client = factory.createClient(ClientType.GITHUB).setCredentials();

    System.out.println("Reading repositories...");
    RepositoryChooser chooser = new GitHubRepositoryChooser();
    List<Repository> repositories = chooser.getRepositories(client);

    System.out.println("Available repositories:");
    chooser.listRepositories(repositories);
    //TODO Check letter
    int index = Helper.readInteger("Choose the repository by the index.");
    //TODO Check index
    Repository repository = repositories.get(index);
    System.out.println(repository);

    System.out.println("Creating issue...");
    IssueManager manager = new GitHubIssueManager();
    Issue createdIssue = manager.createIssue(client, repository, problem);
    System.out.println("Issue created:");
    System.out.printf(" Title: %s", createdIssue.getTitle());
    System.out.println();
    System.out.printf(" Url: %s", createdIssue.getHtmlUrl());
  }
}
