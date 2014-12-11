package cz.codeland.hackerhub;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class HackerHub
{
  private Problem          problem;
  private Client           client;
  private ClientType       clientType;
  private RepositoryPicker repositoryPicker;
  private List<Repository> repositories;

  public HackerHub()
  {
  }

  public static void main(String[] args) throws IOException
  {
    HackerHub hackerHub = new HackerHub();
    hackerHub.defineProblem();
    ClientType clientType = ClientType.GITHUB;
    hackerHub.setCredentials(clientType);

    System.out.println("Reading repositories...");
    hackerHub.readRepositories();
    hackerHub.listRepositories();
    Repository selectedRepository = hackerHub.selectRepository();

    System.out.println("Creating issue...");
    IssueManager manager = new GitHubIssueManager();
    Issue createdIssue = manager.createIssue(hackerHub.getClient(), selectedRepository, hackerHub.getProblem());
    System.out.println("Issue created:");
    System.out.printf(" Title: %s%n", createdIssue.getTitle());

    System.out.println("Creating file...");
    String content = Helper.readFile("src/main/resources/MainTemplate.txt", Charset.defaultCharset());
    String commitMessage = "init #" + createdIssue.getNumber() + " " + createdIssue.getTitle();
    String path = hackerHub.getProblem().shortName + "/src/Main.java";
    selectedRepository.createContent(hackerHub.getClient(), content, commitMessage, path);

    System.out.println("Done. Bye.");
  }

  public Problem defineProblem()
  {
    ProblemReader reader = new ProblemReader();
    problem = reader.loadProblem();

    return problem;
  }

  public Client getClient()
  {
    return client;
  }

  public Problem getProblem()
  {
    return problem;
  }

  public Client setCredentials(ClientType clientType)
  {
    this.clientType = clientType;
    client = ClientFactory.createClient(clientType).setCredentials();
    return client;
  }

  public Repository selectRepository()
  {
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

    System.out.printf("You selected: %s%n", selectedRepository);

    return selectedRepository;
  }

  public void listRepositories()
  {
    System.out.println("Available repositories:");
    repositoryPicker.listRepositories(repositories);
  }

  public List<Repository> readRepositories() throws IOException
  {
    repositoryPicker = RepositoryPickerFactory.createRepositoryPicker(clientType);
    repositories = repositoryPicker.getRepositories(client);
    return repositories;
  }
}
