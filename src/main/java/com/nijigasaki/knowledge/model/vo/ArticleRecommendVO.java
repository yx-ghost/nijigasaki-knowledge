package com.nijigasaki.knowledge.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRecommendVO {
    private String authorName;
    private String title;
    private Integer articleStatus;
    private String desc;
    private String headPicUrl;
}
