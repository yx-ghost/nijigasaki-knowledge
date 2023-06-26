package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nijigasaki.knowledge.common.enums.basic.ArticleStatus;
import com.nijigasaki.knowledge.common.enums.basic.Visibility;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@TableName(value = "article")
public class Article extends BaseEntity{
    @TableField(value = "author_name")
    private String authorName;
    private String title;
    private Integer visibility;
    @TableField(value = "article_status")
    private Integer articleStatus;
    @TableField(value = "collection_id")
    private Long collectionId;
    @TableField(value = "head_pic_url")
    private String headPicUrl;

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility.getCode();
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }
    public void setArticleStatus(ArticleStatus articleStatus) {
        this.articleStatus = articleStatus.getCode();
    }
}
