package cz.codeland.hackerhub;

import java.net.MalformedURLException;

public class ProblemReader
{
  Problem loadProblem()
  {
    Problem problem = new Problem();
    problem.name = Helper.readString("Name of the problem.");
    do {
      try {
        problem.setLink(Helper.readString("Link to the problem."));
        break;
      } catch (MalformedURLException e) {
        System.out.println(e.getMessage());
      }
    } while (true);

    return problem;
  }
}
