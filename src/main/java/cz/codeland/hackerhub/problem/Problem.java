package cz.codeland.hackerhub.problem;

import cz.codeland.hackerhub.helper.Helper;

import java.net.MalformedURLException;

public class Problem
{
  String name;
  String shortName;
  String link;

  public void setLink(String link) throws MalformedURLException
  {
    this.link = link;
    this.shortName = Helper.parseLink(link);
  }

  @Override
  public String toString()
  {
    return "{ " + this.name + "(" + this.shortName + "), " + this.link + " }";
  }

  public String getShortName()
  {
    return shortName;
  }

  public String getLink()
  {
    return link;
  }

  public String getName()
  {
    return name;
  }
}
