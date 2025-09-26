package com.engenharia_softeare.gerador_curriculo.shared.config;

import com.engenharia_softeare.gerador_curriculo.shared.constants.ConstantsUtils;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

@Service
public class PromptShared {

    private final ChatModel chatModel;

    public PromptShared(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public ChatResponse montarModel(String contexto) {
        return chatModel.call((
                new Prompt(contexto, OllamaOptions.builder()
                        .model(OllamaModel.LLAMA3)
                        .temperature(0.2)
                        .format("json")
                        .build())
        ));
    }
}
