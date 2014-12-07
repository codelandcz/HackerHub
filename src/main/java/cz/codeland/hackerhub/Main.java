package cz.codeland.hackerhub;

import java.io.IOException;
import java.nio.charset.Charset;
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
    Repository selectedRepository = repositories.get(index);
    System.out.println(selectedRepository);

    System.out.println("Creating issue...");
    IssueManager manager = new GitHubIssueManager();
    Issue createdIssue = manager.createIssue(client, selectedRepository, problem);
    System.out.println("Issue created:");
    System.out.printf(" Title: %s", createdIssue.getTitle());
    System.out.println();

    System.out.println("Creating file...");
    //TODO Templates list
    //TODO Users can add theirs templates and chose the one
    String content = Helper.readFile("src/main/resources/MainTemplate.txt", Charset.defaultCharset());
    String commitMessage = "init #" + createdIssue.getNumber() + " " + createdIssue.getTitle();
    String path = problem.shortName + "/src/Main.java";
    //TODO Refactor connect inside github repository
    selectedRepository.createContent(client, content, commitMessage, path);

    System.out.println("Done.");
  }
}
