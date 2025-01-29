package com.thortful.integration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class WireMockExtension implements AfterEachCallback, ParameterResolver {

  private WireMockServer wireMockServer;

  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    wireMockServer.resetAll();
  }

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return parameterContext.getParameter().getType().equals(WireMockServer.class)
        && parameterContext.isAnnotated(WireMockInstance.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    wireMockServer = new WireMockServer(options()
        .notifier(new ConsoleNotifier(true))
        .dynamicPort()
    );
    wireMockServer.start();
    return wireMockServer;
  }
}
