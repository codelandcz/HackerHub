package cz.codeland.hackerhub;

public class Main
{
  public static void main(String[] args)
  {
    ProblemReader reader = new ProblemReader();
    Problem problem = reader.loadProblem();
    System.out.println(problem.toString());

    ClientFactory factory;
    Client client;

    factory = new GitHubFactory();

    try {

      client = factory.createClient(ClientType.GITHUB);
      client.getRepositories();

    } catch (ClientTypeException e) {
      System.out.println(e.getMessage());
    }

  }
}
