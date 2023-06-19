package com.nijigasaki.knowledge.service;

import com.nijigasaki.knowledge.common.utils.SpringContextUtil;
import com.nijigasaki.knowledge.service.article.ArticleService;
import com.nijigasaki.knowledge.service.history.HistoryService;
import com.nijigasaki.knowledge.service.message.MessageService;
import com.nijigasaki.knowledge.service.rank.RankService;
import com.nijigasaki.knowledge.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceFactory {
    private static UserService userService;
    private static ArticleService articleService;
    private static HistoryService historyService;
    private static RankService rankService;
    private static MessageService messageService;



    private static final ConcurrentHashMap<Class<?>, Object> serviceMap = new ConcurrentHashMap<>();

    private static UserService getUserService() {
        if (userService == null) {
            userService = SpringContextUtil.getBean(UserService.class);
        }
        return userService;
    }

    private static ArticleService getArticleService() {
        if (articleService == null) {
            articleService = SpringContextUtil.getBean(ArticleService.class);
        }
        return articleService;
    }

    public static MessageService getMessageService() {
        if (messageService == null) {
            messageService = SpringContextUtil.getBean(MessageService.class);
        }
        return messageService;
    }

    public static HistoryService getHistoryService() {
        if (historyService == null) {
            historyService = SpringContextUtil.getBean(HistoryService.class);
        }
        return historyService;
    }

    public static RankService getRankService() {
        if (rankService == null) {
            rankService = SpringContextUtil.getBean(RankService.class);
        }
        return rankService;
    }

    static {
        serviceMap.put(UserService.class, getUserService());
        serviceMap.put(ArticleService.class, getArticleService());
        serviceMap.put(MessageService.class,getMessageService());
        serviceMap.put(HistoryService.class,getHistoryService());
        serviceMap.put(RankService.class,getRankService());
    }

    public static <T> T getService(Class<T> tClass) {
        if (tClass == null){
            return null;
        }
        Set<Map.Entry<Class<?>, Object>> entries = serviceMap.entrySet();
        for (Map.Entry<Class<?>, Object> entry : entries) {
            Class<?> key = entry.getKey();
            if (tClass.equals(key)) {
                Object value = entry.getValue();
                if (tClass.isInstance(value)) {
                    return tClass.cast(value);
                }
            }
        }
        return null;
    }
}
