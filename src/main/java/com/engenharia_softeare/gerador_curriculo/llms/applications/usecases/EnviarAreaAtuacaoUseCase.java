package com.engenharia_softeare.gerador_curriculo.llms.applications.usecases;

import com.engenharia_softeare.gerador_curriculo.llms.infra.controllers.dto.request.AreaAtuacaoRequestDTO;
import com.engenharia_softeare.gerador_curriculo.shared.constants.ConstantsUtils;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

@Service
public class EnviarAreaAtuacaoUseCase {

    private final ChatModel chatModel;

    public EnviarAreaAtuacaoUseCase(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String enviar(AreaAtuacaoRequestDTO dto) {
        try {
             ChatResponse response = chatModel.call((
                    new Prompt(ConstantsUtils.promptAreaAtuacao(dto.areaAtuacao()), OllamaOptions.builder()
                            .model(OllamaModel.LLAMA3)
                            .temperature(0.2)
                            .format("json")
                            .build())
            ));

             return response.getResult().getOutput().getText();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar : ", e);
        }
    }
}
