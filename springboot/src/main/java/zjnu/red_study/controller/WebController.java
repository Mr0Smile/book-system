package zjnu.red_study.controller;

import jakarta.annotation.Resource;
import zjnu.red_study.common.Result;
import zjnu.red_study.entity.Account;
import zjnu.red_study.entity.User;
import zjnu.red_study.service.AdminService;
import zjnu.red_study.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;

    /**
     * 默认请求接口
     */
    @GetMapping("/")
    public Result hello() {
        return Result.success();
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        Account ac = null;
        if ("ADMIN".equals(account.getRole())) {
            ac = adminService.login(account);
        } else if ("USER".equals(account.getRole())) {
            ac = userService.login(account);
        }
        return Result.success(ac);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.register(user);
        return Result.success();
    }

    // @PostMapping("/register")
    // public Result register(@RequestBody User user) {
    // // 创建密码加密器
    // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //
    // // 加密用户密码
    // String encodedPassword = passwordEncoder.encode(user.getPassword());
    // user.setPassword(encodedPassword); // 设置加密后的密码
    //
    // userService.register(user); // 注册用户
    // return Result.success();
    // }

    /**
     * 修改密码
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account) {
        if ("ADMIN".equals(account.getRole())) {
            adminService.updatePassword(account);
        } else if ("USER".equals(account.getRole())) {
            userService.updatePassword(account);
        }
        return Result.success();
    }

}
