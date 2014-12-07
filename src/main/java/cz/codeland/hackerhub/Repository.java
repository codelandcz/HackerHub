package cz.codeland.hackerhub;

import java.io.IOException;

public interface Repository
{
  String getName();

  String getHtmlUrl();

  void createContent(Client client, String content, String commitMessage, String path) throws IOException;
}
