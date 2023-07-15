package com.nijigasaki.knowledge.service.message;

public interface CommentService extends MessageService{
    Long countByArticleId(Long id);
}
