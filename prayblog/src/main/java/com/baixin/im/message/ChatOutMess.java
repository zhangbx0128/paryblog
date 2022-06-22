package com.baixin.im.message;

import com.baixin.im.vo.ImMess;
import lombok.Data;

@Data
public class ChatOutMess {

    private String emit;
    private ImMess data;

}
