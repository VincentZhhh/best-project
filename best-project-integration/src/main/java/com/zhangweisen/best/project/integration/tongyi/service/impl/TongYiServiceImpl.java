package com.zhangweisen.best.project.integration.tongyi.service.impl;

import com.alibaba.cloud.ai.tongyi.audio.api.SpeechClient;
import com.alibaba.dashscope.audio.tts.SpeechSynthesisAudioFormat;
import com.zhangweisen.best.project.integration.tongyi.service.AbstractTongYiServiceImpl;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.StreamingChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TongYiServiceImpl extends AbstractTongYiServiceImpl {
    /**
     * 自动注入ChatClient、StreamingChatClient，屏蔽模型调用细节
     */
    private final ChatClient chatClient;

    private final ImageClient imageClient;

    private final SpeechClient speechClient;

    private final StreamingChatClient streamingChatClient;

    @Autowired
    public TongYiServiceImpl(ChatClient chatClient, StreamingChatClient streamingChatClient, ImageClient imageClient, SpeechClient speechClient) {
        this.chatClient = chatClient;
        this.streamingChatClient = streamingChatClient;
        this.imageClient = imageClient;
        this.speechClient = speechClient;
    }
    /**
     * 具体实现：
     */
    @Override
    public String completion(String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatClient.call(prompt).getResult().getOutput().getContent();
    }

    @Override
    public ImageResponse genImg(String imgPrompt) {
        var prompt = new ImagePrompt(imgPrompt);
        return imageClient.call(prompt);
    }

    @Override
    public String genAudio(String text) {
        var resWAV = speechClient.call(text);
        return resWAV.toString();
    }
}
