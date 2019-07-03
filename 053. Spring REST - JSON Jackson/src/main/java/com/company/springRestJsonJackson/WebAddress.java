package com.company.springRestJsonJackson;

public class WebAddress {

	private String Path;
	private String RootDomain;
	private String TopLevelDomain;

	public WebAddress() {
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String getRootDomain() {
		return RootDomain;
	}

	public void setRootDomain(String rootDomain) {
		RootDomain = rootDomain;
	}

	public String getTopLevelDomain() {
		return TopLevelDomain;
	}

	public void setTopLevelDomain(String topLevelDomain) {
		TopLevelDomain = topLevelDomain;
	}

	@Override
	public String toString() {
		return "WebAddress [Path=" + Path + ", RootDomain=" + RootDomain + ", TopLevelDomain=" + TopLevelDomain + "]";
	}
}