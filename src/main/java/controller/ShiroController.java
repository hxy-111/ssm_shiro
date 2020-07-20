package controller;

import model.User;
import service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class ShiroController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "login"})
    public String login(Model model, HttpSession session) {
        int hashcodeV = UUID.randomUUID().hashCode();

        if (hashcodeV < 0) {
            hashcodeV = -hashcodeV;
        }
        String uuidsalt = String.format("%016d", hashcodeV);
        /**
         * uuidsalt的值，同时保存到前后端
         */
        model.addAttribute("uuidsalt", uuidsalt);
        session.setAttribute("uuidsalt", uuidsalt);

        return "/login";
    }


    @PostMapping("/login")
    public String login(String username, String password) {
        Subject loginUser = SecurityUtils.getSubject();

        /**
         * isAuthenticated方法判断有没有用户登录
         */
        if (!loginUser.isAuthenticated()) {
            /**
             * 如果用户还没登入，就把传递过来的用户名个密码封装到UsernamePasswordToken
             */
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            /**
             * 开启记住密码
             */
            token.setRememberMe(true);
            try {
                /**
                 * 用户名密码不对抛出异常
                 */
                loginUser.login(token);
            } catch (Exception e) {
                e.printStackTrace();
                return "/loginError";
            }

            return "redirect:/admin/main";
        }
        return "redirect:/admin/main";
    }

    @GetMapping("/zhuce1")
    public String zhuce() {
        return "/zuce";
    }

    @PostMapping("/zhuce")
    public String zhuce(User user){
        userService.insert(user);
    return "/login";
    }


    @GetMapping("/admin/main")
    public String index() {
        return "/admin/main";
    }

    @GetMapping("/admin/userlist")
    public String userlist() {
        return "/admin/userlist";
    }

    @GetMapping("/admin/adduser")
    public String adduser() {
        return "/admin/adduser";
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "/unauthorized";
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

}
