package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nijigasaki.knowledge.common.enums.basic.ArticleStatus;
import com.nijigasaki.knowledge.common.enums.basic.Visibility;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
//@TableName
public class Article extends BaseEntity{
    private String authorName;
    private String title;
    private Integer visibility;
    private Integer articleStatus;
    private Long collectionId;


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
