package com.yetao.blog.controller.admin;

import com.yetao.blog.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/1 15:17
 */

@RestController
@RequestMapping("admin/image")
public class AdminImageController {

    @PostMapping
    public Result uploadImage() {
        return null;
    }

    @DeleteMapping("{imageId}")
    public Result delImage(@PathVariable("imageId") String imageId) {
        return null;
    }

//    @PutMapping("{imageId}")
//    public Result updateImage(@PathVariable("imageId") String imageId, @RequestBody Image image) {
//        return null;
//    }

    @GetMapping("{imageId}")
    public Result getImage(@PathVariable("imageId") String imageId) {
        return null;
    }

    @GetMapping("list")
    public Result listImage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return null;
    }
}
