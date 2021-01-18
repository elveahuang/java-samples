package cn.elvea.client.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AuthController
 *
 * @author elvea
 */
@Controller
public class AuthController {

    @GetMapping("/authorized")
    public String index(Model model,
                        @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
                        @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("userName", principal.getName());
        model.addAttribute("clientName", client.getClientRegistration().getClientName());
        model.addAttribute("userAttributes", principal.getAttributes());
        return "index";
    }

    @RequestMapping("/login/oauth/callback/github")
    public String githubCallback(
            Model model,
            @RegisteredOAuth2AuthorizedClient("github") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OAuth2User principal
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("userName", principal.getName());
        model.addAttribute("userAttributes", principal.getAttributes());
        return "callback";
    }

    @GetMapping("/login/oauth/callback/authorization-server")
    public String authorizationServerCallback(
            Model model,
            @RegisteredOAuth2AuthorizedClient("authorization-server") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OAuth2User principal
    ) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("userName", principal.getName());
//        model.addAttribute("userAttributes", principal.getAttributes());
        return "callback";
    }

}
