package cz.codeland.hackerhub;

public interface ClientFactory
{
  Client createClient(ClientType clientType) throws ClientTypeException;
}
