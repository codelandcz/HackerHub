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
  }
}
