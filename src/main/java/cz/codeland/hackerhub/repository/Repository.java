package cz.codeland.hackerhub.repository;

import cz.codeland.hackerhub.client.Client;

import java.io.IOException;

public interface Repository
{
  String getName();

  String getHtmlUrl();

  void createContent(Client client, String content, String commitMessage, String path) throws IOException;
}
