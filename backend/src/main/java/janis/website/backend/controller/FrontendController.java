package janis.website.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

  @RequestMapping(value = "/**/{path:[^.]*}")
  public String redirect() {
    // Forward to index.html so Angular can handle the routing
    return "forward:/";
  }
}
