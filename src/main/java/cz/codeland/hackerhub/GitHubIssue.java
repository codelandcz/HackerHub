package cz.codeland.hackerhub;

public class GitHubIssue implements Issue
{
  String                             title;
  String                             body;
  String                             htmlUrl;
  org.eclipse.egit.github.core.Issue issue;

  public GitHubIssue()
  {
  }

  public Issue setTitle(String title)
  {
    this.title = title;
    return this;
  }

  public Issue setBody(String body)
  {
    this.body = body;

    return this;
  }

  public void setHtmlUrl(String htmlUrl)
  {
    this.htmlUrl = htmlUrl;
  }

  public Issue setIssue(org.eclipse.egit.github.core.Issue issue)
  {
    this.issue = issue;
    this.setTitle(issue.getTitle());
    this.setBody(issue.getBody());
    this.setHtmlUrl(issue.getHtmlUrl());

    return this;
  }

  @Override
  public String getTitle()
  {
    return this.title;
  }

  @Override
  public String getBody()
  {
    return body;
  }

  @Override
  public String getHtmlUrl()
  {
    return htmlUrl;
  }

  public org.eclipse.egit.github.core.Issue getIssue()
  {
    return issue;
  }

}
