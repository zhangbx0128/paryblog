package com.baixin.im.message;

import com.baixin.im.vo.ImTo;
import com.baixin.im.vo.ImUser;
import lombok.Data;

@Data
public class ChatImMess {

    private ImUser mine;
    private ImTo to;

}
