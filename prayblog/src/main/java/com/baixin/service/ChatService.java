package com.baixin.service;

import com.baixin.im.vo.ImMess;
import com.baixin.im.vo.ImUser;

import java.util.List;

public interface ChatService {
    ImUser getCurrentUser();

    void setGroupHistoryMsg(ImMess responseMess);

    List<Object> getGroupHistoryMsg(int count);
}
