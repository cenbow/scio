package com.scio.cloud.jwt.web;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * UserInfoRestController
 *
 * @author Wang.ch
 * @date 2019-03-27 18:32:10
 */
@RestController
public class UserInfoRestController {

  @RequestMapping("/info")
  public String info(Principal principal) {
    return principal.getName();
  }
}
