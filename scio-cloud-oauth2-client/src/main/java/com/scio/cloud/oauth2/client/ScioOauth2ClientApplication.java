package com.scio.cloud.oauth2.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
/**
 * scio-cloud-oauth2-resource
 *
 * <pre>
 * Document: https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.RELEASE/single/spring-cloud-netflix.html#netflix-zuul-starter
 * Dependencies: scio-cloud-oauth2,scio-cloud-oauth2-resource
 *
 * authorize url: http://localhost:8003/oauth/authorize?response_type=code&client_id=client1&redirect_uri=http://www.baidu.com
 * authorize code: http://localhost:8003/oauth/token
 *                  -dgrant_type=authorization_code
 *                  -dclient_id=client1
 *                  -dclient_secret=123456
 *                  -dcode=ASp8Zb
 *                  -dredirect_uri=http://www.baidu.com
 * refesh_token: http://localhost:8003/oauth/token
 *                -dgrant_type=refresh_token
 *                -dclient_id=client1
 *                -dclient_secret=123456
 *                -drefresh_token=16ea4250-884f-4ca2-ac72-1c3d44550de0
 *
 * password: http://localhost:8003/oauth/token
 *                -dgrant_type=password
 *                -dclient_id=client1
 *                -dclient_secret=123456
 *                -dusername=mp1
 *                -dpassword=mp1
 *
 * client_credentials: http://localhost:8003/oauth/token
 *                      -dgrant_type=client_credentials
 *                      -dclient_id=client1
 *                      -dclient_secret=123456
 *
 * </pre>
 *
 * @doc https://docs.spring.io/spring-security-oauth2-boot/docs/2.1.0.RELEASE/reference/htmlsingle/
 * @author Wang.ch
 * @date 2019-3-20 15:00:50
 */
@SpringBootApplication
@EnableZuulProxy
@ComponentScan(basePackages = "com.scio.cloud.oauth2.client")
// @EnableOAuth2Sso
@EnableOAuth2Client
public class ScioOauth2ClientApplication {

  public static void main(String[] args) {
    // ProxyAuthenticationProperties
    SpringApplication.run(ScioOauth2ClientApplication.class, args);
  }
}
