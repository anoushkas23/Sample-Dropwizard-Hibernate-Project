@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Sample-dw-hibernate startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and SAMPLE_DW_HIBERNATE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\Sample-dw-hibernate-1.0-SNAPSHOT.jar;%APP_HOME%\lib\dropwizard-hibernate-1.2.2.jar;%APP_HOME%\lib\dropwizard-db-1.2.2.jar;%APP_HOME%\lib\dropwizard-core-1.2.2.jar;%APP_HOME%\lib\usertype.core-6.0.1.GA.jar;%APP_HOME%\lib\hibernate-entitymanager-5.2.1.Final.jar;%APP_HOME%\lib\hibernate-core-5.2.12.Final.jar;%APP_HOME%\lib\dropwizard-jersey-1.2.2.jar;%APP_HOME%\lib\dropwizard-request-logging-1.2.2.jar;%APP_HOME%\lib\dropwizard-jetty-1.2.2.jar;%APP_HOME%\lib\dropwizard-metrics-1.2.2.jar;%APP_HOME%\lib\dropwizard-lifecycle-1.2.2.jar;%APP_HOME%\lib\jetty-webapp-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-servlet-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-security-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-server-9.4.7.v20170914.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\jersey-bean-validation-2.25.1.jar;%APP_HOME%\lib\jersey-container-servlet-2.25.1.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.25.1.jar;%APP_HOME%\lib\jersey-server-2.25.1.jar;%APP_HOME%\lib\jersey-metainf-services-2.25.1.jar;%APP_HOME%\lib\jersey-client-2.25.1.jar;%APP_HOME%\lib\jersey-media-jaxb-2.25.1.jar;%APP_HOME%\lib\jersey-common-2.25.1.jar;%APP_HOME%\lib\hk2-locator-2.5.0-b32.jar;%APP_HOME%\lib\javassist-3.20.0-GA.jar;%APP_HOME%\lib\mysql-connector-java-5.1.31.jar;%APP_HOME%\lib\h2-2.1.210.jar;%APP_HOME%\lib\jaxb-runtime-2.3.2.jar;%APP_HOME%\lib\stax-ex-1.8.1.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.2.jar;%APP_HOME%\lib\dropwizard-configuration-1.2.2.jar;%APP_HOME%\lib\dropwizard-logging-1.2.2.jar;%APP_HOME%\lib\dropwizard-jackson-1.2.2.jar;%APP_HOME%\lib\dropwizard-validation-1.2.2.jar;%APP_HOME%\lib\dropwizard-servlets-1.2.2.jar;%APP_HOME%\lib\dropwizard-util-1.2.2.jar;%APP_HOME%\lib\metrics-servlets-3.2.5.jar;%APP_HOME%\lib\metrics-jvm-3.2.5.jar;%APP_HOME%\lib\metrics-logback-3.2.5.jar;%APP_HOME%\lib\metrics-jersey2-3.2.5.jar;%APP_HOME%\lib\metrics-jetty9-3.2.5.jar;%APP_HOME%\lib\metrics-json-3.2.5.jar;%APP_HOME%\lib\metrics-core-3.2.5.jar;%APP_HOME%\lib\metrics-healthchecks-3.2.5.jar;%APP_HOME%\lib\argparse4j-0.7.0.jar;%APP_HOME%\lib\jetty-setuid-java-1.0.3.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.0.1.Final.jar;%APP_HOME%\lib\hibernate-validator-5.4.1.Final.jar;%APP_HOME%\lib\jboss-logging-3.3.0.Final.jar;%APP_HOME%\lib\jboss-transaction-api_1.2_spec-1.0.1.Final.jar;%APP_HOME%\lib\dom4j-1.6.1.jar;%APP_HOME%\lib\hibernate-jpa-2.1-api-1.0.0.Final.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jandex-2.0.3.Final.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.8.jar;%APP_HOME%\lib\jakarta.activation-api-1.2.1.jar;%APP_HOME%\lib\txw2-2.3.2.jar;%APP_HOME%\lib\FastInfoset-1.2.16.jar;%APP_HOME%\lib\jackson-datatype-hibernate5-2.9.1.jar;%APP_HOME%\lib\jackson-datatype-guava-2.9.1.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.9.1.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.9.1.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.9.1.jar;%APP_HOME%\lib\jackson-module-afterburner-2.9.1.jar;%APP_HOME%\lib\jackson-datatype-joda-2.9.1.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.9.1.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.9.1.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.9.1.jar;%APP_HOME%\lib\jackson-databind-2.9.1.jar;%APP_HOME%\lib\jackson-annotations-2.9.0.jar;%APP_HOME%\lib\guava-23.1-jre.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\profiler-1.0.2.jar;%APP_HOME%\lib\joda-time-2.9.9.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.9.1.jar;%APP_HOME%\lib\jackson-core-2.9.1.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.25.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.25.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.25.jar;%APP_HOME%\lib\metrics-annotation-3.2.5.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\logback-classic-1.2.3.jar;%APP_HOME%\lib\javax.el-3.0.0.jar;%APP_HOME%\lib\commons-lang3-3.6.jar;%APP_HOME%\lib\logback-access-1.2.3.jar;%APP_HOME%\lib\logback-core-1.2.3.jar;%APP_HOME%\lib\jetty-servlets-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-http-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-io-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-xml-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-util-9.4.7.v20170914.jar;%APP_HOME%\lib\jetty-continuation-9.4.7.v20170914.jar;%APP_HOME%\lib\classmate-1.3.1.jar;%APP_HOME%\lib\tomcat-jdbc-8.5.23.jar;%APP_HOME%\lib\usertype.spi-6.0.1.GA.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\tomcat-juli-8.5.23.jar;%APP_HOME%\lib\error_prone_annotations-2.0.18.jar;%APP_HOME%\lib\j2objc-annotations-1.1.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.14.jar;%APP_HOME%\lib\snakeyaml-1.18.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\hk2-api-2.5.0-b32.jar;%APP_HOME%\lib\javax.inject-2.5.0-b32.jar;%APP_HOME%\lib\jersey-guava-2.25.1.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\hk2-utils-2.5.0-b32.jar;%APP_HOME%\lib\aopalliance-repackaged-2.5.0-b32.jar;%APP_HOME%\lib\javax.inject-1.jar


@rem Execute Sample-dw-hibernate
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %SAMPLE_DW_HIBERNATE_OPTS%  -classpath "%CLASSPATH%"  %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable SAMPLE_DW_HIBERNATE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%SAMPLE_DW_HIBERNATE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
