package com.luxu.basegit.controller;

import com.alibaba.fastjson.JSONObject;
import com.luxu.basegit.base.Result;
import com.luxu.basegit.base.ResultUtil;
import com.luxu.basegit.config.UserLoginToken;
import com.luxu.basegit.entity.User;
import com.luxu.basegit.exception.LoginBaseException;
import com.luxu.basegit.service.TokenService;
import com.luxu.basegit.service.UserService;
import com.luxu.basegit.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {
    private final Logger log= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;


    @GetMapping("getUser/{id}")
    public Result GetUser(@PathVariable int id){
        User user=userService.selectUserById(id);
        return ResultUtil.success(user);
    }

    @GetMapping("findAll")
    public Result findAll(){
        List<User> list=userService.findAll();
        log.info("进入测试，参数list的值为:{}", list);
        return ResultUtil.success(list);
    }

    // 登录
    @GetMapping("/login")
    public Result login(User user, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = new User();
        userForBase.setId("1");
        userForBase.setPassWord("1211");
        userForBase.setUserName("mrc");

        if (!userForBase.getPassWord().equals(user.getPassWord())) {
            jsonObject.put("message", "登录失败,密码错误");
            return ResultUtil.error(1001,"登录失败,密码错误") ;
        } else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);

            return ResultUtil.success(jsonObject);

        }
    }

    /***
     * 这个请求需要验证token才能访问
     *
     * @author: MRC
     * @date 2019年5月27日 下午5:45:19
     * @return String 返回类型
     */
    @UserLoginToken
    @GetMapping("/getMessage")
    public Result getMessage() {
        String userId=null;
        userId= TokenUtil.getTokenUserId();

        // 取出token中带的用户id 进行操作
        log.info("进入测试，tokenId:{}", userId);
        return ResultUtil.success("你已通过验证");
    }

}
