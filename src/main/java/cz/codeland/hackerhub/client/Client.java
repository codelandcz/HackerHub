package cz.codeland.hackerhub.client;

public interface Client
{
  Client setCredentials();

  String getUsername();

  String getPassword();
}
