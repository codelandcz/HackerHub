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
    Client client = factory.createClient(ClientType.GITHUB).setCredentials();

    System.out.println("Reading repositories...");
    RepositoryChooser chooser = new GitHubRepositoryChooser();
    List<Repository> repositories = chooser.getRepositories(client);

    System.out.println("Available repositories:");
    chooser.listRepositories(repositories);
    Repository selectedRepository;
    int index;
    do {
      try {
        index = Helper.readInteger("Choose the repository by the index.");
        selectedRepository = repositories.get(index);
        break;
      } catch (IndexOutOfBoundsException ignored) {
        System.out.println("Please insert correct index.");
      }
    } while (true);
    System.out.println(selectedRepository);

    System.out.println("Creating issue...");
    IssueManager manager = new GitHubIssueManager();
    Issue createdIssue = manager.createIssue(client, selectedRepository, problem);
    System.out.println("Issue created:");
    System.out.printf(" Title: %s%n", createdIssue.getTitle());

    System.out.println("Creating file...");
    String content = Helper.readFile("src/main/resources/MainTemplate.txt", Charset.defaultCharset());
    String commitMessage = "init #" + createdIssue.getNumber() + " " + createdIssue.getTitle();
    String path = problem.shortName + "/src/Main.java";
    selectedRepository.createContent(client, content, commitMessage, path);

    System.out.println("Done.Bye.");
  }
}
