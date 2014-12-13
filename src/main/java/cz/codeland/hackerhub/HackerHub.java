package cz.codeland.hackerhub;

import cz.codeland.hackerhub.client.Client;
import cz.codeland.hackerhub.client.ClientFactory;
import cz.codeland.hackerhub.client.ClientType;
import cz.codeland.hackerhub.configuration.Configuration;
import cz.codeland.hackerhub.helper.Helper;
import cz.codeland.hackerhub.issue.Issue;
import cz.codeland.hackerhub.issue.IssueManager;
import cz.codeland.hackerhub.issue.IssueManagerFactory;
import cz.codeland.hackerhub.problem.Problem;
import cz.codeland.hackerhub.problem.ProblemReader;
import cz.codeland.hackerhub.repository.Repository;
import cz.codeland.hackerhub.repository.RepositoryPicker;
import cz.codeland.hackerhub.repository.RepositoryPickerFactory;

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
  private ClientType[]     clientTypes;
  private IssueManager     issueManager;
  private Repository       selectedRepository;
  private Issue            createdIssue;

  public HackerHub()
  {
  }

  public static void main(String[] args)
  {
    HackerHub hackerHub = new HackerHub();
    hackerHub.defineProblem();
    hackerHub.listClients();
    hackerHub.selectClient();
    hackerHub.setCredentials();

    System.out.println("Reading repositories...");
    hackerHub.readRepositories();
    hackerHub.listRepositories();
    hackerHub.selectRepository();

    System.out.println("Creating issue...");
    hackerHub.createIssueManager();
    Issue createdIssue = hackerHub.createIssue();
    System.out.printf("Issue created:%n Title: %s%n", createdIssue.getTitle());

    System.out.println("Creating file...");
    String path = hackerHub.createFile();
    System.out.printf("File created:%n Path: %s%n", path);

    System.out.println("Done. Bye.");
  }

  public String createFile()
  {
    String path = null;
    try {
      String content = Helper.readFile(Configuration.getInstance().getTemplatePath(), Charset.defaultCharset());
      String commitMessage = "init #" + createdIssue.getNumber() + " " + createdIssue.getTitle();
      path = problem.getShortName() + Configuration.getInstance().getRemotePath();
      selectedRepository.createContent(client, content, commitMessage, path);
    } catch (IOException e) {
      System.out.println("An error during creating the File.");
      e.printStackTrace();
    }
    return path;
  }

  public Issue createIssue()
  {
    try {
      createdIssue = issueManager.createIssue(client, selectedRepository, problem);
    } catch (IOException e) {
      System.out.println("An error during creating the Issue.");
      e.printStackTrace();
    }
    return createdIssue;
  }

  public IssueManager createIssueManager()
  {
    issueManager = IssueManagerFactory.createIssueManager(clientType);
    return issueManager;
  }

  public void listClients()
  {
    clientTypes = ClientType.values();
    for (int i = 0; i < clientTypes.length; i++) {
      System.out.printf("%3d) %s%n", i, clientTypes[i]);
    }
  }

  public void selectClient()
  {
    do {
      try {
        int index = Helper.readInteger("Choose the client by the index.");
        clientType = clientTypes[index];
        break;
      } catch (IndexOutOfBoundsException ignored) {
        System.out.println("Please insert correct index.");
      }
    } while (true);
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

  public Client setCredentials()
  {
    client = ClientFactory.createClient(clientType).setCredentials();
    return client;
  }

  public Repository selectRepository()
  {
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

  public List<Repository> readRepositories()
  {
    repositoryPicker = RepositoryPickerFactory.createRepositoryPicker(clientType);
    repositories = repositoryPicker.getRepositories(client);
    return repositories;
  }
}
