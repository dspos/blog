package com.yetao.blog.controller.admin;

import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/1 15:29
 */

@RestController
@RequestMapping("admin/friend_link")
public class AdminFriendLinkController {

//    @PostMapping
//    public Result addFriendLink(@RequestBody FriendLink friendLink) {
//        return null;
//    }

    @DeleteMapping("{friendLinkId}")
    public Result delFriendLink(@PathVariable("friendLinkId") String friendLinkId) {
        return null;
    }

    @PutMapping("{friendLinkId}")
    public Result updateFriendLink(@PathVariable("friendLinkId") String friendLinkId) {
        return null;
    }

    @GetMapping("{friendLinkId}")
    public Result getFriendLink(@PathVariable("friendLinkId") String friendLinkId) {
        return null;
    }

    @GetMapping("list")
    public Result listFriendLinks(@RequestParam("page") int page, @RequestParam("size") int size) {
        return null;
    }
}
