package com.nijigasaki.knowledge.model.vo;

import com.nijigasaki.knowledge.common.enums.basic.ArticleStatus;
import com.nijigasaki.knowledge.common.enums.basic.Visibility;
import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ApiModel("文章详情页面")
public class ArticleInfoVO {
    @ApiModelProperty("作者名")
    private String authorName;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("文章详细内容")
    private String content;
    @ApiModelProperty("是否可见")
    private String visibility;
    @ApiModelProperty("文章当前状态")
    private String articleStatus;
    @ApiModelProperty("头图地址")
    private String headPicUrl;
    @ApiModelProperty("所属合集名称")
    private String collectionName;
    @ApiModelProperty("收藏数")
    private Long favorites;
    @ApiModelProperty("点赞数")
    private Long likes;
    @ApiModelProperty("评论数")
    private Long comments;
    @ApiModelProperty("创作时间")
    private LocalDateTime createTime;
    public void setVisibility(Integer visibility) {
        Visibility byCode = Visibility.findByCode(visibility);
        if (Objects.isNull(byCode)) {
            throw new BusinessException(BusinessError.VISIBILITY_NOT_FOUND);
        }
        this.visibility = byCode.getDescription();
    }

    public void setArticleStatus(Integer articleStatus) {
        ArticleStatus byCode = ArticleStatus.findByCode(articleStatus);
        if (Objects.isNull(byCode)) {
            throw new BusinessException(BusinessError.ARTICLE_STATUS_NOT_FOUND);
        }
        this.articleStatus = byCode.getDescription();
    }
}
