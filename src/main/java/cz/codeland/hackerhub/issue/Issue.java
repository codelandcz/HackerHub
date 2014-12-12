package cz.codeland.hackerhub.issue;

public interface Issue
{
  Issue setTitle(String title);

  Issue setBody(String body);

  String getTitle();

  String getBody();

  String getHtmlUrl();

  int getNumber();
}
