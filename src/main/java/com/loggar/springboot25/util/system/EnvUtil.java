package com.loggar.springboot25.util.system;

import java.lang.invoke.MethodHandles;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvUtil {
  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Autowired
  Environment env;

  private String port;
  private String hostName;
  private String hostIp;

  @PostConstruct
  public void init() {
    logger.info("EnvUtil {} {} {}", getHostName(), getHostIp(), getPort());
  }

  /**
   * env: host port
   *
   * @return String
   */
  public String getPort() {
    if (port == null)
      port = env.getProperty("server.port");
    return port;
  }

  /**
   * env: host port
   *
   * @return Integer
   */
  public Integer getPortAsInt() {
    return Integer.valueOf(getPort());
  }

  /**
   * env: host name
   *
   * @return
   */
  public String getHostName() {
    if (hostName == null) {
      try {
        hostName = InetAddress.getLocalHost().getHostName();
      } catch (UnknownHostException e) {
        hostName = "UnknownHostException";
      }
    }
    return hostName;
  }

  /**
   * env: host ip
   *
   * @return
   */
  public String getHostIp() {
    if (hostIp == null) {
      try {
        hostIp = InetAddress.getLocalHost().getHostAddress();
      } catch (UnknownHostException e) {
        hostIp = "UnknownHostException";
      }
    }
    return hostIp;
  }
}
