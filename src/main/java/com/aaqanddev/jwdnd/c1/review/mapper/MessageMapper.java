package com.aaqanddev.jwdnd.c1.review.mapper;

import com.aaqanddev.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getMessages();

    @Select("SELECT * FROM MESSAGES WHERE messageid=#{msgId}")
    ChatMessage getMessageById(Integer msgId);

    @Insert("INSERT INTO MESSAGES(username, messagetext) VALUES(#{username), #{messagetext}")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insertMessage(ChatMessage message);

    @Delete("DELETE from MESSAGES WHERE messageid=#{msgId}")
    void deleteMessage(Integer msgId);
}
