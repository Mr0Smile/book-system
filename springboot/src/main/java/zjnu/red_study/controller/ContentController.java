package zjnu.red_study.controller;

import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import zjnu.red_study.common.Result;
import zjnu.red_study.entity.Content;
import zjnu.red_study.service.ContentService;

import java.util.List;

/**
 * 书籍内容相关的控制器
 **/
@RestController
@RequestMapping("/content")
public class ContentController {

    @Resource
    private ContentService contentService;

    @GetMapping("/getByArticleId/{articleId}")
    public Result getContentByArticleId(@PathVariable Integer articleId) {
        List<Content> contentList = contentService.getContentByArticleId(articleId);

        // 为图片内容拼接图片的相对路径，避免重复拼接
        for (Content content : contentList) {
            if (content.getContentType() == 1) {  // content_type 为 1 表示图片
                // 如果 content 字段中已经包含 "/images/"，则不需要再次拼接
                if (!content.getContent().startsWith("/images/")) {
                    content.setContent("/images/" + content.getContent());
                }
            }
        }

        return Result.success(contentList);
    }
}



